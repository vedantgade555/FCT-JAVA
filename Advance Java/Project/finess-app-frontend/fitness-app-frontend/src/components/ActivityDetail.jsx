import React, { useEffect, useState } from 'react';
// useParams is a hook to grab the dynamic pieces of the URL (like the activity 'id')
import { useParams, useNavigate } from 'react-router';
// Import our API functions
import { getActivityById, getActivityDetail } from '../services/api';

const ActivityDetail = () => {
  // Grab the 'id' parameter from the URL (e.g. /activities/123 -> id = "123")
  const { id } = useParams();
  
  const navigate = useNavigate();

  // State to hold the core activity statistics
  const [activity, setActivity] = useState(null);
  
  // State to hold the AI generated recommendations for this activity
  const [recommendations, setRecommendations] = useState(null);
  
  // State to track the loading status of our network requests
  const [loading, setLoading] = useState(true);

  // This effect runs when the component loads, or whenever the 'id' variable changes
  useEffect(() => {
    // We define an async function to fetch multiple pieces of data
    const fetchDetails = async () => {
      try {
        // Promise.allSettled runs both API calls at the same time (concurrently)!
        // This is much faster than waiting for one to finish before starting the other.
        const [activityRes, recRes] = await Promise.allSettled([
          getActivityById(id), // Fetch raw activity stats
          getActivityDetail(id) // Fetch AI recommendations
        ]);

        // If the activity details were fetched successfully, save them to state
        if (activityRes.status === 'fulfilled') {
          setActivity(activityRes.value.data);
        }

        // If the AI recommendations were fetched successfully, save them to state
        if (recRes.status === 'fulfilled') {
          setRecommendations(recRes.value.data);
        }
      } catch (error) {
        console.error("Failed to fetch activity details:", error);
      } finally {
        // Turn off the loading spinner when both requests are finished
        setLoading(false);
      }
    };

    // Call the function we just defined
    fetchDetails();
  }, [id]);

  // If we are still waiting for network requests, show a loading spinner
  if (loading) {
    return (
      <div className="d-flex justify-content-center py-5">
        <div className="spinner-border text-primary" role="status">
          <span className="visually-hidden">Loading...</span>
        </div>
      </div>
    );
  }

  // If the activity data is completely missing after loading, show an error message
  if (!activity) {
    return (
      <div className="container py-5 text-center">
        <h4 className="text-danger">Activity not found.</h4>
        <button className="btn btn-premium mt-3" onClick={() => navigate('/activities')}>
          Back to Dashboard
        </button>
      </div>
    );
  }

  return (
    <div className="container py-5">
      {/* Back Button */}
      <button className="btn btn-premium-outline mb-4" onClick={() => navigate('/activities')}>
        <i className="bi bi-arrow-left me-2"></i> Back to Dashboard
      </button>

      <div className="row g-4">
        {/* LEFT COLUMN: Core Activity Stats */}
        <div className="col-lg-4">
          <div className="glass-card p-4 h-100">
            <h5 className="text-gradient fw-bold mb-4">Activity Summary</h5>
            
            <h3 className="fw-bold mb-3">{activity.type}</h3>
            
            <div className="d-flex align-items-center mb-3">
              <div className="bg-dark p-2 rounded-circle me-3 border border-secondary">
                <i className="bi bi-clock fs-4 text-info"></i>
              </div>
              <div>
                <div className="text-muted small">Duration</div>
                <div className="fw-bold fs-5">{activity.duration} <span className="small text-muted fw-normal">min</span></div>
              </div>
            </div>

            <div className="d-flex align-items-center mb-3">
              <div className="bg-dark p-2 rounded-circle me-3 border border-secondary">
                <i className="bi bi-fire fs-4 text-warning"></i>
              </div>
              <div>
                <div className="text-muted small">Calories Burned</div>
                <div className="fw-bold fs-5">{activity.caloriesBurned} <span className="small text-muted fw-normal">kcal</span></div>
              </div>
            </div>

            {/* Only show the start time if the backend provided one */}
            {activity.startTime && (
              <div className="d-flex align-items-center">
                <div className="bg-dark p-2 rounded-circle me-3 border border-secondary">
                  <i className="bi bi-calendar-event fs-4 text-success"></i>
                </div>
                <div>
                  <div className="text-muted small">Started</div>
                  <div className="fw-bold">{new Date(activity.startTime).toLocaleString()}</div>
                </div>
              </div>
            )}
          </div>
        </div>

        {/* RIGHT COLUMN: AI Recommendations */}
        <div className="col-lg-8">
          <div className="glass-card p-4 h-100">
            <h5 className="text-gradient fw-bold mb-4">
              <i className="bi bi-robot me-2"></i> AI Recommendations
            </h5>
            
            {/* The AI takes time to generate recommendations. 
                If 'recommendations' is null, it means it's still processing! */}
            {!recommendations ? (
              <div className="text-center py-5">
                <i className="bi bi-hourglass-split fs-1 text-muted d-block mb-3"></i>
                <p className="text-muted">No recommendations generated for this activity yet.<br/>The AI might still be processing it.</p>
              </div>
            ) : (
              // If recommendations exist, display them!
              <>
                {/* Main AI Summary Paragraph */}
                <p className="lead mb-4" style={{ color: '#e2e8f0' }}>
                  "{recommendations.recommendation}"
                </p>

                <hr style={{ borderColor: 'var(--border-glass)' }} className="my-4" />

                <div className="row g-4">
                  {/* If the AI provided 'improvements', render them in a list */}
                  {recommendations.improvements && recommendations.improvements.length > 0 && (
                    <div className="col-md-6">
                      <h6 className="fw-bold text-info mb-3">
                        <i className="bi bi-graph-up-arrow me-2"></i> How to Improve
                      </h6>
                      <ul className="premium-list">
                        {recommendations.improvements.map((item, idx) => (
                          <li key={idx}>{item}</li>
                        ))}
                      </ul>
                    </div>
                  )}

                  {/* If the AI provided 'suggestions', render them in a list */}
                  {recommendations.suggestions && recommendations.suggestions.length > 0 && (
                    <div className="col-md-6">
                      <h6 className="fw-bold text-success mb-3">
                        <i className="bi bi-lightbulb me-2"></i> Suggestions
                      </h6>
                      <ul className="premium-list">
                        {recommendations.suggestions.map((item, idx) => (
                          <li key={idx}>{item}</li>
                        ))}
                      </ul>
                    </div>
                  )}
                </div>

                {/* If the AI provided 'safety' tips, render them as colorful badges */}
                {recommendations.safety && recommendations.safety.length > 0 && (
                  <div className="mt-4">
                    <h6 className="fw-bold text-warning mb-3">
                      <i className="bi bi-shield-exclamation me-2"></i> Safety Tips
                    </h6>
                    <div className="d-flex gap-2 flex-wrap">
                      {recommendations.safety.map((item, idx) => (
                        <span key={idx} className="badge-premium">
                          {item}
                        </span>
                      ))}
                    </div>
                  </div>
                )}
              </>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ActivityDetail;
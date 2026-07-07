import React, { useState, useEffect } from 'react';
// useNavigate is a React Router hook that lets us programmatically change the URL
import { useNavigate } from 'react-router'; 
// Import our custom API function to fetch data from the backend
import { getActivities } from '../services/api';

const ActivityList = () => {
  // State to hold the list of activities fetched from the server.
  // We initialize it as an empty array `[]`.
  const [activities, setActivities] = useState([]);
  
  // State to track if we are currently waiting for the server to respond
  const [loading, setLoading] = useState(true);
  
  // Get the navigate function to change pages
  const navigate = useNavigate();

  // useEffect is a hook that runs after the component renders on the screen.
  // We pass an empty array `[]` at the end so it only runs ONCE when the component first loads.
  useEffect(() => {
    // We define an asynchronous function inside useEffect to handle the API call
    const fetchActivities = async () => {
      try {
        // Fetch data from the server
        const response = await getActivities();
        // Update our state with the data returned by the server
        setActivities(response.data);
      } catch (error) {
        // Log any errors if the server is unreachable
        console.error("Failed to fetch activities:", error);
      } finally {
        // Stop the loading spinner regardless of success or failure
        setLoading(false);
      }
    };

    // Call the function we just defined!
    fetchActivities();
  }, []);

  // If we are still waiting for data, show a spinning loading circle
  if (loading) {
    return (
      <div className="d-flex justify-content-center py-5">
        <div className="spinner-border text-primary" role="status">
          <span className="visually-hidden">Loading...</span>
        </div>
      </div>
    );
  }

  // If the server returned an empty list, show a friendly empty state message
  if (activities.length === 0) {
    return (
      <div className="text-center py-5 text-muted">
        <i className="bi bi-inbox fs-1 d-block mb-3"></i>
        <p>No activities found. Track your first activity above!</p>
      </div>
    );
  }

  // Once data is loaded, render the grid of activities
  return (
    <div className="row g-4">
      {/* We use `.map()` to loop over the array of activities and render a card for each one */}
      {activities.map((activity) => (
        // Every item in a mapped array needs a unique 'key' prop so React can track it
        <div className="col-sm-6 col-lg-4" key={activity.id}>
          <div 
            className="glass-card p-3 h-100" 
            style={{ cursor: 'pointer' }} 
            // When the card is clicked, navigate to the detailed view page for this activity
            onClick={() => navigate(`/activities/${activity.id}`)}
          >
            {/* Header: Activity Type */}
            <div className="d-flex justify-content-between align-items-center mb-3">
              <h5 className="m-0 fw-bold text-gradient">{activity.type}</h5>
              <i className="bi bi-arrow-right-circle text-muted fs-5"></i>
            </div>
            
            {/* Stat: Duration */}
            <div className="d-flex justify-content-between text-muted small mb-1">
              <span><i className="bi bi-clock me-1"></i> Duration</span>
              <span className="fw-bold text-white">{activity.duration} min</span>
            </div>
            
            {/* Stat: Calories */}
            <div className="d-flex justify-content-between text-muted small">
              <span><i className="bi bi-fire me-1"></i> Calories</span>
              <span className="fw-bold text-white">{activity.caloriesBurned} kcal</span>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
};

export default ActivityList;
import React, { useState } from "react";
// Import our custom API function to send data to the backend
import { addActivity } from "../services/api";

function ActivityForm({ onActivitiesAdded }) {
  // useState is a React Hook that lets you add state variables to your components.
  // Here, we store the form data (type, duration, calories).
  const [activity, setActivity] = useState({
    type: "RUNNING", // Default value
    duration: "",
    caloriesBurned: "",
    additionalMetrics: {},
  });

  // State to track if the form is currently submitting (used to show a loading spinner)
  const [loading, setLoading] = useState(false);

  // This function is called when the user clicks the "Add Activity" button
  const handleSubmit = async (event) => {
    // Prevent the default browser behavior of refreshing the page on form submit
    event.preventDefault();

    // Set loading to true so we can show a spinner on the button
    setLoading(true);

    try {
      // Prepare the data to be sent to the server.
      // We parse the text inputs into Integers (numbers) because our backend expects numbers.
      const payload = {
        ...activity, // copy the existing activity state
        duration: activity.duration ? parseInt(activity.duration, 10) : 0,
        caloriesBurned: activity.caloriesBurned
          ? parseInt(activity.caloriesBurned, 10)
          : 0,
      };

      // Send the payload to the backend API
      await addActivity(payload);

      // If the parent component passed down a function to refresh the list, call it now!
      if (onActivitiesAdded) {
        onActivitiesAdded();
      }

      // Clear the form by resetting our state back to default values
      setActivity({
        type: "RUNNING",
        duration: "",
        caloriesBurned: "",
        additionalMetrics: {},
      });
    } catch (error) {
      // If something goes wrong (e.g., network error), log it to the console
      console.error("Failed to add activity:", error);
    } finally {
      // Finally block always runs, whether success or error.
      // Stop the loading spinner.
      setLoading(false);
    }
  };

  return (
    <div className="glass-card p-4">
      <h4 className="mb-4 fw-bold">Track New Activity</h4>

      {/* 
        When the form is submitted, React will call our handleSubmit function.
      */}
      <form onSubmit={handleSubmit}>
        <div className="row g-3">
          {/* Activity Type Dropdown */}
          <div className="col-md-4">
            <label className="form-label">Activity Type</label>
            <select
              className="form-select"
              value={activity.type}
              // When the user selects a new option, update the 'type' in our state
              onChange={(e) =>
                setActivity({ ...activity, type: e.target.value })
              }
            >
              <option value="RUNNING">Running</option>
              <option value="WALKING">Walking</option>
              <option value="CYCLING">Cycling</option>
              <option value="SWIMMING">Swimming</option>
              <option value="WEIGHT_TRAINING">Weight Training</option>
              <option value="YOGA">Yoga</option>
              <option value="HIIT">HIIT</option>
              <option value="CARDIO">Cardio</option>
              <option value="STRETCHING">Stretching</option>
              <option value="OTHER">Other</option>
            </select>
          </div>

          {/* Duration Input Field */}
          <div className="col-md-4">
            <label className="form-label">Duration (Min)</label>
            <input
              type="number"
              className="form-control"
              placeholder="e.g. 30"
              value={activity.duration}
              // When the user types, update the 'duration' in our state
              onChange={(e) =>
                setActivity({ ...activity, duration: e.target.value })
              }
              required // Makes this field mandatory
            />
          </div>

          {/* Calories Input Field */}
          <div className="col-md-4">
            <label className="form-label">Calories Burned</label>
            <input
              type="number"
              className="form-control"
              placeholder="e.g. 300"
              value={activity.caloriesBurned}
              // When the user types, update the 'caloriesBurned' in our state
              onChange={(e) =>
                setActivity({ ...activity, caloriesBurned: e.target.value })
              }
              required // Makes this field mandatory
            />
          </div>
        </div>

        {/* Submit Button Area */}
        <div className="mt-4 text-end">
          {/* We disable the button while loading so the user doesn't click it twice */}
          <button
            type="submit"
            className="btn btn-premium px-5"
            disabled={loading}
          >
            {loading ? (
              // Show a loading spinner if 'loading' is true
              <span
                className="spinner-border spinner-border-sm me-2"
                role="status"
                aria-hidden="true"
              ></span>
            ) : (
              // Otherwise, show a plus icon
              <i className="bi bi-plus-circle me-2"></i>
            )}
            Add Activity
          </button>
        </div>
      </form>
    </div>
  );
}

export default ActivityForm;

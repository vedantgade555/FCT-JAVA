import { useContext, useEffect } from "react";
// Import authentication context to get login status and functions
import { AuthContext } from "react-oauth2-code-pkce";
// Import Redux hooks for global state management
import { useDispatch } from "react-redux";
// Import React Router components for navigating between different web pages
import {
  BrowserRouter as Router,
  Navigate,
  Route,
  Routes,
} from "react-router";

// Import our custom UI components
import ActivityForm from "./components/ActivityForm";
import ActivityList from "./components/ActivityList";
import ActivityDetail from "./components/ActivityDetail";
// Import Redux actions
import { setCredentials, logout } from "./store/authSlice";

// A functional component representing the main Activity Dashboard
const ActivityPage = () => (
  <div className="container py-5">
    {/* Form Section: Allows the user to add a new activity */}
    <div className="row mb-5">
      <div className="col-lg-8 mx-auto">
        {/* Pass a function to refresh the page when an activity is added */}
        <ActivityForm onActivitiesAdded={() => window.location.reload()} />
      </div>
    </div>
    
    {/* List Section: Displays all the activities the user has added */}
    <div className="row">
      <div className="col-12">
        <h3 className="mb-4 fw-bold">Recent Activities</h3>
        <ActivityList />
      </div>
    </div>
  </div>
);

// The main App component that renders everything on the screen
function App() {
  // Get authentication details (like the token and logIn/logOut functions) from the AuthContext
  const { token, tokenData, logIn, logOut } = useContext(AuthContext);
  
  // Create a 'dispatch' function to send actions to our Redux global store
  const dispatch = useDispatch();

  // useEffect runs a piece of code automatically when the component loads, 
  // or whenever the variables in the array (token, tokenData, dispatch) change.
  useEffect(() => {
    // If we have a valid login token, save it to our Redux state
    if (token) {
      dispatch(
        setCredentials({
          token: token,
          user: tokenData,
        })
      );
    }
  }, [token, tokenData, dispatch]); // Dependency array: watch these variables for changes

  // Function to handle when the user clicks the "Logout" button
  const handleLogout = () => {
    dispatch(logout()); // Clear the user data from Redux
    logOut(); // Clear the authentication session
  };

  // Convert the token string into a simple true/false boolean
  // If token exists, isLoggedIn is true. If it is null, isLoggedIn is false.
  const isLoggedIn = !!token;

  return (
    // Router allows us to define different URL paths for our app
    <Router>
      {!isLoggedIn ? (
        // --- DISPLAY THIS IF THE USER IS NOT LOGGED IN ---
        <div className="d-flex align-items-center justify-content-center min-vh-100">
          <div className="text-center p-5 glass-card" style={{ maxWidth: '450px', width: '100%' }}>
            <h1 className="fw-bold mb-4">
              <span className="text-gradient">Fitness</span>App
            </h1>
            <p className="text-muted mb-5">Welcome back! Please login to track your activities and view AI recommendations.</p>
            {/* The login button triggers the external Keycloak login flow */}
            <button
              className="btn btn-premium w-100 py-3"
              onClick={() => logIn()}
            >
              <i className="bi bi-shield-lock me-2"></i> Login with Keycloak
            </button>
          </div>
        </div>
      ) : (
        // --- DISPLAY THIS IF THE USER IS LOGGED IN ---
        <>
          {/* Top Navigation Bar */}
          <nav className="premium-nav">
            <div className="container d-flex justify-content-between align-items-center">
              <h4 className="m-0 fw-bold">
                <span className="text-gradient">Fitness</span>App
              </h4>
              <button
                className="btn btn-premium-outline"
                onClick={handleLogout}
              >
                Logout
              </button>
            </div>
          </nav>

          {/* Main Content Area where different pages will be rendered based on the URL */}
          <main className="container-fluid p-0">
            <Routes>
              {/* If the URL is '/activities', render the ActivityPage component */}
              <Route path="/activities" element={<ActivityPage />} />
              
              {/* If the URL has an ID like '/activities/123', render the details page */}
              <Route path="/activities/:id" element={<ActivityDetail />} />

              {/* If the user goes to the root URL ('/'), redirect them to '/activities' */}
              <Route
                path="/"
                element={<Navigate to="/activities" replace />}
              />
            </Routes>
          </main>
        </>
      )}
    </Router>
  );
}

export default App;
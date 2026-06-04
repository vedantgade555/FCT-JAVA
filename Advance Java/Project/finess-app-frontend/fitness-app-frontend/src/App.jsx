import { Button, Box } from "@mui/material";
import { useContext, useEffect } from "react";
import { AuthContext } from "react-oauth2-code-pkce";
import { useDispatch } from "react-redux";
import {
  BrowserRouter as Router,
  Navigate,
  Route,
  Routes,
} from "react-router";

import ActivityForm from "./components/ActivityForm";
import ActivityList from "./components/ActivityList";
import ActivityDetail from "./components/ActivityDetail";
import { setCredentials } from "./store/authSlice";

const ActivityPage = () => (
  <Box component="section" sx={{ p: 2, border: "1px dashed grey" }}>
    <ActivityForm onActivitiesAdded={() => window.location.reload()} />
    <ActivityList />
  </Box>
);

function App() {
  const { token, tokenData, logIn, logOut } = useContext(AuthContext);
  const dispatch = useDispatch();

  useEffect(() => {
    if (token) {
      dispatch(
        setCredentials({
          token,
          user: tokenData,
        })
      );
    }
  }, [token, tokenData, dispatch]);

  const isLoggedIn = !!token;

  return (
    <Router>
      {!isLoggedIn ? (
        <Button
          variant="contained"
          sx={{ backgroundColor: "#dc004e" }}
          onClick={logIn}
        >
          Login with Keycloak
        </Button>
      ) : (
        <>
          <h2>Authentication Successful</h2>

          <Button
            variant="outlined"
            sx={{ mb: 2 }}
            onClick={logOut}
          >
            Logout
          </Button>

          <Box component="section" sx={{ p: 2, border: "1px dashed grey" }}>
            This Box renders as an HTML section element.

            <Routes>
              <Route path="/activities" element={<ActivityPage />} />
              <Route path="/activities/:id" element={<ActivityDetail />} />

              <Route
                path="/"
                element={<Navigate to="/activities" replace />}
              />
            </Routes>
          </Box>
        </>
      )}
    </Router>
  );
}

export default App;
// Axios is a popular library used to make HTTP requests (like GET, POST, PUT, DELETE) to external servers.
import axios from "axios";

// This is the base URL where our backend server is running.
const API_URL = 'http://localhost:8080/api';

// Create a customized instance of axios.
// By doing this, we don't have to type out the full URL every time we make a request.
const api = axios.create({
    baseURL: API_URL
});

// Interceptors are like "middlemen" that run right before every request is sent.
// We use this to automatically attach our security credentials to every outgoing request.
api.interceptors.request.use(
    (config) => {
        // Read the user ID and secure token that we saved in the browser's localStorage during login.
        const userId = localStorage.getItem('userId');
        const token = localStorage.getItem('token');

        // If a token exists, attach it to the 'Authorization' header.
        // This proves to the backend that we are logged in.
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        } 

        // If a userId exists, attach it to a custom header.
        if (userId) {
            config.headers['X-User-ID'] = userId;
        }

        // Return the modified configuration so the request can proceed!
        return config;
    }, 
    (error) => {
        // If something goes wrong while setting up the request, just reject it.
        return Promise.reject(error);
    }
);

// --- EXPORTED API FUNCTIONS ---
// These are simple helper functions that other files can import and use to talk to the backend.

// Fetches the list of all activities for the logged-in user
export const getActivities = () => api.get('/activities');

// Sends new activity data to the server to be saved
export const addActivity = (activity) => api.post('/activities', activity);

// Fetches the specific details of a single activity by its ID
export const getActivityById = (id) => api.get(`/activities/${id}`);

// Fetches AI-generated recommendations for a specific activity by its ID
export const getActivityDetail = (id) => api.get(`/recommendation/activity/${id}`);
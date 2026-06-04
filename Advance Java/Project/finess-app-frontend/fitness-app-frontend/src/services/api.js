const API_URL = 'http://localhost:8080/api';

const api = axios.create({
    baseUrl:API_URL
});

api.interceptors.request.use((config)=>{
    const userId = localStorage.getItem('userId');
    if(userId){
        config.headers['X-User-ID'] = userId;
    }

});

export const getActivities = () => api.get('/activities');
export const addActivitiy = () => api.post('/activity');
export const getActivitiyDetail = () => api.get('/recommendation/activity/${id}');



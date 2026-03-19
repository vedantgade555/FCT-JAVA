import axios from "axios";
const API_URL = "http://localhost:8080/api/persons";

const getAllPerson = ()=>{
    return axios.get(API_URL);
};

const getPersonById = (id)=>{
    return axios.get(`${API_URL}/${id}`);
};

const savePerson = (person) =>{
    return axios.post(API_URL,person);
}

const updatePerson = (id,person) =>{
    return axios.put(`${API_URL}/${id}`,person);
}

const deletePerson=(id)=>{
    return axios.delete(`${API_URL}/${id}`);
};

export default{
    getAllPerson,
    getPersonById,
    savePerson,
    updatePerson,
    deletePerson,
};
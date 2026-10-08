import axios from "axios";
const api = axios.create({ baseURL: "http://localhost:8080/api" });
export const errMsg = (e) => e.response?.data?.message || "Something went wrong";
export default api;

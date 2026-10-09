import axios from "axios";
// const api = axios.create({ baseURL:"https://online-cab-booking.onrender.com/api" || "http://localhost:8080/api" });
const api = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL || "http://localhost:8080/api",
});
export const errMsg = (e) => e.response?.data?.message || "Something went wrong";
export default api;

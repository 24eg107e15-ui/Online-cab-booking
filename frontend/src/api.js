import axios from "axios";

const api = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL || "https://online-cab-booking.onrender.com/api",
});

export const errMsg = (e) =>
  e.response?.data?.message || "Something went wrong";

export default api;
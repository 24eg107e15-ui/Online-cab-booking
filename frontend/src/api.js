import axios from "axios";

const api = axios.create({
  baseURL:"https://online-cab-booking.onrender.com/api",
});

export const errMsg = (e) =>
  e.response?.data?.message || "Something went wrong";

export default api;
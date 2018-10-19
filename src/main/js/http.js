import axios from "axios";
import { HttpConstants } from './lib/http/Constants'
 
const axiosInstance = axios.create({withCredentials: true});
 
axiosInstance.defaults.baseURL = process.env.API_URL;
 
axiosInstance.interceptors.request.use(config => {
  let authorization = sessionStorage.getItem(HttpConstants.STORAGE_AUTHORIZATION_KEY) || localStorage.getItem(HttpConstants.STORAGE_AUTHORIZATION_KEY);
  if (authorization) {
    config.headers['Authorization'] = authorization;
  }
  return config;
});
 
axiosInstance.interceptors.response.use(
  res => {
    return res;
  },
  err => {
    if (err.response.status == 403) {
      location.href = "#/signin";
    } 
    console.error(err);
    return Promise.reject(error);
  }
);
 
export default Vue => {
  Vue.http = axiosInstance;
  Object.defineProperties(Vue.prototype, {
    $http: {
      get() {
        return axiosInstance;
      }
    },
    axios: {
      get() {
        return axiosInstance;
      }
    }
  });
};
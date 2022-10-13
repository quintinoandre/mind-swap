import axios, { AxiosInstance } from 'axios';

const BASE_URL: string = 'http://hn.algolia.com/api/v1';

const api: AxiosInstance = axios.create({ baseURL: BASE_URL });

export { api };

import axios from 'axios';

const BASE_URL = 'http://hn.algolia.com/api/v1';

const api = axios.create({ baseURL: BASE_URL });

export { api };

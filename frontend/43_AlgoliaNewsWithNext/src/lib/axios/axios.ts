import axios from 'axios';

const api = axios.create({ baseURL: 'http://hn.algolia.com/api/v1' });

export { api };

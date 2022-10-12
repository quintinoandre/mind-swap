/* eslint-disable no-console */
// eslint-disable-next-line import/extensions
import { api } from './api.js';

function getFirstArticle() {
	return api
		.get('/search')
		.then((response) => response.data.hits[0].objectID)
		.then((objectID) => api.get(`/items/${objectID}`));
}

getFirstArticle()
	.then((response) => console.log(response.data))
	.catch((err) => console.log(err.response ? err.response.data : err.message));

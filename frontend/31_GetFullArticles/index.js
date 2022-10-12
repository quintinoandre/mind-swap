/* eslint-disable no-console */
// eslint-disable-next-line import/extensions
import { api } from './api.js';

function getFullArticles() {
	return api
		.get('/search')
		.then((response) => response.data.hits)
		.then((hits) =>
			Promise.all(hits.map((hit) => api.get(`/items/${hit.objectID}`)))
		);
}

getFullArticles()
	.then((response) => response.forEach((item) => console.log(item.data)))
	.catch((err) => console.log(err.response ? err.response.data : err.message));

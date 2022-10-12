/* eslint-disable no-console */
// eslint-disable-next-line import/extensions
import { api } from './api.js';

function getPoints() {
	return api
		.get('/search')
		.then((response) =>
			response.data.hits.reduce((acc, curr) => acc + curr.points, 0)
		);
}

getPoints()
	.then((response) => console.log(response))
	.catch((err) => console.log(err.response ? err.response.data : err.message));

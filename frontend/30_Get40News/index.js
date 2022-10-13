/* eslint-disable no-console */
// eslint-disable-next-line import/extensions
import { api } from './api.js';

function get40news() {
	const promises = [];

	promises.push(
		api.get('/search?page=1').then((response) => response.data.hits)
	);

	promises.push(
		api.get('/search?page=2').then((response) => response.data.hits)
	);

	return Promise.all(promises).then((response) => response.flat());
}

get40news()
	.then((response) => console.log(response))
	.catch((err) => console.log(err.response ? err.response.data : err.message));

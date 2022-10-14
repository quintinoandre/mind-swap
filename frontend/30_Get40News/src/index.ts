import { api } from './api';

/* function get40news() {
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
	.catch((err) => console.log(err)); */

async function get40news(): Promise<any> {
	const promises = [];

	promises.push(
		api.get('/search?page=1').then((response) => response.data.hits)
	);

	promises.push(
		api.get('/search?page=2').then((response) => response.data.hits)
	);

	return await Promise.all(promises).then((response) => response.flat());
}

void (async () => {
	try {
		const response = await get40news();

		console.log(response);
	} catch (err) {
		console.log(err);
	}
})();

import { api } from './api';

/* function getFullArticles() {
	return api
		.get('/search')
		.then((response) => response.data.hits)
		.then((hits) =>
			Promise.all(hits.map((hit) => api.get(`/items/${hit.objectID}`)))
		);
}

getFullArticles()
	.then((response) => response.forEach((item) => console.log(item.data)))
	.catch((err) => console.error(err.response ? err.response.data : err.message)); */

interface IHitProps {
	objectID: number;
}

async function getFullArticles(): Promise<any[]> {
	const {
		data: { hits },
	} = await api.get('/search');

	return await Promise.all(
		hits.map(async (hit: IHitProps) => await api.get(`/items/${hit.objectID}`))
	);
}

void (async () => {
	try {
		const response = await getFullArticles();

		response.forEach((item) => console.log(item.data));
	} catch (err: any) {
		// eslint-disable-next-line @typescript-eslint/strict-boolean-expressions
		console.error(err.response ? err.response.data : err.message);
	}
})();

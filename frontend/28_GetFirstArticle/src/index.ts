import { AxiosResponse } from 'axios';

import { api } from './api';

/* function getFirstArticle(){
	return api
		.get('/search')
		.then((response) => response.data.hits[0].objectID)
		.then((objectID) => api.get(`/items/${objectID}`));
}

getFirstArticle()
	.then((response) => console.log(response.data))
	.catch((err) => console.error(err.response ? err.response.data : err.message)); */

async function getFirstArticle(): Promise<AxiosResponse<any, any>> {
	const response = await api.get('/search');

	const objectID = response.data.hits[0].objectID as string;

	return await api.get(`/items/${objectID}`);
}

void (async () => {
	try {
		const response = await getFirstArticle();

		console.log(response.data);
	} catch (err: any) {
		// eslint-disable-next-line @typescript-eslint/strict-boolean-expressions
		console.error(err.response ? err.response.data : err.message);
	}
})();

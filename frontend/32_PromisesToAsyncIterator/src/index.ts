import { api } from './api';

interface IHitProps {
	objectID: number;
}

interface IPromiseProps {
	id: number;
	promise: Promise<any>;
}

async function generateArrayOfPromises(): Promise<IPromiseProps[]> {
	const {
		data: { hits },
	} = await api.get('/search');

	return hits.map((hit: IHitProps) => ({
		id: hit.objectID,
		promise: api.get(`/items/${hit.objectID}`),
	}));
}

void (async () => {
	const arrayOfPromises = await generateArrayOfPromises();

	async function* promisesToAsyncIterator(
		arrayOfPromises: IPromiseProps[]
	): AsyncGenerator<any, void, unknown> {
		while (arrayOfPromises.length > 0) {
			const response = await Promise.any(
				arrayOfPromises.map(async ({ promise }) => await promise)
			);

			const index = arrayOfPromises.findIndex(
				({ id }) => Number(id) === response.data.id
			);

			arrayOfPromises.splice(index, 1);

			yield response.data;
		}
	}

	const generator = promisesToAsyncIterator(arrayOfPromises);

	for await (const value of generator) {
		console.log(value);
	}
})();

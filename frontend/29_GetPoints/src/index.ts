import { api } from './api';

/* function getPoints() {
	return api
		.get('/search')
		.then((response) =>
			response.data.hits.reduce((acc, curr) => acc + curr.points, 0)
		);
}

getPoints()
	.then((response) => console.log(response))
	.catch((err) => console.error(err)); */

interface IHitsProps {
	points: number;
}

async function getPoints(): Promise<number> {
	const response = await api.get('/search');

	return response.data.hits.reduce(
		(acc: number, curr: IHitsProps) => acc + curr.points,
		0
	);
}

void (async () => {
	try {
		const response = await getPoints();

		console.log(response);
	} catch (err) {
		console.error(err);
	}
})();

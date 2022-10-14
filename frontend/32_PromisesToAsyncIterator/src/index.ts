const promises = [
	new Promise((resolve) => {
		setTimeout(() => {
			resolve('after 3s');
		}, 3000);
	}),
	new Promise((resolve) => {
		setTimeout(() => {
			resolve('after 1s');
		}, 1000);
	}),
	new Promise((resolve) => {
		setTimeout(() => {
			resolve('after 4s');
		}, 4000);
	}),
	new Promise((resolve) => {
		setTimeout(() => {
			resolve('after 5s');
		}, 5000);
	}),
	new Promise((resolve) => {
		setTimeout(() => {
			resolve('after 2s');
		}, 2000);
	}),
];

void (async () => {
	async function* promisesToAsyncIterator(
		arrayOfPromises: Array<Promise<any>>
	): AsyncGenerator<any, void, unknown> {
		const promiseByKey = new Map();

		for (let i = 0; i < arrayOfPromises.length; i++) {
			promiseByKey.set(
				i,
				arrayOfPromises[i].then((value) => ({ value, key: i }))
			);
		}

		while (promiseByKey.size > 0) {
			const promise = await Promise.any(promiseByKey.values());

			promiseByKey.delete(promise.key);

			yield promise.value;
		}
	}

	const generator = promisesToAsyncIterator(promises);

	for await (const value of generator) {
		console.log(value);
	}
})();

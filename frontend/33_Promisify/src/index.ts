/* eslint-disable @typescript-eslint/strict-boolean-expressions */
/* eslint-disable n/no-callback-literal */
function sum(number1: number, number2: number, callback: any): any {
	if (Number.isNaN(number1) || Number.isNaN(number2)) {
		return callback('Missing or wrong arguments.', null);
	}

	const sum = number1 + number2;

	const message = `Sum is ${sum}.`;

	return callback(null, sum, message);
}

/* sum(1, 1, (err: string, result: number) => {
	return err !== null ? console.error(err) : console.log(result);
}); */

function promisify(fun: any) {
	return async (...args: any[]) => {
		return await new Promise((resolve, reject) => {
			function callback(err: any, ...results: any[]): void {
				if (err) {
					return reject(err);
				}

				return resolve(results.length === 1 ? results[0] : results);
			}

			args.push(callback);

			fun(...args);
		});
	};
}

const sumPromised = promisify(sum);

void (async () => {
	try {
		const response = await sumPromised(2, 3);

		console.log(response);
	} catch (err) {
		console.error(err);
	}
})();

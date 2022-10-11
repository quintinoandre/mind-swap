const memoize = (func) => {
	const results = {};

	return (...args) => {
		const argsKey = JSON.stringify(args);

		if (!results[argsKey]) {
			results[argsKey] = func(...args);
		}

		return results[argsKey];
	};
};

const sum = memoize((num1, num2) => {
	return num1 + num2;
});

console.time('First call');
console.log(sum(1, 2));
console.timeEnd('First call');
console.time('Second call');
console.log(sum(1, 2));
console.timeEnd('Second call');
console.time('Third call');
console.log(sum(3, 4));
console.timeEnd('Third call');
console.time('Fourth Call');
console.log(sum(3, 4));
console.timeEnd('Fourth Call');
console.time('Fifth call');
console.log(sum(1, 2));
console.timeEnd('Fifth call');

/* const fibonacci = (n) => {
	if (n === 1) {
		return 1;
	}

	if (n === 2) {
		return 1;
	}

	return fibonacci(n - 1) + fibonacci(n - 2);
}; */

const fibonacci = memoize((n) => {
	if (n === 1) {
		return 1;
	}

	if (n === 2) {
		return 1;
	}

	return fibonacci(n - 1) + fibonacci(n - 2);
});

console.log(fibonacci(40));

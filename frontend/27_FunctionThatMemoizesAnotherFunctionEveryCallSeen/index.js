const memoize = (fn) => {
	const cache = {};

	return (...args) => {
		if (!cache.hasOwnProperty(args.toString())) {
			cache[args.toString()] = fn(...args);
		}

		return cache[args.toString()];
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

const fibonacci = memoize((n) => {
	return n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2);
});

console.time('First call');
console.log(fibonacci(40));
console.timeEnd('First call');
console.time('Second call');
console.log(fibonacci(40));
console.timeEnd('Second call');

const memoize = (fn) => {
	const cache = new Array(2);

	return (...args) => {
		if (!cache.includes(args.toString())) {
			cache[0] = args.toString();

			cache[1] = fn(...args);
		}

		return cache[1];
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
console.time('Fourth call');
console.log(sum(3, 4));
console.timeEnd('Fourth call');
console.time('Fifth call');
console.log(sum(1, 2));
console.timeEnd('Fifth call');

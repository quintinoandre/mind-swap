const memoize = (fn) => {
	const result = new Array(2);

	return (...args) => {
		if (!result.includes(args.toString())) {
			result[0] = args.toString();

			result[1] = fn(...args);
		}

		return result[1];
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

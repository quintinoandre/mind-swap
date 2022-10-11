function every(array, test) {
	// eslint-disable-next-line no-restricted-syntax
	for (const item of array) {
		if (!test(item)) {
			return false;
		}
	}

	return true;
}

function everyWithSomeMethod(array, test) {
	return !array.some((element) => !test(element));
}

export { every, everyWithSomeMethod };

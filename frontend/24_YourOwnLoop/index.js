function loop(value, testFunction, updateFunction, bodyFunction) {
	if (!testFunction(value)) {
		return false;
	}

	bodyFunction(value);

	return loop(
		updateFunction(value),
		testFunction,
		updateFunction,
		bodyFunction
	);
}

export { loop };

function flat(arrays) {
	return arrays.reduce((acc, curr) => {
		if (curr.length > 1) {
			curr.forEach((element) => acc.push(element));
		} else {
			acc.push(curr[0]);
		}

		return acc;
	}, []);
}

export { flat };

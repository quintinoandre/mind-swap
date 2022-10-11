import { describe, it, expect } from 'vitest';

import { flat } from '.';

describe('Flattening', () => {
	it('Should flatten and array of arrays into a single array that has all the elements of the original arrays', () => {
		const arrays = [[1, 2, 3], [4, 5], [6]];

		const flatArray = flat(arrays);

		expect(flatArray).toEqual([1, 2, 3, 4, 5, 6]);
	});
});

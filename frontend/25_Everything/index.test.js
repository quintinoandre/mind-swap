import { expect, test } from 'vitest';

import { every, everyWithSomeMethod } from '.';

test('Everything', () => {
	expect(every([1, 3, 5], (n) => n < 10)).toEqual(true);
	expect(every([2, 4, 16], (n) => n < 10)).toEqual(false);
	expect(every([], (n) => n < 10)).toEqual(true);
});

test('Everything', () => {
	expect(everyWithSomeMethod([1, 3, 5], (n) => n < 10)).toEqual(true);
	expect(everyWithSomeMethod([2, 4, 16], (n) => n < 10)).toEqual(false);
	expect(everyWithSomeMethod([], (n) => n < 10)).toEqual(true);
});

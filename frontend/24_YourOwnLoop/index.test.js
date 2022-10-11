import { expect, test } from 'vitest';

import { loop } from '.';

test('Your own loop', () => {
	expect(
		loop(
			3,
			(n) => n > 0,
			(n) => n - 1,
			console.log
		)
	).toEqual(false);
});

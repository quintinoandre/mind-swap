function range(number1, number2, step) {
  const initialNumber = number1 < number2 ? number1 : number2;
  const lastNumber = number1 < number2 ? number2 : number1;

  const array = [];

  if (step > 0 || !step) {
    for (let i = initialNumber - (step ?? 1); i < lastNumber; i += step ?? 1) {
      const newNumber = i + (step ?? 1);

      if (newNumber <= lastNumber) {
        array.push(newNumber);
      }
    }
  } else {
    for (let i = lastNumber - step; i > initialNumber; i += step) {
      const newNumber = i + step;

      if (newNumber >= initialNumber) {
        array.push(newNumber);
      }
    }
  }

  return array;
}

function sum(range) {
  return range.reduce((acc, current) => acc + current, 0);
}

console.log(range(1, 10));

console.log(range(5, 2, -1));

console.log(sum(range(1, 10)));

console.log(range(2, 9, 3));

console.log(range(3, 9, 7));

console.log(range(7, 15, -5));

console.log(range(1, 10, 2));

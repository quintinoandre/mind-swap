/* function sumOfEvenNumber(integerNumber) {
  const evenNumbers = [];

  let beforeNumber = integerNumber;

  let numberToBeSubtract = 1;

  let remainder = beforeNumber % 2;

  if (remainder === 0) {
    evenNumbers.push(beforeNumber);
  }

  do {
    beforeNumber = beforeNumber - numberToBeSubtract;

    remainder = beforeNumber % 2;

    if (remainder === 0) {
      evenNumbers.push(beforeNumber);

      numberToBeSubtract = 2;
    }
  } while (beforeNumber > 0);

  return evenNumbers.reduce(
    (previousValue, currentValue) => previousValue + currentValue
  );
} */

function sumOfEvenNumber(integerNumber) {
  let sumEvenNumbers = 0;

  for (let i = 0; i <= integerNumber; i += 2) {
    sumEvenNumbers += i;
  }

  return sumEvenNumbers;
}

console.log(sumOfEvenNumber(4));

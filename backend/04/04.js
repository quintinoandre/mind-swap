/* function decimalToBinary(number = 0) {
  const binaryNumber = [];

  let operationResult = number;

  do {
    binaryNumber.unshift(operationResult % 2);

    operationResult = parseInt(operationResult / 2);
  } while (operationResult !== 1 && number > 1);

  if (number > 1) {
    binaryNumber.unshift(1);
  } else {
    binaryNumber.unshift(0);
  }

  if (binaryNumber.length < 4) {
    for (let index = 0; index <= 4 - binaryNumber.length; index++) {
      binaryNumber.unshift(0);
    }
  }

  return binaryNumber;
}

console.log(decimalToBinary(3));
 */

function decimalToBinary(number = 0) {
  const binaryNumber = [];

  let operationResult = number;

  do {
    binaryNumber.unshift(operationResult % 2);

    operationResult = parseInt(operationResult / 2);
  } while (operationResult !== 1 && number > 1);

  number > 1 ? binaryNumber.unshift(1) : binaryNumber.unshift(0);

  if (binaryNumber.length < 4) {
    for (let index = 0; index <= 4 - binaryNumber.length; index++) {
      binaryNumber.unshift(0);
    }
  }

  return binaryNumber;
}

console.log(decimalToBinary(3));

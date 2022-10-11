function isEven(number) {
  if (number < 0) {
    number = number * -1;
  }

  if (number === 0) {
    return true;
  } else if (number <= 1) {
    return false;
  }

  const nextNumber = number - 2;

  return isEven(nextNumber);
}

console.log(isEven(50));
console.log(isEven(75));
console.log(isEven(-1));

function generateRandomNumber() {
  const randomNumbers = [];

  let generatedNumber;

  while (randomNumbers.length <= 10) {
    generatedNumber = Math.random() * 9;

    if (!randomNumbers.includes(generatedNumber)) {
      randomNumbers.push(generatedNumber);
    }
  }

  return randomNumbers;
}

console.log(generateRandomNumber());

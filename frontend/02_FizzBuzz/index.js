(function printNumbers() {
  for (let i = 1; i <= 100; i++) {
    const fizzCondition = i % 3 === 0;

    const buzzCondition = i % 5 === 0;

    if (fizzCondition) {
      console.log(`${i}: Fizz`);
    }

    if (buzzCondition) {
      console.log(`${i}: Buzz`);
    }

    if (fizzCondition && buzzCondition) {
      console.log(`${i}: FizzBuzz`);
    }
  }
})();

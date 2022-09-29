function changeToBeGiven(amountToBePaid, givenMoney) {
  const portugalMoney = [
    500, 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01,
  ];

  const change = {};

  let numericChange = givenMoney - amountToBePaid;

  portugalMoney.forEach((currency) => {
    const partialChange = parseInt(numericChange / currency);

    change[currency] = partialChange;

    numericChange = numericChange - partialChange * currency;
  });

  return change;
}

console.log(changeToBeGiven(12.5, 15));

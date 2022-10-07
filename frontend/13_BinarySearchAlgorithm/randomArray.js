function randomArray(length, min, max) {
  let randomArray = [];

  while (randomArray.length < length) {
    randomArray = [
      ...new Set([
        ...randomArray,
        ...Array(length - randomArray.length)
          .fill()
          .map(() => Math.floor(Math.random() * (max - min + 1)) + min),
      ]),
    ];
  }

  return randomArray;
}

module.exports = randomArray;

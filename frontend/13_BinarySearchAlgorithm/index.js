const quicksort = require("./quicksort");
const randomArray = require("./randomArray");

function binarySearch(array, target, lowIndex, hightIndex) {
  if (lowIndex > hightIndex) {
    return "Not found.";
  }

  const middleIndex = Math.floor((lowIndex + hightIndex) / 2);

  if (array[middleIndex] === target) {
    return middleIndex;
  }

  if (array[middleIndex] > target) {
    return binarySearch(array, target, lowIndex, middleIndex - 1);
  }

  if (array[middleIndex] < target) {
    return binarySearch(array, target, middleIndex + 1, hightIndex);
  }
}

const array = randomArray(10, 1, 100);
console.log(array);
quicksort(array, 0, array.length - 1);
console.log(array);
console.log(binarySearch(array, 29, 0, array.length - 1));

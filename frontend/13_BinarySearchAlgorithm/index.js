const quicksort = require("./quicksort");
const randomArray = require("./randomArray");

function binarySearch(array, target) {
  function binarySearchWithIndexes(array, target, lowIndex, hightIndex) {
    if (lowIndex > hightIndex) {
      return "Not found.";
    }

    const middleIndex = Math.floor((lowIndex + hightIndex) / 2);

    const middleValue = array[middleIndex];

    if (middleValue === target) {
      return middleIndex;
    }

    if (middleValue > target) {
      return binarySearchWithIndexes(array, target, lowIndex, middleIndex - 1);
    }

    if (middleValue < target) {
      return binarySearchWithIndexes(
        array,
        target,
        middleIndex + 1,
        hightIndex
      );
    }
  }

  return binarySearchWithIndexes(array, target, 0, array.length - 1);
}

const array = randomArray(10, 1, 100);
console.log(array);
quicksort(array, 0, array.length - 1);
console.log(array);
console.log(binarySearch(array, 29));

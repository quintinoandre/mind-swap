function swapArrayPositions(array, index1, index2) {
  const temp = array[index1];

  array[index1] = array[index2];

  array[index2] = temp;
}

function partition(lowIndex, hightIndex, array, pivot) {
  let leftIndex = lowIndex;

  let rightIndex = hightIndex;

  while (leftIndex < rightIndex) {
    while (array[leftIndex] <= pivot && leftIndex < rightIndex) {
      leftIndex++;
    }

    while (array[rightIndex] >= pivot && leftIndex < rightIndex) {
      rightIndex--;
    }

    swapArrayPositions(array, leftIndex, rightIndex);
  }

  swapArrayPositions(array, leftIndex, hightIndex);

  return leftIndex;
}

function quicksort(array) {
  function quicksortWithIndexes(array, lowIndex, hightIndex) {
    if (lowIndex >= hightIndex) {
      return;
    }

    const randomPivotIndex =
      Math.floor(Math.random() * (hightIndex - lowIndex + 1)) + lowIndex;

    const pivot = array[randomPivotIndex];

    //const pivot = array[hightIndex];

    swapArrayPositions(array, randomPivotIndex, hightIndex);

    let leftIndex = partition(lowIndex, hightIndex, array, pivot);

    quicksortWithIndexes(array, lowIndex, leftIndex - 1);

    quicksortWithIndexes(array, leftIndex + 1, hightIndex);
  }

  return quicksortWithIndexes(array, 0, array.length - 1);
}

const randomArray = (length, min, max) => {
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
};

const array = randomArray(10, 1, 20);
console.log(array);
quicksort(array);
console.log(array);

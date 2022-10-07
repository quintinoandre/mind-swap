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

function quicksort(array, lowIndex, hightIndex) {
  if (lowIndex >= hightIndex) {
    return;
  }

  const randomPivotIndex =
    Math.floor(Math.random() * (hightIndex - lowIndex + 1)) + lowIndex;

  const pivot = array[randomPivotIndex];

  swapArrayPositions(array, randomPivotIndex, hightIndex);

  let leftIndex = partition(lowIndex, hightIndex, array, pivot);

  quicksort(array, lowIndex, leftIndex - 1);

  quicksort(array, leftIndex + 1, hightIndex);
}

module.exports = quicksort;

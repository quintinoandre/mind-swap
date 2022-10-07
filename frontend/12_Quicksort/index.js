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

   const pivot = [
    array[lowIndex],
    array[Math.round(hightIndex / 2)],
    array[hightIndex],
  ].sort()[1];

  /*const randomPivotIndex =
    Math.floor(Math.random() * (hightIndex - lowIndex)) + lowIndex;*/

  //const pivot = array[randomPivotIndex];

  //const pivot = array[hightIndex];

  swapArrayPositions(array, array.indexOf(pivot), hightIndex);

  let leftIndex = partition(lowIndex, hightIndex, array, pivot);

  quicksort(array, lowIndex, leftIndex - 1);

  quicksort(array, leftIndex + 1, hightIndex);
}

const randomArray = (length, max) => [
  ...new Set(
    Array(length)
      .fill()
      .map(() => Math.round(Math.random() * max))
  ),
];

const array = randomArray(1000, 10000);
console.log(array);
quicksort(array, 0, array.length - 1);
console.log(array);

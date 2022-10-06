function reverseArray(array) {
  const reverseArray = new Array();

  for (const element of array) {
    reverseArray.unshift(element);
  }

  return reverseArray;
}

function reverseArrayInPlace(array) {
  for (let i = 0; i < Math.floor(array.length / 2); i++) {
    const first = array[i];
    const last = array[array.length - 1 - i];

    array[i] = last;
    array[array.length - 1 - i] = first;
  }

  return array;
}

const array1 = ["A", "B", "C"];
const array2 = [1, 2, 3, 4, 5];

console.log(reverseArray(array1));
console.log(array1);

console.log(reverseArrayInPlace(array2));
console.log(array2);

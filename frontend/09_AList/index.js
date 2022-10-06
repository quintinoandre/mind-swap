function arrayToList(array) {
  let list;

  for (let i = array.length; i > 0; i--) {
    if (i === array.length) {
      list = { value: array[i - 1], rest: null };
    } else {
      list = { value: array[i - 1], rest: list };
    }
  }

  return list;
}

function listToArray(list) {
  const array = [];

  let tempList = list;

  while (tempList !== null) {
    array.push(tempList.value);

    tempList = tempList.rest;
  }

  return array;
}

function prepend(value, list) {
  const array = listToArray(list);

  array.unshift(value);

  return arrayToList(array);
}

function nth(list, number) {
  if (number > 0) {
    number--;

    if (list.rest) {
      return nth(list.rest, number);
    }

    return undefined;
  }

  return list.value;
}

console.log(arrayToList([10, 20]));

console.log(listToArray(arrayToList([10, 20])));

console.log(prepend(10, prepend(20, null)));

console.log(nth(arrayToList([10, 20, 30]), 2));

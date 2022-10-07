function range(start, end) {
  if (end || end === 0) {
    const array = [];

    for (let i = start; i <= end; i++) {
      array.push(i);
    }

    return array;
  }

  return (end) => {
    return range(start, end);
  };
}

console.log(range(3, 3)); // [3]
console.log(range(3, 8)); // [3,4,5,6,7,8]
console.log(range(3, 0)); // []

let start3 = range(3);
let start4 = range(4);

console.log(start3(3)); // [3]
console.log(start3(8)); // [3,4,5,6,7,8]
console.log(start3(0)); // []

console.log(start4(6)); // [4,5,6]
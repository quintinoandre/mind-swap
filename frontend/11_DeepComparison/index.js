function deepEqual(value1, value2) {
  if (value1 === null && value2 === null) {
    return true;
  }

  if (
    value1 === null ||
    value2 === null ||
    typeof value1 !== typeof value2 ||
    Object.keys(value1).length !== Object.keys(value2).length
  ) {
    return false;
  }

  if (typeof value1 === "object") {
    for (const key of Object.keys(value1)) {
      if (!Object.keys(value2).includes(key)) {
        return false;
      }
    }

    for (const key in value1) {
      if (typeof value1[key] === "object") {
        deepEqual(value1[key], value2[key]);
      }

      if (value1[key] === value2[key]) {
        continue;
      } else {
        return false;
      }
    }
  } else {
    return value1 === value2;
  }

  return true;
}

let obj = { here: { is: "an" }, object: 2 };
console.log(deepEqual(obj, obj));
console.log(deepEqual(obj, { here: { is: "an" }, number: 2 }));
console.log(deepEqual(obj, { here: { is: "an" } }));
console.log(deepEqual(2, "2"));
console.log(deepEqual(2, 2));
console.log(deepEqual(null, null));

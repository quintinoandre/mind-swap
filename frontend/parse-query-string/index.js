function parseQueryString(queryString) {
  if (typeof queryString !== "string") {
    throw new Error("Invalid string.");
  }

  const obj = {};

  queryString
    .replace(/.+\?/gm, "")
    .split("&")
    .forEach((item) => {
      const array = item.split(",");

      if (array.length > 1) {
        obj[array[0].replace(/=.+$/gm, "")] = array.map((item) =>
          item.replace(/^[a-z]+=/gm, "")
        );
      } else {
        obj[array[0].replace(/=.+$/gm, "")] = array[0].replace(
          /^[a-z]+=/gm,
          ""
        );
      }
    });

  return obj;
}

console.log(parseQueryString("mindera.com?a=1,2&b=3,4&c=four"));

function camelCaseToSnakeCase(string) {
  if (typeof string !== "string") {
    throw new Error("Invalid string.");
  }

  if (!/^[a-z]+([A-Z]{1}[a-z]+)+$/gm.test(string)) {
    throw new Error("Invalid camelCase string.");
  }

  const stringArray = string.split("");

  let camelCaseString = "";

  for (const letter of stringArray) {
    if (/[A-Z]/.test(letter)) {
      camelCaseString += `_${letter.toLocaleLowerCase()}`;
    } else {
      camelCaseString += letter;
    }
  }

  return camelCaseString;
}

function snakeCaseToCamelCase(string) {
  if (typeof string !== "string") {
    throw new Error("Invalid string.");
  }

  if (!/^[a-z]+(_{1}[a-z]+)+$/gm.test(string)) {
    throw new Error("Invalid snake_case string.");
  }

  const stringArray = string.split("_");

  let camelCaseString = stringArray[0];

  for (let i = 1; i < stringArray.length; i++) {
    camelCaseString += `${stringArray[i].charAt(0).toUpperCase()}${stringArray[
      i
    ].substring(1, stringArray[i].length)}`;
  }

  return camelCaseString;
}

console.log(camelCaseToSnakeCase("javascriptIsVeryNice"));

console.log(snakeCaseToCamelCase("javascript_is_very_nice"));

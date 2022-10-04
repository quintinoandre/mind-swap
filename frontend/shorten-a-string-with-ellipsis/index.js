function shortStringWithEllipsis(string, maxLength) {
  if (typeof string !== "string") {
    throw new Error("Invalid string.");
  }

  if (typeof maxLength !== "number") {
    throw new Error("MaxLength must be a number.");
  }

  return `${string.substring(0, Math.round(maxLength))}...`;
}

const phrase =
  "Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsam laudantium fugiat unde eius eos, maiores quas quo odio exercitationem ullam delectus laboriosam. Magnam ratione sed hic, dolore porro dicta tempora!";

console.log(shortStringWithEllipsis(phrase, 10));

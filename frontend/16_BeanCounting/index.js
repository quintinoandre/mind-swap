function countBs(string) {
  return string.replace(/[^B+]/g, "").length;
}

function countChar(string, character) {
  const regex = new RegExp(`[^${character}+]`, "g");

  return string.replace(regex, "").length;
}

console.log(countBs("BBC"));
console.log(countChar("BBC", "B"));
console.log(countChar("kakkerlak", "k"));

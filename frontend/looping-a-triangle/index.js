function returnSymbolNTimes(symbol, times) {
  let text = "";

  for (let i = 0; i < times; i++) {
    text += symbol;
  }

  return text;
}

function makeTriangle(symbol) {
  if (typeof symbol !== "string") {
    throw new Error("Symbol must be a string.");
  }

  for (let i = 1; i <= 7; i++) {
    console.log(returnSymbolNTimes(symbol, i));
  }
}

makeTriangle("#");

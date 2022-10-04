function oddLine(symbol, width) {
  let text = " ";

  for (let i = 0; i < width / 2; i++) {
    text += `${symbol} `;
  }

  return text;
}

function evenLine(symbol, width) {
  let text = "";

  for (let i = 0; i < width / 2; i++) {
    text += `${symbol} `;
  }

  text += " ";

  return text;
}

function printChessboard(symbol, width, height) {
  if (typeof symbol !== "string") {
    throw new Error("Symbol must be a string.");
  }

  if (typeof width !== "number") {
    throw new Error("Width must be a number.");
  }

  if (typeof height !== "number") {
    throw new Error("Height must be a number.");
  }

  for (let i = 1; i <= Math.round(height); i++) {
    if (i % 2 === 0) {
      console.log(oddLine(symbol, Math.round(width)));
    } else {
      console.log(evenLine(symbol, Math.round(width)));
    }
  }
}

printChessboard("#", 8.5, 8.4);

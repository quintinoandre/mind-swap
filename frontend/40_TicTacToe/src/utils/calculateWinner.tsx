function calculateWinner(gameState: string[]) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];

  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];

    if (
      gameState[a] &&
      gameState[a] === gameState[b] &&
      gameState[a] === gameState[c]
    ) {
      return {
        message: `Winner: ${gameState[a]}`,
        winnerPositions: [a, b, c],
      };
    }
  }

  if (gameState.every((item) => item !== null)) {
    return {
      message: 'It was a draw.',
      winnerPositions: null,
    };
  }

  return null;
}

export { calculateWinner };

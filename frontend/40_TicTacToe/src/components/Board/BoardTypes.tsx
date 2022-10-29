interface IBoardProps {
  gameState: string[];
  winnerPositions: number[];
  onClick: (position: number) => void;
}

export { IBoardProps };

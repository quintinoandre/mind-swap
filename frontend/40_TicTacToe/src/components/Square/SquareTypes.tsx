interface ISquareProps {
  move: string;
  position: number;
  winnerPosition: boolean;
  onClick: (position: number) => void;
}

export { ISquareProps };

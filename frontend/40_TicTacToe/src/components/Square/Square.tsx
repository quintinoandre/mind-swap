import React from 'react';
import styles from './Square.module.css';
import { ISquareProps } from './SquareTypes';

function Square(props: ISquareProps) {
  function findSquareButtonClasses() {
    if (props.winnerPosition) {
      return styles['square-winner'];
    }

    switch (props.move) {
      case 'X':
        return styles['square-x'];
      case 'O':
        return styles['square-o'];
      default:
        return styles.square;
    }
  }

  return (
    <button
      className={findSquareButtonClasses()}
      onClick={() => props.onClick(props.position)}
    >
      {props.move}
    </button>
  );
}

export { Square };

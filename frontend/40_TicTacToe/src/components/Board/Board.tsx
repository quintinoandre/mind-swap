import React from 'react';
import { Square } from '../Square';
import styles from './Board.module.css';
import { IBoardProps } from './BoardTypes';

function Board(props: IBoardProps) {
  const boardPositions = Array.from(Array(9).keys());

  return (
    <div className={styles['board-container']}>
      {boardPositions.map((boardPosition) => (
        <Square
          key={boardPosition}
          move={props.gameState[boardPosition]}
          position={boardPosition}
          winnerPosition={props.winnerPositions.includes(boardPosition)}
          onClick={(boardPosition) => props.onClick(boardPosition)}
        />
      ))}
    </div>
  );
}

export { Board };

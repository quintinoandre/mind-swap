import React, { useState } from 'react';
import { Board } from '../../components/Board';
import { calculateWinner } from '../../utils/calculateWinner';
import styles from './Game.module.css';
import { IGameHistoryProps } from './GameTypes';

function Game() {
  const [xIsNext, setXIsNext] = useState<boolean>(true);
  const [gameHistory, setGameHistory] = useState<IGameHistoryProps[]>([
    {
      gameState: Array(9).fill(null),
    },
  ]);
  const [playNumber, setPlayNumber] = useState<number>(0);

  function handleClickBoardSquare(position: number) {
    const gameHistoryCopy = gameHistory.slice(0, playNumber + 1);

    const currentGame = gameHistoryCopy[gameHistoryCopy.length - 1];

    const gameStateCopy = [...currentGame.gameState];

    if (calculateWinner(gameStateCopy) || gameStateCopy[position]) {
      return;
    }

    gameStateCopy[position] = xIsNext ? 'X' : 'O';

    setGameHistory([...gameHistoryCopy, { gameState: gameStateCopy }]);

    setPlayNumber(gameHistoryCopy.length);

    setXIsNext(!xIsNext);
  }

  function goToPlay(play: number) {
    setPlayNumber(play);

    setXIsNext(play % 2 === 0);
  }

  const plays = gameHistory.map((gameState, play) => {
    const buttonText = play ? `Go to play #${play}` : 'Go to game start';

    return (
      <button key={play} onClick={() => goToPlay(play)}>
        {buttonText}
      </button>
    );
  });

  const currentGameState = gameHistory[playNumber];

  const gameResult = calculateWinner(currentGameState.gameState);

  let status: string;
  let winnerPositions: number[] = Array(3).fill(null);

  if (gameResult) {
    status = gameResult.message;

    if (gameResult.winnerPositions) {
      winnerPositions = gameResult.winnerPositions;
    }
  } else {
    status = `Next player: ${xIsNext ? 'X' : 'O'}`;
  }

  return (
    <div className={styles['game-container']}>
      <div className="game-board">
        <Board
          winnerPositions={winnerPositions}
          gameState={currentGameState.gameState}
          onClick={(position) => handleClickBoardSquare(position)}
        />
      </div>
      <div className={styles['game-info']}>
        <div className={styles.status}>{status}</div>
        {plays}
      </div>
    </div>
  );
}

export { Game };

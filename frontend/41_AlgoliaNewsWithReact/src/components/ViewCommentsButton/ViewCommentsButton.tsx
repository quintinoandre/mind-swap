import React from 'react';
import styles from './ViewCommentsButton.module.css';
import { IViewCommentsButtonProps } from './ViewCommentsButtonTypes';

function ViewCommentsButton(props: IViewCommentsButtonProps) {
  return (
    <button
      className={styles['button-container']}
      id={props.id}
      hidden={props.hidden}
      onClick={() => props.onClick(props.id)}
    >
      view comments
    </button>
  );
}

export { ViewCommentsButton };

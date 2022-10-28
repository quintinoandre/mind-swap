import React from 'react';
import styles from './CommentButton.module.css';

function CommentButton() {
  return (
    <button className={styles['comment-button']} type="submit">
      Submit
    </button>
  );
}

export { CommentButton };

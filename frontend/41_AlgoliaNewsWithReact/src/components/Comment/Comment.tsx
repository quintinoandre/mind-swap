import React from 'react';
import styles from './Comment.module.css';
import { ICommentProps } from './CommentTypes';

function Comment(props: ICommentProps) {
  return (
    <li
      className={styles['li-container']}
      dangerouslySetInnerHTML={{ __html: props.comment }}
    />
  );
}

export { Comment };

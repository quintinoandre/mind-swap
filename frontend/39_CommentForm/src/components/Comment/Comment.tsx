import React from 'react';
import { LikeButton } from '../LikeButton';
import styles from './Comment.module.css';
import { ICommentProps } from './CommentTypes';

function Comment(props: ICommentProps) {
  return (
    <div className={styles['comment-container']}>
      <div className={styles['username-container']}>
        <label htmlFor="username">Username</label>
        <input type="text" value={props.username} disabled />
      </div>
      <textarea
        name="comment"
        id="comment"
        rows={10}
        value={props.comment}
        disabled
      />
      <LikeButton />
    </div>
  );
}

export { Comment };

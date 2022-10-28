import React from 'react';
import { CommentButton } from '../CommentButton';

import styles from './NewComment.module.css';
import { NewCommentProps } from './NewCommentTypes';

function NewComment(props: NewCommentProps) {
  return (
    <form onSubmit={(event) => props.onSubmit(event)}>
      <section className={styles['section-make-comment']}>
        <div className={styles['username-container']}>
          <label htmlFor="username">Username</label>
          <input
            id="username"
            type="text"
            value={props.username}
            required
            onChange={(event) => props.onChangeInput(event)}
          />
        </div>
        <textarea
          name="newComment"
          id="newComment"
          rows={10}
          value={props.comment}
          required
          onChange={(event) => props.onChangeTextArea(event)}
        ></textarea>
        <div className={styles['comment-button-container']}>
          <CommentButton />
        </div>
      </section>
    </form>
  );
}

export { NewComment };

import React, { useState } from 'react';
import { v4 as uuidv4 } from 'uuid';
import { Comment } from '../../components/Comment';
import { NewComment } from '../../components/NewComment';
import styles from './Comments.module.css';
import { ICommentProps } from './CommentsTypes';

function Comments() {
  const [username, setUsername] = useState<string>('');
  const [comment, setComment] = useState<string>('');
  const [comments, setComments] = useState<ICommentProps[]>([]);

  function handleClickSubmitComment(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();

    setComments((previousComments) => [
      ...previousComments,
      { id: uuidv4(), comment, username },
    ]);

    setUsername('');

    setComment('');
  }

  function handleUsernameInputChange(
    event: React.ChangeEvent<HTMLInputElement>
  ) {
    setUsername(event.target.value);
  }

  function handleNewCommentTextAreaChange(
    event: React.ChangeEvent<HTMLTextAreaElement>
  ) {
    setComment(event.target.value);
  }

  return (
    <div className={styles['page-comments-container']}>
      <NewComment
        username={username}
        comment={comment}
        onChangeInput={handleUsernameInputChange}
        onChangeTextArea={handleNewCommentTextAreaChange}
        onSubmit={handleClickSubmitComment}
      />
      <section className={styles['section-comments']}>
        {comments.map(({ id, username, comment }) => (
          <Comment key={id} username={username} comment={comment} />
        ))}
      </section>
    </div>
  );
}

export { Comments };

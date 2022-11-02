import React from 'react';
import { v4 as uuidv4 } from 'uuid';
import { Comment } from '../Comment';
import styles from './Article.module.css';
import { IArticleProps } from './ArticleTypes';

function Article(props: IArticleProps) {
  return (
    <li className={styles['li-container']}>
      <a className={styles['li-container-a']} href={props.url} target="_blank">
        {props.title}
      </a>
      {props.comments.length > 0 ? (
        <ol className={styles['comment-container']}>
          {props.comments.map((comment) => (
            <Comment key={uuidv4()} comment={comment} />
          ))}
        </ol>
      ) : (
        <></>
      )}
    </li>
  );
}

export { Article };

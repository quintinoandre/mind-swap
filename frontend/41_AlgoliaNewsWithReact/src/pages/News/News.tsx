import React, { useEffect, useState } from 'react';
import { useStateIfMounted } from 'use-state-if-mounted';
import { Article, Header, ViewCommentsButton } from '../../components';
import * as newsService from '../../services/newsService';
import styles from './News.module.css';
import { INews } from './NewsTypes';

function News() {
  const [news, setNews] = useStateIfMounted<INews[]>([]);
  const [comments, setComments] = useState<string[]>([]);
  const [buttonId, setButtonId] = useState<string>('');

  async function findNews(
    subject: string,
    numberOfNews: number
  ): Promise<void> {
    const response = await newsService.findNews(subject, numberOfNews);

    setNews([...response]);
  }

  useEffect(() => {
    void findNews('html', 30);
  }, []);

  async function handleClickViewCommentsButton(id: string) {
    const response = await newsService.findNewsComments(id);

    setButtonId(id);

    setComments([...response]);
  }

  return (
    <>
      <Header />
      <main className={styles['main-container']}>
        <ol>
          {news.map((article) => (
            <div key={article.id} className={styles['article-container']}>
              <Article
                title={article.title}
                url={article.url}
                comments={article.id === buttonId ? comments : []}
              />
              <ViewCommentsButton
                id={article.id}
                hidden={article.id === buttonId}
                onClick={(buttonId) => handleClickViewCommentsButton(buttonId)}
              />
            </div>
          ))}
        </ol>
      </main>
    </>
  );
}

export { News };

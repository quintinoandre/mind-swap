import { api } from '../baseService';

async function findNews(subject: string, numberOfNews: number) {
  const response = await api.get(
    `/search?query=${subject}&hitsPerPage=${numberOfNews}`
  );

  const news = response.data.hits.map((article) => {
    return {
      id: article.objectID,
      title: article.title,
      url: article.url,
    };
  });

  return news;
}

async function findNewsComments(newsId: string) {
  const response = await api.get(`/items/${newsId}`);

  const comments = response.data.children.map((item) => item.text);

  return comments;
}

export { findNews, findNewsComments };

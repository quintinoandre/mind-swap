import axios from 'axios';

const BASE_URL = 'http://hn.algolia.com/api/v1';

const api = axios.create({ baseURL: BASE_URL });

async function findNews(subject, numberOfNews) {
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

async function findNewsComments(newsId) {
  const response = await api.get(`/items/${newsId}`);

  const comments = response.data.children.map((item) => item.text);

  return comments;
}

export { findNews, findNewsComments };

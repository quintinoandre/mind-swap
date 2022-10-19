import axios from 'axios';

const BASE_URL = 'http://hn.algolia.com/api/v1';

const api = axios.create({ baseURL: BASE_URL });

async function findNews(subject, numberOfNews) {
  const response = await api.get(
    `/search?query=${subject}&hitsPerPage=${numberOfNews}`
  );

  const news = response.data.hits.map((article) => {
    return {
      title: article.title,
      url: article.url,
    };
  });

  return news;
}

export { findNews };

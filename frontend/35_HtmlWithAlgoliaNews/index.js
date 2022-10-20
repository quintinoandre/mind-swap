import { findNews } from './api';

(async () => {
  const news = await findNews('html', 30);

  const body = document.querySelector('body');

  const header = document.createElement('header');

  header.innerText = 'Hacker News';

  body.appendChild(header);

  const main = document.createElement('main');

  body.appendChild(main);

  const ol = document.createElement('ol');

  main.appendChild(ol);

  news.map((item) => {
    const a = document.createElement('a');

    a.innerText = item.title;

    a.href = item.url;

    a.target = '_blank'

    const li = document.createElement('li');

    li.appendChild(a);

    ol.appendChild(li);
  });
})();

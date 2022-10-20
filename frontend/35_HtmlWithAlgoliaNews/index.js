import { findNews, findNewsComments } from './api';

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

  async function handleButtonClick(buttonId) {
    const newsId = buttonId.replace('button', '');

    const newsComments = await findNewsComments(newsId);

    const nestedOl = document.createElement('ol');

    const li = document.querySelector(`#li${newsId}`);

    li.appendChild(nestedOl);

    newsComments.forEach((comment) => {
      const nestedLi = document.createElement('li');

      nestedLi.innerHTML = comment;

      nestedOl.appendChild(nestedLi);
    });

    document.querySelector(`#${buttonId}`).remove();
  }

  news.forEach((item) => {
    const a = document.createElement('a');

    a.innerText = item.title;

    a.href = item.url;

    a.target = '_blank';

    const div = document.createElement('div');

    ol.appendChild(div);

    const li = document.createElement('li');

    li.setAttribute('id', `li${item.id}`);

    li.appendChild(a);

    div.appendChild(li);

    const button = document.createElement('button');

    button.innerText = 'view comments';

    button.setAttribute('id', `button${item.id}`);

    button.addEventListener(
      'click',
      ({ target: { id } }) => handleButtonClick(id),
      { once: true }
    );

    div.appendChild(button);
  });
})();

import React from 'react';
import styles from './Header.module.css';

function Header() {
  return (
    <header className={styles.headerContainer}>
      <span>TODO</span>
      <span>LIST</span>
    </header>
  );
}

export { Header };

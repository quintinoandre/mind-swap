import React from 'react';
import { Icon } from '../Icon';
import styles from './Empty.module.css';

function Empty() {
  return (
    <div className={styles.emptyContainer}>
      <Icon name="clipboard" />
      <div>
        <strong>You still have no tasks registered</strong>
        <p>Create tasks and organize your items to do</p>
      </div>
    </div>
  );
}

export { Empty };

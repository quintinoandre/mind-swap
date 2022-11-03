import React from 'react';
import styles from './Info.module.css';
import { IInfoProps } from './InfoTypes';

function Info(props: IInfoProps) {
  return (
    <div className={styles.infoContainer}>
      <div className={styles.createdTasksContainer}>
        Tasks created
        <span className={styles.span}>{props.numberOfTasks}</span>
      </div>
      <div className={styles.completedTasksContainer}>
        Completed
        <span className={styles.span}>
          {props.numberOfCompletedTasks} of {props.numberOfTasks}
        </span>
      </div>
    </div>
  );
}

export { Info };

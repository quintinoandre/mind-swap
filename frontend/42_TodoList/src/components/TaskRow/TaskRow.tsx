import { Check, Circle, Trash } from 'phosphor-react';
import React from 'react';
import styles from './TaskRow.module.css';
import { ITaskRowProps } from './TaskRowTypes';

function TaskRow(props: ITaskRowProps) {
  return (
    <tr className={styles.taskRowContainer}>
      <td>
        {props.done ? (
          <button
            className={styles.checkCircleButton}
            onClick={() => props.onClickUncheckTask(props.id)}
            title="Mark the task as not done"
          >
            <Check size={24} />
          </button>
        ) : (
          <button
            className={styles.circleButton}
            onClick={() => props.onClickCheckTask(props.id)}
            title="Mark the task as done"
          >
            <Circle size={24} />
          </button>
        )}
      </td>
      <td>
        {props.done ? (
          <p className={styles.taskDone}>{props.title}</p>
        ) : (
          <p className={styles.taskNotDone}>{props.title}</p>
        )}
      </td>
      <td>
        <button
          className={styles.trashButton}
          onClick={() => props.onClickDeleteTask(props.id)}
          title="Delete task"
        >
          <Trash size={24} />
        </button>
      </td>
    </tr>
  );
}

export { TaskRow };

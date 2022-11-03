import { PlusCircle } from 'phosphor-react';
import React, { useState } from 'react';
import styles from './NewTask.module.css';
import { INewTaskProps } from './NewTaskTypes';

function NewTask(props: INewTaskProps) {
  const [title, setTitle] = useState<string>('');

  function handleChangeNewTaskInput(title: string) {
    setTitle(title);
  }

  function handleClickCreateNewTaskButton() {
    props.onClickNewTask(title);

    setTitle('');
  }

  const isSubmitDisable = !title;

  return (
    <form className={styles.formContainer}>
      <input
        className={styles.taskInput}
        id="title"
        type="text"
        placeholder="Add a new task"
        value={title}
        onChange={({ target: { value } }) => handleChangeNewTaskInput(value)}
      />
      <button
        className={styles.createNewTaskButton}
        type="submit"
        disabled={isSubmitDisable}
        onClick={handleClickCreateNewTaskButton}
      >
        Create
        <PlusCircle size={16} />
      </button>
    </form>
  );
}

export { NewTask };

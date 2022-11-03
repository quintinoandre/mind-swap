import React, { useState } from 'react';
import { v4 as uuidv4 } from 'uuid';
import { Empty, Header, Info, NewTask, TaskRow } from '../../components';
import styles from './TodoList.module.css';
import { ITask } from './TodoListTypes';

function TodoList() {
  const [tasks, setTasks] = useState<ITask[]>([]);

  function onClickCreateNewTask(title: string) {
    const newTask: ITask = {
      id: uuidv4(),
      title,
      done: false,
    };

    setTasks((previousTasks) => [...previousTasks, newTask]);
  }

  function findNumberOfTasks(): number {
    return tasks.length;
  }

  function findNumberOfCompletedTasks(): number {
    return tasks.filter((task) => task.done === true).length;
  }

  function onClickCheckTask(id: string) {
    const taskIndex = tasks.findIndex((task) => task.id === id);

    if (taskIndex < 0) {
      return tasks;
    }

    const updatedTasks = [...tasks];

    updatedTasks.splice(taskIndex, 1, { ...tasks[taskIndex], done: true });

    setTasks([...updatedTasks]);
  }

  function onClickUncheckTask(id: string) {
    const taskIndex = tasks.findIndex((task) => task.id === id);

    if (taskIndex < 0) {
      return tasks;
    }

    const updatedTasks = [...tasks];

    updatedTasks.splice(taskIndex, 1, { ...tasks[taskIndex], done: false });

    setTasks([...updatedTasks]);
  }

  function onClickDeleteTask(id: string) {
    const taskIndex = tasks.findIndex((task) => task.id === id);

    if (taskIndex < 0) {
      return tasks;
    }

    const updatedTasks = [...tasks];

    updatedTasks.splice(taskIndex, 1);

    setTasks([...updatedTasks]);
  }

  return (
    <>
      <Header />
      <NewTask onClickNewTask={(title) => onClickCreateNewTask(title)} />
      <div className={styles.tasksContainer}>
        <Info
          numberOfTasks={findNumberOfTasks()}
          numberOfCompletedTasks={findNumberOfCompletedTasks()}
        />
        {tasks.length > 0 ? (
          <div className={styles.listContainer}>
            <table>
              <thead>
                <tr>
                  <th>Status</th>
                  <th>Task</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody>
                {tasks.map((task) => (
                  <TaskRow
                    key={task.id}
                    {...task}
                    onClickCheckTask={(id) => onClickCheckTask(id)}
                    onClickUncheckTask={(id) => onClickUncheckTask(id)}
                    onClickDeleteTask={(id) => onClickDeleteTask(id)}
                  />
                ))}
              </tbody>
            </table>
          </div>
        ) : (
          <Empty />
        )}
      </div>
    </>
  );
}

export { TodoList };

interface ITaskRowProps {
  id: string;
  title: string;
  done: boolean;
  onClickCheckTask: (id: string) => void;
  onClickUncheckTask: (id: string) => void;
  onClickDeleteTask: (id: string) => void;
}

export { ITaskRowProps };

interface NewCommentProps {
  username: string;
  comment: string;
  onSubmit: (event: React.FormEvent<HTMLFormElement>) => void;
  onChangeInput: (event: React.ChangeEvent<HTMLInputElement>) => void;
  onChangeTextArea: (event: React.ChangeEvent<HTMLTextAreaElement>) => void;
}

export { NewCommentProps };

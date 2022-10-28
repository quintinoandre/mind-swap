import React from 'react';
import { IButtonProps } from './ButtonTypes';

function Button(props: IButtonProps) {
  return <button onClick={props.onClick}>Spoiler Button</button>;
}

export { Button };

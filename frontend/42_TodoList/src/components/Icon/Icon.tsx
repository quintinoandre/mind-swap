import React from 'react';

import { IconClipboard } from '../IconFamily';
import { IIconProps } from './IconTypes';

function Icon(props: IIconProps): JSX.Element {
  switch (props.name) {
    case 'clipboard':
      return <IconClipboard />;
    default:
      return <IconClipboard />;
  }
}

export { Icon };

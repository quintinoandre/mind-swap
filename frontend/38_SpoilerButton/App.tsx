import React, { useState } from 'react';

import { Button } from './src/components/Button';
import { Spoiler } from './src/components/Spoiler/Spoiler';

function App() {
  const [showSpoiler, setShowSpoiler] = useState<boolean>(false);

  function handleClickSpoilerButton() {
    setShowSpoiler(!showSpoiler);
  }

  return (
    <>
      <Button onClick={handleClickSpoilerButton} />
      {showSpoiler ? <Spoiler /> : <></>}
    </>
  );
}

export { App };

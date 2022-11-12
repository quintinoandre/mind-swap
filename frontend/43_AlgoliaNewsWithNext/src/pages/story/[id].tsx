import { ChangeEvent, useEffect, useState } from 'react';
import {
  Button,
  Form,
  Input,
  Label,
  PageContainer,
} from '../../styles/pages/story';

import { useRouter } from 'next/router';
import * as storiesService from '../../services/storiesService';
import { IStoryDetails } from './storyTypes';

function Story() {
  const router = useRouter();

  const [id, setId] = useState<number>(0);
  const [storyDetails, setStoryDetails] = useState({} as IStoryDetails);

  function handleError(error: any): void {
    console.error(error.response ? error.response.data : error.message);
  }

  async function findStoryDetails(storyId: number): Promise<void> {
    try {
      const response = await storiesService.findStoryDetails(storyId);

      setStoryDetails(response);
    } catch (error) {
      handleError(error);
    }
  }

  function handleClickSearchButton() {
    void findStoryDetails(id);
  }

  useEffect(() => {
    const queryId = Number(router.query.id);

    if (queryId) {
      void findStoryDetails(queryId);
    }
  }, [router]);

  return (
    <PageContainer>
      <Form>
        <Label htmlFor="id">Id</Label>
        <Input
          id="id"
          type="number"
          onChange={(event: ChangeEvent<HTMLInputElement>) =>
            setId(Number(event.target.value))
          }
        />
        <Button type="button" onClick={handleClickSearchButton}>
          Search
        </Button>
      </Form>
      <h2>{storyDetails.title}</h2>
      <h2>{storyDetails.points}</h2>
      <ol>
        {storyDetails.children?.map((detail) => (
          <li
            key={detail.id}
            dangerouslySetInnerHTML={{ __html: detail.text }}
          ></li>
        ))}
      </ol>
    </PageContainer>
  );
}

export default Story;

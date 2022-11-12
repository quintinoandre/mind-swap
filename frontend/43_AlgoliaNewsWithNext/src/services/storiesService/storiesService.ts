import { api } from '../../lib';
import { IStoryDetails } from './storiesServiceTypes';

async function findStoryDetails(storyId: number): Promise<IStoryDetails> {
  const response = await api.get(`/items/${storyId}`);

  return response.data;
}

export { findStoryDetails };

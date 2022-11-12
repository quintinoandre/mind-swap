interface IChildren {
  id: number;
  created_at: string;
  author: string;
  text: string;
  points: number;
  parent_id: number;
}

interface IStoryChildren {
  id: number;
  created_at: string;
  author: string;
  text: string;
  points: number;
  parent_id: number;
  children: IChildren[];
}

interface IStoryDetails {
  id: number;
  created_at: string;
  author: string;
  title: string;
  url: string;
  text: string;
  points: number;
  parent_id: number;
  children: IStoryChildren[];
}

export type { IStoryDetails };

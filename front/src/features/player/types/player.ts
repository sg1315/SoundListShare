// YouTube 기반 재생을 전제로 한 타입

export type Track = {
  id: string;              // 내부 식별자
  youtubeVideoId: string;  // 유튜브 videoId
  title: string;
  artist: string;
  thumbnailUrl?: string;
};

export type PlayerStatus =
  | 'idle'
  | 'loading'
  | 'playing'
  | 'paused'
  | 'ended';

export type PlayerControls = {
  play: () => void;
  pause: () => void;
  seek: (seconds: number) => void;
  setVolume: (volume: number) => void;
  next: () => void;
  prev: () => void;
};

export type PlayerState = {
  currentTrack: Track | null;
  status: PlayerStatus;
  currentTime: number;
  duration: number;
  volume: number;
};

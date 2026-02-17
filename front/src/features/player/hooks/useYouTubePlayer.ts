import { Track, PlayerState, PlayerControls } from '../types/player';

/**
 * YouTube Player Hook
 *
 * ❗ 내부 구현은 YouTube IFrame API 기준
 * ❗ UI / 컴포넌트에서는 이 hook의 결과만 사용
 */
export const useYouTubePlayer = (): PlayerState & PlayerControls => {
  // =========================
  // 상태 (임시)
  // =========================
  
  // const currentTrack: Track | null = null;

  // TEST : 임시로 UI 보려고 해둔거.
  const currentTrack: Track = {
    id: 'test',
    youtubeVideoId: 'dQw4w9WgXcQ',
    title: '노래 제목 1.',
    artist: '가수 명',
    thumbnailUrl: '',
  };


  const status: PlayerState['status'] = 'idle';
  const currentTime = 0;
  const duration = 0;
  const volume = 0.7;

  // =========================
  // 컨트롤 함수 (구현 예정)
  // =========================

  const play = () => {
    // TODO: YouTube Player playVideo()
  };

  const pause = () => {
    // TODO: YouTube Player pauseVideo()
  };

  const seek = (seconds: number) => {
    // TODO: YouTube Player seekTo(seconds)
  };

  const setVolume = (volume: number) => {
    // TODO: YouTube Player setVolume(volume)
  };

  const next = () => {
    // TODO: playlist 다음 곡
  };

  const prev = () => {
    // TODO: playlist 이전 곡
  };

  return {
    // state
    currentTrack,
    status,
    currentTime,
    duration,
    volume,

    // controls
    play,
    pause,
    seek,
    setVolume,
    next,
    prev,
  };
};

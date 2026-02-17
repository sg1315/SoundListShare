import PlayerBar from './PlayerBar';
import { useYouTubePlayer } from './hooks/useYouTubePlayer';

const PlayerBarContainer = () => {
  const {
    currentTrack,
    status,
    play,
    pause,
    seek,
    currentTime,
    duration,
    volume,
    setVolume,
  } = useYouTubePlayer();

  if (!currentTrack) return null;

  return (
    <PlayerBar
      track={currentTrack}
      isPlaying={status === 'playing'}
      currentTime={currentTime}
      duration={duration}
      volume={volume}
      onPlay={play}
      onPause={pause}
      onChangeVolume={setVolume}
      onSeek={seek}
    />
  );
};

export default PlayerBarContainer;

import {
  Bar,
  Left,
  Center,
  Right,
  Cover,
  TrackInfo,
  Title,
  Artist,
  ControlButton,
} from './PlayerBar.styles';
import { Track } from './types/player';
import ProgressBar from './controls/ProgressBar';


type Props = {
  track: Track;
  isPlaying: boolean;
  currentTime: number;
  duration: number;
  volume: number;
  onPlay: () => void;
  onPause: () => void;
  onChangeVolume: (v: number) => void;
  onSeek: (seconds: number) => void;
};

const PlayerBar = ({
  track,
  isPlaying,
  currentTime,
  duration,
  onPlay,
  onPause,
}: Props) => {
  return (
    <Bar>
      <Left>
        <Cover />
        <TrackInfo>
          <Title>{track.title}</Title>
          <Artist>{track.artist}</Artist>
        </TrackInfo>
      </Left>

      <Center>
        <ControlButton onClick={isPlaying ? onPause : onPlay}>
          {isPlaying ? '⏸' : '▶'}
        </ControlButton>
        <ProgressBar
          currentTime={currentTime}
          duration={duration}
          onSeek={(sec) => {
            // 🔥 여기서 hook의 seek 호출
            console.log('seek to', sec);
          }}
        />
      </Center>

      <Right>{/* Volume / Progress */}</Right>
    </Bar>
  );
};

export default PlayerBar;

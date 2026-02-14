import { formatTime } from './useProgressBar';
import {
  Wrapper,
  TimeText,
  Slider,
} from './ProgressBar.styles';

type Props = {
  currentTime: number;
  duration: number;
  onSeek: (seconds: number) => void;
};

const ProgressBar = ({
  currentTime,
  duration,
  onSeek,
}: Props) => {
  const handleChange = (value: number) => {
    onSeek(value);
  };

  return (
    <Wrapper>
      <Slider
        type="range"
        min={0}
        max={duration || 0}
        value={currentTime}
        onChange={(e: React.ChangeEvent<HTMLInputElement>) => handleChange(Number(e.target.value))}
      />
      <TimeText>{formatTime(currentTime)} /</TimeText>
      <TimeText>{formatTime(duration)}</TimeText>
    </Wrapper>
  );
};

export default ProgressBar;

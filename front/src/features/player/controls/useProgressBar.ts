/**
 * 시간 포맷 유틸
 * 75초 → 1:15
 */
export const formatTime = (seconds: number): string => {
  if (!seconds || Number.isNaN(seconds)) return '0:00';

  const mins = Math.floor(seconds / 60);
  const secs = Math.floor(seconds % 60);

  return `${mins}:${secs < 10 ? `0${secs}` : secs}`;
};

/**
 * 추후 확장용 hook
 * 현재는 단순 인터페이스 유지용
 */
export const useProgressBar = () => {
  // TODO:
  // - drag 상태 관리
  // - buffering 표시
  // - throttle 처리

  return {};
};

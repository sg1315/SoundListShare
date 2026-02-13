// components/player/PlayerBar.styles.ts
import styled from 'styled-components';

export const Bar = styled.div`
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;

  height: 72px;
  background: #0f0f1f;
  border-top: 1px solid rgba(255,255,255,0.1);

  display: flex;
  align-items: center;
  padding: 0 24px;
`;

export const Left = styled.div`
  display: flex;
  align-items: center;
  gap: 12px;
  width: 30%;
`;

export const Center = styled.div`
  flex: 1;
  display: flex;
  justify-content: center;
`;

export const Right = styled.div`
  width: 30%;
  display: flex;
  justify-content: flex-end;
`;

export const Cover = styled.div`
  width: 40px;
  height: 40px;
  background: #ccc;
  border-radius: 4px;
`;

export const TrackInfo = styled.div`
  display: flex;
  flex-direction: column;
`;

export const Title = styled.div`
  font-size: 14px;
  color: white;
`;

export const Artist = styled.div`
  font-size: 12px;
  color: #aaa;
`;

export const ControlButton = styled.button`
  font-size: 20px;
  color: white;
`;

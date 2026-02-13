// pages/search/SearchPageSkeleton.styles.ts
import styled, { keyframes } from 'styled-components';

const shimmer = keyframes`
  0% { background-position: -200px 0; }
  100% { background-position: calc(200px + 100%) 0; }
`;

const Skeleton = styled.div`
  background: linear-gradient(
    90deg,
    rgba(255,255,255,0.06) 25%,
    rgba(255,255,255,0.14) 37%,
    rgba(255,255,255,0.06) 63%
  );
  background-size: 400px 100%;
  animation: ${shimmer} 1.4s ease infinite;
  border-radius: 6px;
`;

export const PageWrapper = styled.div`
  display: flex;
  flex-direction: column;
  gap: 20px;
`;

export const Tabs = styled.div`
  display: flex;
  gap: 8px;
`;

export const TabSkeleton = styled(Skeleton)`
  width: 64px;
  height: 28px;
  border-radius: 14px;
`;

export const List = styled.div`
  display: flex;
  flex-direction: column;
`;

export const Row = styled.div`
  display: grid;
  grid-template-columns: 40px 1fr 1fr 80px 24px;
  align-items: center;
  gap: 16px;
  padding: 10px 0;
`;

export const Thumb = styled(Skeleton)`
  width: 36px;
  height: 36px;
  border-radius: 4px;
`;

export const Title = styled(Skeleton)`
  width: 70%;
  height: 14px;
`;

export const Artist = styled(Skeleton)`
  width: 50%;
  height: 14px;
`;

export const Duration = styled(Skeleton)`
  width: 48px;
  height: 12px;
  justify-self: end;
`;

export const More = styled(Skeleton)`
  width: 16px;
  height: 16px;
  border-radius: 50%;
`;

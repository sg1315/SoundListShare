// pages/MainPageSkeleton.styles.ts
import styled, { keyframes } from 'styled-components';

const shimmer = keyframes`
  0% { background-position: -200px 0; }
  100% { background-position: calc(200px + 100%) 0; }
`;

const SkeletonBase = styled.div`
  background: linear-gradient(
    90deg,
    rgba(255,255,255,0.08) 25%,
    rgba(255,255,255,0.16) 37%,
    rgba(255,255,255,0.08) 63%
  );
  background-size: 400px 100%;
  animation: ${shimmer} 1.4s ease infinite;
`;

export const PageWrapper = styled.div`
  padding: 24px;
  display: flex;
  flex-direction: column;
  gap: 32px;
`;

export const Section = styled.section`
  display: flex;
  flex-direction: column;
  gap: 16px;
`;

export const SectionTitle = styled.h3`
  display: inherit;
  font-size: ${({ theme }) => theme.fontSizes.lg};
  font-weight: ${({ theme }) => theme.fontWeights.semibold};
  color: ${({ theme }) => theme.colors.white};
`;

export const Grid = styled.div`
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 16px;
`;

export const SkeletonCard = styled(SkeletonBase)`
  aspect-ratio: 1 / 1;
  border-radius: ${({ theme }) => theme.borderRadius.lg};
  padding: 12px;

  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  gap: 6px;
`;

export const SkeletonCircle = styled(SkeletonBase)`
  width: 120px;
  height: 120px;
  border-radius: 50%;
  margin: 0 auto 12px;
`;

export const SkeletonText = styled(SkeletonBase)<{ $small?: boolean }>`
  width: ${({ $small }) => ($small ? '60%' : '80%')};
  height: ${({ $small }) => ($small ? '12px' : '14px')};
  border-radius: 4px;
`;

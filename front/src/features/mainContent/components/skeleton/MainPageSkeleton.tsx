// pages/MainPageSkeleton.tsx
import {
  PageWrapper,
  Section,
  SectionTitle,
  Grid,
  SkeletonCard,
  SkeletonCircle,
  SkeletonText,
} from './MainPageSkeleton.styles';

const MainPageSkeleton = () => {
  return (
    <PageWrapper>
      {/* 인기 상승 곡 */}
      <Section>
        <SectionTitle>인기 상승 곡</SectionTitle>
        <Grid>
          {Array.from({ length: 4 }).map((_, i) => (
            <SkeletonCard key={i}>
              <SkeletonText />
              <SkeletonText $small />
            </SkeletonCard>
          ))}
        </Grid>
      </Section>

      {/* 인기 아티스트 */}
      <Section>
        <SectionTitle>인기 아티스트</SectionTitle>
        <Grid>
          {Array.from({ length: 4 }).map((_, i) => (
            <div key={i} style={{ textAlign: 'center' }}>
              <SkeletonCircle />
              <SkeletonText />
              <SkeletonText $small />
            </div>
          ))}
        </Grid>
      </Section>

      {/* 인기 앨범 */}
      <Section>
        <SectionTitle>인기 앨범</SectionTitle>
        <Grid>
          {Array.from({ length: 4 }).map((_, i) => (
            <SkeletonCard key={i}>
              <SkeletonText />
              <SkeletonText $small />
            </SkeletonCard>
          ))}
        </Grid>
      </Section>

      {/* 추천 차트 */}
      <Section>
        <SectionTitle>추천 차트</SectionTitle>
        <Grid>
          {Array.from({ length: 4 }).map((_, i) => (
            <SkeletonCard key={i}>
              <SkeletonText />
              <SkeletonText $small />
            </SkeletonCard>
          ))}
        </Grid>
      </Section>
    </PageWrapper>
  );
};

export default MainPageSkeleton;

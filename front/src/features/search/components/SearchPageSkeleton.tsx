// pages/search/SearchPageSkeleton.tsx
import {
  PageWrapper,
  Tabs,
  TabSkeleton,
  List,
  Row,
  Thumb,
  Title,
  Artist,
  Duration,
  More,
} from './SearchPageSkeleton.styles';

const SearchPageSkeleton = () => {
  return (
    <PageWrapper>
      {/* 필터 탭 */}
      <Tabs>
        {Array.from({ length: 4 }).map((_, i) => (
          <TabSkeleton key={i} />
        ))}
      </Tabs>

      {/* 결과 리스트 */}
      <List>
        {Array.from({ length: 12 }).map((_, i) => (
          <Row key={i}>
            <Thumb />
            <Title />
            <Artist />
            <Duration />
            <More />
          </Row>
        ))}
      </List>
    </PageWrapper>
  );
};

export default SearchPageSkeleton;

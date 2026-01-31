// components/layout/Sidebar/Sidebar.tsx
import {
  SidebarWrapper,
  NavList,
  NavItem,
  Divider,
  SectionTitle,
  PlaylistCard,
  CreatePlaylistButton,
} from './Sidebar.styles';

const Sidebar = () => {
  return (
    <SidebarWrapper>
      {/* 상단 네비게이션 */}
      <NavList>
        <NavItem>
          <span className="icon">🏠</span>
          <span>홈</span>
        </NavItem>

        <NavItem>
          <span className="icon">✨</span>
          <span>AI 생성</span>
        </NavItem>

        <NavItem>
          <span className="icon">📊</span>
          <span>음악 통계</span>
        </NavItem>
      </NavList>

      <Divider />

      {/* 플레이리스트 영역 */}
      <SectionTitle>나만의 플레이리스트</SectionTitle>

      <PlaylistCard>
        <strong>잔잔한 노래 10곡</strong>
        <span>포함된 노래 10곡</span>
      </PlaylistCard>

      <CreatePlaylistButton>
        <span className="icon">＋</span>
        새로운 플레이리스트
      </CreatePlaylistButton>
    </SidebarWrapper>
  );
};

export default Sidebar;

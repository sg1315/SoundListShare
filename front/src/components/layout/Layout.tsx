import { Outlet } from 'react-router-dom';
import Header from './Header';
import Sidebar from './Sidebar';
import { Content, LayoutWrapper, Main, MainInner } from './Layout.styles';
import PlayerBarContainer from '../../features/player/PlayerBarContainer';

const Layout = () => {
  return (
    <LayoutWrapper>
      <Header />
      <Content>
        <Sidebar />
        <Main>
          <MainInner>
            <Outlet />
          </MainInner>
        </Main>
      </Content>
      <PlayerBarContainer />
    </LayoutWrapper>
  );
};

export default Layout
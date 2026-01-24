import { Outlet } from 'react-router-dom';
import Header from './Header';

const Layout = () => {
  return (
    <>
      <Header />
      <div className="layout">
        {/* <Sidebar /> */}
        <main>
          <Outlet />
        </main>
      </div>
    </>
  );
};

export default Layout
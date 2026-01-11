import { Outlet } from 'react-router-dom';

const Layout = () => {
  return (
    <>
      {/* <Header /> */}
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
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// import './index.css'
import App from './App'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import Layout from './components/layout/Layout'
import MainPage from './pages/MainPage'

// import '@/styles/reset.css';
// import '@/styles/global.css';

const router = createBrowserRouter([
  // 🔹 로그인 전 (레이아웃 없음)
  {
    path: '/login',
    element: <div></div> // <LoginPage />,
  },

  // 🔹 로그인 후 (공용 레이아웃)
  {
    element: <Layout />,
    children: [
      {
        path: '/',
        element: <MainPage />,
      },
      // 여기에 로그인 후 페이지 계속 추가
    ],
  },
]);

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <App>
      <RouterProvider router={router} />
    </App>
  </StrictMode>,
)

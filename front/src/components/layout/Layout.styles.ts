import styled from "styled-components";

export const LayoutWrapper = styled.div`
  height: 100vh;
  display: flex;
  flex-direction: column;
`;

export const Content = styled.div`
  flex: 1;
  display: flex;
  overflow: hidden; /* ⭐ 중요 */
`;

export const Main = styled.main`
  flex: 1;
  overflow-y: auto;
  display: flex;
  justify-content: center; /* ⭐ 핵심 */
  background: linear-gradient(180deg, #141427, #0f1020);
  color: ${({ theme }) => theme.colors.white};
`;

export const MainInner = styled.div`
  width: 100%;
  max-width: 1200px;   /* ⭐ 여기서 가로 제한 */
  padding: 24px;
`;
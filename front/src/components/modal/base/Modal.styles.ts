// // components/modal/base/Modal.styles.ts
// import styled from 'styled-components';

// export const Overlay = styled.div`
//   position: fixed;
//   inset: 0;
//   background: rgba(0, 0, 0, 0.5);
//   z-index: ${({ theme }) => theme.zIndices.modal};

//   display: flex;
//   align-items: center;
//   justify-content: center;
// `;

// export const ModalContainer = styled.div`
//   width: 100%;
//   max-width: 420px;
//   background: ${({ theme }) => theme.colors.white};
//   border-radius: ${({ theme }) => theme.borderRadius.lg};
//   box-shadow: ${({ theme }) => theme.shadows.lg};
//   overflow: hidden;
// `;

// export const Header = styled.div`
//   padding: 16px;
//   display: flex;
//   justify-content: space-between;
//   align-items: center;
//   border-bottom: 1px solid ${({ theme }) => theme.colors.gray[200]};
// `;

// export const Content = styled.div`
//   padding: 16px;
// `;

// export const Footer = styled.div`
//   padding: 16px;
//   border-top: 1px solid ${({ theme }) => theme.colors.gray[200]};
//   display: flex;
//   justify-content: flex-end;
//   gap: 8px;
// `;

// export const CloseButton = styled.button`
//   font-size: 18px;
// `;
// components/modal/base/Modal.styles.ts
import styled from 'styled-components';

export const Overlay = styled.div`
  position: fixed;
  inset: 0;
  z-index: ${({ theme }) => theme.zIndices.modal};

  background: rgba(0, 0, 0, 0.55);
  backdrop-filter: blur(4px);

  display: flex;
  align-items: center;
  justify-content: center;
`;

export const ModalContainer = styled.div`
  width: 100%;
  max-width: 480px;
  padding: 24px;

  background: linear-gradient(
    180deg,
    #1f1f3a 0%,
    #16162b 100%
  );

  border-radius: 16px;
  border: 1px solid rgba(255, 255, 255, 0.12);

  box-shadow:
    0 20px 40px rgba(0, 0, 0, 0.5),
    inset 0 0 0 1px rgba(255, 255, 255, 0.04);

  display: flex;
  flex-direction: column;
  gap: 20px;
`;

export const Header = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;

  color: ${({ theme }) => theme.colors.white};

  h3 {
    font-size: ${({ theme }) => theme.fontSizes.lg};
    font-weight: ${({ theme }) => theme.fontWeights.semibold};
  }
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  gap: 16px;

  color: ${({ theme }) => theme.colors.gray[200]};
`;

export const Footer = styled.div`
  display: flex;
  justify-content: flex-end;
  gap: 12px;
  margin-top: 8px;
`;

export const CloseButton = styled.button`
  width: 32px;
  height: 32px;

  border-radius: 50%;
  color: ${({ theme }) => theme.colors.gray[300]};

  display: flex;
  align-items: center;
  justify-content: center;

  transition: background-color 0.15s ease, color 0.15s ease;

  &:hover {
    background: rgba(255, 255, 255, 0.08);
    color: ${({ theme }) => theme.colors.white};
  }
`;

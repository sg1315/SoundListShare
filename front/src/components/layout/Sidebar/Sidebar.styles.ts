// components/layout/Sidebar/Sidebar.styles.ts
import styled from 'styled-components';

export const SidebarWrapper = styled.aside`
  width: 240px;
  padding: 24px 16px;

  background: linear-gradient(180deg, #141427, #0f1020);
  color: ${({ theme }) => theme.colors.lightwhite};

  display: flex;
  flex-direction: column;
`;

export const NavList = styled.ul`
  display: flex;
  flex-direction: column;
  gap: 12px;
`;

export const NavItem = styled.li`
  display: flex;
  align-items: center;
  gap: 12px;

  padding: 10px 12px;
  border-radius: ${({ theme }) => theme.borderRadius.lg};

  cursor: pointer;
  font-size: ${({ theme }) => theme.fontSizes.sm};

  &:hover {
    background: rgba(255, 255, 255, 0.08);
  }

  .icon {
    font-size: 16px;
  }
`;

export const Divider = styled.hr`
  border: none;
  height: 1px;
  margin: 20px 0;

  background: rgba(255, 255, 255, 0.1);
`;

export const SectionTitle = styled.h4`
  font-size: ${({ theme }) => theme.fontSizes.xs};
  font-weight: ${({ theme }) => theme.fontWeights.semibold};
  margin-bottom: 12px;

  color: rgba(255, 255, 255, 0.6);
`;

export const PlaylistCard = styled.div`
  background: rgba(255, 255, 255, 0.08);
  border-radius: ${({ theme }) => theme.borderRadius.lg};

  padding: 12px;
  margin-bottom: 12px;

  display: flex;
  flex-direction: column;
  gap: 4px;

  strong {
    font-size: ${({ theme }) => theme.fontSizes.sm};
    color: ${({ theme }) => theme.colors.white};
  }

  span {
    font-size: ${({ theme }) => theme.fontSizes.xs};
    color: rgba(255, 255, 255, 0.6);
  }
`;

export const CreatePlaylistButton = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;

  padding: 10px;
  border-radius: ${({ theme }) => theme.borderRadius.lg};

  font-size: ${({ theme }) => theme.fontSizes.sm};
  color: rgba(255, 255, 255, 0.8);

  background: rgba(255, 255, 255, 0.05);

  &:hover {
    background: rgba(255, 255, 255, 0.12);
    color: ${({ theme }) => theme.colors.white};
  }

  .icon {
    font-size: 16px;
  }
`;

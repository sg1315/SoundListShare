// components/layout/Header/Header.styles.ts
import styled from 'styled-components';

export const HeaderWrapper = styled.header`
  width: 100%;
  height: 64px;
  background: linear-gradient(90deg, #1b1b2f, #16213e);
  display: flex;
  justify-content: center;
`;

export const Inner = styled.div`
  width: 100%;
  max-width: 1200px;
  padding: 0 24px;

  display: flex;
  align-items: center;
  gap: 24px;
`;

export const LogoArea = styled.div`
  min-width: 120px;
  display: flex;
  align-items: center;
  font-weight: 700;
  color: #ffb38a;
  cursor: pointer;
`;

export const LogoTextArea = styled.div`
  padding-left: 10px;
  border-left: solid #ffb38a 2px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  height: 40px;
  margin-left: 10px;
`;

export const LogoTitle = styled.h2`
  font-size: 20px;
  height: 26px;
  line-height: 1.3;
`;

export const LogoSubTitle = styled.span`
  font-size: 10px;
`;

export const SearchArea = styled.div`
  flex: 1;
  display: flex;
  justify-content: center;
`;

export const SearchBox = styled.div`
  width: 100%;
  max-width: 520px;
  height: 40px;

  background: rgba(255, 255, 255, 0.08);
  border-radius: 999px;

  display: flex;
  align-items: center;
  gap: 8px;
  padding: 0 16px;

  input {
    flex: 1;
    background: transparent;
    border: none;
    outline: none;
    color: #fff;
    font-size: 14px;

    &::placeholder {
      color: rgba(255, 255, 255, 0.6);
    }
  }

  .icon {
    color: rgba(255, 255, 255, 0.6);
    font-size: 14px;
  }
`;

export const UserArea = styled.div`
  min-width: 120px;
  display: flex;
  justify-content: flex-end;
  align-items: center;

  .avatar {
    width: 32px;
    height: 32px;
    border-radius: 50%;
    background: #e5e7eb;
    cursor: pointer;
  }
`;

// Header Search
export const SearchForm = styled.form`
  width: 100%;
  max-width: 520px;
  height: 40px;

  display: flex;
  align-items: center;
  gap: 8px;

  padding: 0 16px;
  border-radius: 999px;

  background: rgba(255, 255, 255, 0.08);

  &:focus-within {
    background: rgba(255, 255, 255, 0.12);
  }
`;

export const SearchInput = styled.input`
  flex: 1;
  height: 100%;

  background: transparent;
  border: none;
  outline: none;

  color: #ffffff;
  font-size: 14px;

  &::placeholder {
    color: rgba(255, 255, 255, 0.6);
  }
`;

export const SearchButton = styled.button`
  border: none;
  background: transparent;

  color: rgba(255, 255, 255, 0.7);
  font-size: 14px;
  cursor: pointer;

  padding: 4px 8px;
  border-radius: 8px;

  &:hover {
    background: rgba(255, 255, 255, 0.1);
    color: #ffffff;
  }
`;
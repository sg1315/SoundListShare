import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {
  HeaderWrapper,
  Inner,
  SearchArea,
} from './Header.styles';
import HeaderLogoLink from "./HeaderLogoLink"
import HeaderSearch from './HeaderSearch';
import HeaderUser from './HeaderUser';

const Header = () => {
  // 🔹 UI용 임시 상태
  const [keyword, setKeyword] = useState('');
  const navigate = useNavigate();

  const search = () => {
    // 아직 로직 없음
    // console.log('search clicked');
    // e.preventDefault();

    if (!keyword.trim()) return;

    navigate(`/search?keyword=${encodeURIComponent(keyword)}`);
  };

  return (
    <HeaderWrapper>
      <Inner>
        <HeaderLogoLink />

        <SearchArea>
          <HeaderSearch 
            value={keyword}
            onChange={setKeyword}
            onSubmit={search}
          />
        </SearchArea>

        <HeaderUser />
      </Inner>
    </HeaderWrapper>
  )
}

export default Header
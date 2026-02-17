import {
  SearchForm,
  SearchInput,
  SearchButton,
} from './Header.styles';

type Props = {
  value: string;
  onChange: (v: string) => void;
  onSubmit: () => void;
};

const HeaderSearch = ({ value, onChange, onSubmit }: Props) => {
  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();   // ✅ 여기서만 event 처리
    onSubmit();           // ✅ event 없이 호출
  };
  
  return (
    <SearchForm onSubmit={handleSubmit}>
      <SearchInput
        value={value}
        onChange={(e: React.ChangeEvent<HTMLInputElement>) => onChange(e.target.value)}
        placeholder="Search songs, albums, artists"
      />

      <SearchButton type="submit">
        검색
      </SearchButton>
    </SearchForm>
  );
};

export default HeaderSearch;
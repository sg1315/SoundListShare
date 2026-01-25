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
  return (
    <SearchForm
      onSubmit={(e) => {
        e.preventDefault();
        onSubmit();
      }}
    >
      <SearchInput
        value={value}
        onChange={(e) => onChange(e.target.value)}
        placeholder="Search songs, albums, artists"
      />

      <SearchButton type="submit">
        검색
      </SearchButton>
    </SearchForm>
  );
};

export default HeaderSearch;
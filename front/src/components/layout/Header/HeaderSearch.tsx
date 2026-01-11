type Props = {
  value: string;
  onChange: (v: string) => void;
  onSubmit: () => void;
};

const HeaderSearch = ({ value, onChange, onSubmit }: Props) => {
  return (
    <form
      onSubmit={(e) => {
        e.preventDefault();
        onSubmit();
      }}
    >
      <input
        value={value}
        onChange={(e) => onChange(e.target.value)}
      />
      <button type="submit">검색</button>
    </form>
  );
};

export default HeaderSearch;
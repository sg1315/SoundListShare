import styled from 'styled-components';

export const Wrapper = styled.div`
  display: flex;
  align-items: center;
  gap: 12px;
  width: 100%;
`;

export const TimeText = styled.span`
  font-size: 12px;
  color: ${({ theme }) => theme.colors.gray[300]};
  min-width: 40px;
  text-align: center;
`;

export const Slider = styled.input`
  flex: 1;
  height: 4px;
  appearance: none;
  background: ${({ theme }) => theme.colors.gray[600]};
  border-radius: 2px;
  cursor: pointer;

  &::-webkit-slider-thumb {
    appearance: none;
    width: 12px;
    height: 12px;
    border-radius: 50%;
    background: ${({ theme }) => theme.colors.white};
    cursor: pointer;
  }

  &::-moz-range-thumb {
    width: 12px;
    height: 12px;
    border-radius: 50%;
    background: ${({ theme }) => theme.colors.white};
    cursor: pointer;
  }
`;

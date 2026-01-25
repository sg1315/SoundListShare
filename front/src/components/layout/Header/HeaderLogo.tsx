import LogoIcon from '../../../assets/fluent_sound-wave-circle-sparkle-24-regular.svg?react';
import {
  LogoArea,
  LogoTextArea,
  LogoTitle,
  LogoSubTitle
} from './Header.styles';

const HeaderLogo = () => {
  return (
    <LogoArea>
      <LogoIcon width={34} height={34} />
      <LogoTextArea>
        <LogoTitle>S L S</LogoTitle>
        <LogoSubTitle>Sound List Share</LogoSubTitle>
      </LogoTextArea>
    </LogoArea>
  )
}

export default HeaderLogo
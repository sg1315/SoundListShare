// components/modal/base/Modal.tsx
import { ReactNode } from 'react';
import {
  Overlay,
  ModalContainer,
  Header,
  Content,
  Footer,
  CloseButton,
} from './Modal.styles';

type Props = {
  isOpen: boolean;
  title?: string;
  children: ReactNode;
  footer?: ReactNode;
  onClose: () => void;
};

const Modal = ({ isOpen, title, children, footer, onClose }: Props) => {
  if (!isOpen) return null;

  return (
    <Overlay onClick={onClose}>
      <ModalContainer 
        onClick={(e: React.MouseEvent<HTMLDivElement>) =>
          e.stopPropagation()
        }
      >
        <Header>
          <h3>{title}</h3>
          <CloseButton onClick={onClose}>✕</CloseButton>
        </Header>

        <Content>{children}</Content>

        {footer && <Footer>{footer}</Footer>}
      </ModalContainer>
    </Overlay>
  );
};

export default Modal;

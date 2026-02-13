import Modal from "../../modal/base/Modal";

type Props = {
  isOpen: boolean;
  onClose: () => void;
};

const PlaylistCreateModal = ({ isOpen, onClose }: Props) => {
  return (
    <Modal
      isOpen={isOpen}
      title="플레이리스트 만들기"
      onClose={onClose}
      footer={
        <>
          <button onClick={onClose}>취소</button>
          <button>생성</button>
        </>
      }
    >
      {/* 나중에 input 추가 */}
      플레이리스트 이름 입력
    </Modal>
  );
};

export default PlaylistCreateModal;

// sidebar/hooks/usePlaylistModal.ts
import { useState } from 'react';

export const usePlaylistModal = () => {
  const [isOpen, setIsOpen] = useState(false);

  return {
    isOpen,
    openModal: () => setIsOpen(true),
    closeModal: () => setIsOpen(false),
  };
};
package com.velog.velogboard.service;

import com.velog.velogboard.domain.entity.Board;
import com.velog.velogboard.domain.repository.BoardRepository;
import com.velog.velogboard.dto.request.CreateBoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board createBoard(CreateBoardRequest request, Long userId) {
        return boardRepository.save(request.toEntity(userId));
    }

}

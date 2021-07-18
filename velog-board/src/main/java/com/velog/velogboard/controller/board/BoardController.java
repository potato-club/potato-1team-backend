package com.velog.velogboard.controller.board;

import com.velog.velogboard.controller.Result;
import com.velog.velogboard.domain.entity.Board;
import com.velog.velogboard.dto.request.CreateBoardRequest;
import com.velog.velogboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    public Result<Board> createBoard(@RequestBody CreateBoardRequest request) {
        Long userId = 1L;
        return Result.success(boardService.createBoard(request, userId));
    }

}

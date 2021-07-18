package com.velog.velogboard.dto.request;

import com.velog.velogboard.domain.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class CreateBoardRequest {

    @NotEmpty(message = "타이틀은 꼭 적어주세요")
    private String title;

    private String content;

    public Board toEntity(Long userId) {
        return Board.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .build();
    }

}

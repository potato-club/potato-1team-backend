package com.velog.velogboard.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    private String content;

    @Column(nullable = false)
    private Long userId;

    private int likesCount;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private final List<BoardLike> boardLikeList = new ArrayList<>();

    @Builder
    public Board(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.likesCount = 0;
    }

}

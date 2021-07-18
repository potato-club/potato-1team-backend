package com.velog.velogboard.domain.repository;

import com.velog.velogboard.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

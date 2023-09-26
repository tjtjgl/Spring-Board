package com.shspring.board.entity;

import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {

    List<Board> findAllByDeleteYn(final char deleteYn, final Sort sort);
}

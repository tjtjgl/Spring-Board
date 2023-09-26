package com.shspring.board;

import com.shspring.board.entity.Board;
import com.shspring.board.entity.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BoardTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("저장과 조회")
    void save(){
        //1. 게시글 객체 만들기
        Board board = Board.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .writer("이서희")
                .hits(0)
                .deleteYn('N')
                .build();
        System.out.println(board);
        //2. 게시글 객체 저장
        boardRepository.save(board);

        //3. 1번 글 조회
        Board entity = boardRepository.findById(1L).get();
        assertThat(entity.getTitle()).isEqualTo("테스트 제목");
        assertThat(entity.getContent()).isEqualTo("테스트 내용");
        assertThat(entity.getWriter()).isEqualTo("이서희");

    }

    @Test
    @DisplayName("전체조회")
    void findAll(){
        List<Board> boardList = boardRepository.findAll();
        Long boards = boardRepository.count();

        assertThat(boards).isEqualTo(1L);
    }

    @Test
    void delete(){
    boardRepository.deleteAll();

    }





}

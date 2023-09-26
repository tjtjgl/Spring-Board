package com.shspring.board.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    private String title; // 제목

    private String content; // 내용

    private String writer; // 작성자

    private int hits; // 조회 수

    private char deleteYn; // 삭제 여부

    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

    private LocalDateTime modifiedDate; // 수정일

    //게시글 작성
    @Builder
    public Board(Long id, String title, String content, String writer, int hits, char deleteYn) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }

    //게시글 수정
    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.modifiedDate=LocalDateTime.now();
    }

    //조회수 증가
    public void increaseHits(){
        this.hits++;
    }

    //삭제
    public void delete() {
        this.deleteYn = 'Y';
    }
}

package com.shspring.board.dto;


import com.shspring.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardRequestDto {

    private String title;
    private String content;
    private String writer;
    private char deleteYn;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .deleteYn(deleteYn)
                .build();
    }


}

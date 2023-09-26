package com.shspring.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class CommentRequest {
    private Long id;
    private Long postId;
    private  String content;
    private String writer;
}

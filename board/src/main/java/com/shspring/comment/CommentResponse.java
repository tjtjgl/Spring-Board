package com.shspring.comment;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class CommentResponse {

        private Long id;
        private Long postId;
        private String content;
        private String writer;
        private Boolean deleteYn;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

}

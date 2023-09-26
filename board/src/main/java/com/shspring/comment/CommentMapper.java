package com.shspring.comment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    // 댓글 저장
    void save(CommentRequest dto);

    // 댓글 상세조회
    CommentResponse findById(Long id);

    // 댓글 수정
    void update(CommentRequest dto);

    // 댓글 삭제
    void deleteById(Long id);

    // 댓글 리스트 조회
    List<CommentResponse> findAll(Long postId);

    // 댓글 수 조회
    int commentCount(Long postId);


}

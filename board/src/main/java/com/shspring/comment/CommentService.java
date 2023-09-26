package com.shspring.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    // 댓글 저장
    @Transactional
    public Long saveComment(final CommentRequest dto) {
        System.out.println("service savaComment() 호출");
        commentMapper.save(dto);
        return dto.getId();
    }

    // 댓글 상세 정보
    public CommentResponse findCommentById(final Long id) {
        return commentMapper.findById(id);
    }

    // 댓글 수정
    public Long updateComment(final CommentRequest dto) {
        commentMapper.update(dto);
        return dto.getId();
    }

    // 댓글 삭제
    public Long deleteComment(final Long id) {
        commentMapper.deleteById(id);
        return id;
    }

    // 댓글 전체 조회
    public List<CommentResponse> findAllComment(final Long postId) {
        System.out.println("서비스에서 리스트 조회: " + commentMapper.findAll(postId));
        return commentMapper.findAll(postId);
    }

}

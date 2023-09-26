package com.shspring.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class CommentApiController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping("/{postId}/comments")
    public CommentResponse saveComment(@PathVariable final Long postId, @RequestBody final CommentRequest dto) {
        Long id = commentService.saveComment(dto);
        return commentService.findCommentById(id);
    }

    // 댓글 조회
    @GetMapping("/{postId}/comments")
    public List<CommentResponse> findAllComment(@PathVariable final Long postId) {
        return commentService.findAllComment(postId);
    }

    // 댓글 상세 조회
    @GetMapping("/{postId}/comments/{id}")
    public CommentResponse findCommentById(@PathVariable final Long postId,@PathVariable final Long id){

        return commentService.findCommentById(id);
    }


    // 댓글 수정
    @PatchMapping("/{postId}/comments/{id}")
    public CommentResponse updateComment(@PathVariable final Long postId,@PathVariable final Long id, final CommentRequest dto){
        commentService.updateComment(dto);
        return commentService.findCommentById(id);
    }




}

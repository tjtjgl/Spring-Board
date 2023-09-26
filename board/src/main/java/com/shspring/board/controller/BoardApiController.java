package com.shspring.board.controller;

import com.shspring.board.dto.BoardRequestDto;
import com.shspring.board.dto.BoardResponseDto;
import com.shspring.board.model.BoardService;
import com.shspring.paging.CommonParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {

    private final BoardService boardService;

    // 게시글 저장
    @PostMapping("/boards")
    public Long save(@RequestBody final BoardRequestDto dto) {
        return boardService.save(dto);
    }

    // 게시글 전체 조회(페이징처리된 서비스 사용)
    @GetMapping("/boards")
    public Map<String, Object> findAll(final CommonParams params) {
        return boardService.findAll(params);
    }


    // 게시글 수정
    @PatchMapping("/boards/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final BoardRequestDto dto) {
        return boardService.update(id, dto);
    }

    // 게시글 하나 보기
    @GetMapping("/boards/{id}")
    public BoardResponseDto findById(@PathVariable final Long id){
        return boardService.findById(id);
    }

    // 게시글 삭제
    @DeleteMapping("/boards/{id}")
    public Long delete(@PathVariable final Long id){
        return boardService.delete(id);
    }



}

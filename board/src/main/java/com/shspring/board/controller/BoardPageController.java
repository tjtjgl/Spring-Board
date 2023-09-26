package com.shspring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardPageController {


    // 게시글 목록
    @GetMapping("/list")
    public String openBoardList() {
        return "board/list";
    }

    // 게시글 작성
    @GetMapping("/write")
    public String openBoardWrite(@RequestParam(required = false) final Long id, Model model){
        model.addAttribute("id", id);
        return "board/write";
    }

    // 상세 게시글
    @GetMapping("/view/{id}")
    public String openBoardView(@PathVariable final Long id, Model model){
        model.addAttribute("id",id);
        return "board/view";
    }


}

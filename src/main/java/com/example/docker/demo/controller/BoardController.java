package com.example.docker.demo.controller;

import com.example.docker.demo.model.Result;
import com.example.docker.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v2/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public Result retriveBoardList() {
        Result result = boardService.retrieveBoardList();
        return result;
    }

    @GetMapping("/{boardno}")
    public Result retriveBoard(@PathVariable Integer boardno) {
        Result result = boardService.retrieveBoardList(boardno);
        return result;
    }
}

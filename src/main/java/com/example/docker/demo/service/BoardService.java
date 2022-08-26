package com.example.docker.demo.service;

import com.example.docker.demo.model.Board;
import com.example.docker.demo.model.Result;

public interface BoardService {
    public Result createBoard(Board board);
    public Result retrieveBoardList();
    public Result retrieveBoardList(int boardno);
    public Result updateBoard(Board board);
    public Result deleteBoard(int boardno);
}

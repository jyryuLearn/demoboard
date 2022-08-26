package com.example.docker.demo.service;

import com.example.docker.demo.model.Board;
import com.example.docker.demo.model.ErrorResponse;
import com.example.docker.demo.model.Result;
import com.example.docker.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Override
    public Result createBoard(Board board) {
        board = boardRepository.save(board);
        Result result = new Result();
        result.setPayload(board);
        return result;
    }

    @Override
    public Result retrieveBoardList() {
        List<Board> list = boardRepository.findAllByOrderByBoardnoDesc();
        Result result = new Result();
        result.setPayload(list);
        return result;
    }

    @Override
    public Result retrieveBoardList(int boardno) {
        Optional<Board> optionalBoard = boardRepository.findById(boardno);
        Result result = new Result();
        if(optionalBoard.isPresent()) {
            result.setPayload(optionalBoard.get());
        } else {
            result.setError(new ErrorResponse("not exist"));
        }
        return result;
    }

    @Override
    public Result updateBoard(Board board) {
        Optional<Board> optionalBoard = boardRepository.findById(board.getBoardno());
        Result result = new Result();
        if(optionalBoard.isPresent()) {
            board = boardRepository.save(board);
            result.setPayload(board);
        } else {
            result.setError(new ErrorResponse("not exist"));
        }
        return result;
    }

    @Override
    public Result deleteBoard(int boardno) {
        Result result = new Result();
        boolean isPresent = boardRepository.findById(boardno).isPresent();
        if(!isPresent) {
            result.setError(new ErrorResponse("not exist"));
        } else {
            boardRepository.deleteById(boardno);
        }
        return result;
    }
}

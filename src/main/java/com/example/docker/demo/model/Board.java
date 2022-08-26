package com.example.docker.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="zzz_test_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardno;

    private String title;
    private String content;
    private String writer;
}

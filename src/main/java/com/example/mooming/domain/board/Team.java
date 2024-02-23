package com.example.mooming.domain.board;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)     // 시퀀스 1씩 증가
    private Integer team_id;

    private String team_title;

    private Integer team_prsn;      // 제한 인원 수

    private String team_location;

    private String team_content;

    @Column(insertable = false, updatable = false, columnDefinition = "date default LOCALTIMESTAMP")
    private Date team_regdate;
    
}

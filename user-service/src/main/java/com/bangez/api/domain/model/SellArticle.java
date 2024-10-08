package com.bangez.api.domain.model;


import com.bangez.api.domain.baseEntity.SellBaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = {"id"})
@Entity(name = "sellArticles")
public class SellArticle extends SellBaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postTitle;  //제목
    private String postContent;  //내용
    private LocalDate postDate;  //시간
    private Long boardHits;  //조회수
    private String buildType;  //건물 유형
    private String tradeType;  //거래 유형
    private String location;  //지역
    private Long rentPrice;  //보증금 or 전세금 (단위:만)
    private Long monthPrice;  //월세 (단위:만)
    private Long tradePrice; //매매 (단위:만)
    private Long size; //면적 (단위:평)
    private Long roomCount; //방 개수
    private Long toiletCount; //화장실/욕실 개수
    private String numberOfApt; //세대수
    private String acceptForUse; //사용승인일
    private String parking; //주차대수
    private String convenient; //편의시설
    private String floor; //층수
    private String hopeMove; //입주 가능일
    private String status;  //거래 상태

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = true)
//    private User writer;
}
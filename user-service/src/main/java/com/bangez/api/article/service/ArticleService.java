package com.bangez.api.article.service;

import com.bangez.api.article.domain.Article;
import com.bangez.api.article.domain.ArticleDTO;
import com.bangez.api.common.MessengerVO;

import java.util.List;

public interface ArticleService {
    MessengerVO save(ArticleDTO articleDTO);
    MessengerVO deleteById(Long id);
    List<ArticleDTO> findAll();
    Article modify(Long id, Article newArticle);


    default ArticleDTO entityToDTO(Article article){
        return ArticleDTO.builder()
                .id(article.getId())
                .boardHits(article.getBoardHits())
                .postType(article.getPostType())
                .postContent(article.getPostContent())
                .postDate(article.getPostDate())
                .postTitle(article.getPostTitle())
                .build();
    }

    default Article dtoToEntity(ArticleDTO dto) {
        return Article.builder()
                .id(dto.getId())
                .postTitle(dto.getPostTitle())
                .postContent(dto.getPostContent())
                .postDate(dto.getPostDate())
                .boardHits(dto.getBoardHits())
                .postType(dto.getPostType())
                .buildType(dto.getBuildType())
                .tradeType(dto.getTradeType())
                .location(dto.getLocation())
                .rentPrice(dto.getRentPrice())
                .monthPrice(dto.getMonthPrice())
                .tradePrice(dto.getTradePrice())
                .size(dto.getSize())
                .roomCount(dto.getRoomCount())
                .toiletCount(dto.getToiletCount())
                .numberOfApt(dto.getNumberOfApt())
                .acceptForUse(dto.getAcceptForUse())
                .parking(dto.getParking())
                .convenient(dto.getConvenient().toString())
                .floor(dto.getFloor())
                .hopeMove(dto.getHopeMove())
                .moreContent(dto.getMoreContent())
                .build();
    }


}
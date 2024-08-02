package com.bangez.api.sellArticle.service.impl;

import com.bangez.api.common.MessengerVO;
import com.bangez.api.sellArticle.domain.SellArticle;
import com.bangez.api.sellArticle.domain.SellArticleDTO;
import com.bangez.api.sellArticle.repository.SellArticleRepository;
import com.bangez.api.sellArticle.service.SellArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SellArticleServiceImpl implements SellArticleService {

    private final SellArticleRepository repository;


    @Override
    public MessengerVO save(SellArticleDTO dto) {
        repository.save(dtoToEntity(dto));
        return MessengerVO.builder().message("성공").build();
    }

    @Override
    public MessengerVO deleteById(Long id) {
        repository.deleteById(id);
        return MessengerVO.builder().message("삭제 성공").build();
    }

    @Override
    public List<SellArticleDTO> findAll() {
        return repository.findAll().stream().map(i->entityToDTO(i)).toList();
    }

    @Override
    public SellArticle modify(Long id, SellArticle newSellArticle) {
        return repository.findById(id).map(sellArticle -> {
            if (newSellArticle.getPostTitle() !=null){
                sellArticle.setPostTitle(newSellArticle.getPostTitle());
            }
            if (newSellArticle.getPostContent() !=null) {
                sellArticle.setPostContent(newSellArticle.getPostContent());
            }
            return repository.save(sellArticle);
        }).orElseThrow(()->new RuntimeException("게시글을 찾을 수 없음"));
    }
}
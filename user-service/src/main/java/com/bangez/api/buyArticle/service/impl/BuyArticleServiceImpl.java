package com.bangez.api.buyArticle.service.impl;

import com.bangez.api.buyArticle.domain.BuyArticle;
import com.bangez.api.buyArticle.domain.BuyArticleDTO;
import com.bangez.api.buyArticle.repository.BuyArticleRepository;
import com.bangez.api.buyArticle.service.BuyArticleService;
import com.bangez.api.common.MessengerVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BuyArticleServiceImpl implements BuyArticleService {

    private final BuyArticleRepository repository;


    @Override
    public MessengerVO save(BuyArticleDTO dto) {
        repository.save(dtoToEntity(dto));
        return MessengerVO.builder().message("성공").build();
    }

    @Override
    public MessengerVO deleteById(Long id) {
        repository.deleteById(id);
        return MessengerVO.builder().message("삭제 성공").build();
    }

    @Override
    public List<BuyArticleDTO> findAll() {
        return repository.findAll().stream().map(i->entityToDTO(i)).toList();
    }

    @Override
    public BuyArticle modify(Long id, BuyArticle newBuyArticle) {
        return repository.findById(id).map(buyArticle -> {
            if (newBuyArticle.getPostTitle() !=null){
                buyArticle.setPostTitle(newBuyArticle.getPostTitle());
            }
            if (newBuyArticle.getPostContent() !=null) {
                buyArticle.setPostContent(newBuyArticle.getPostContent());
            }
            return repository.save(buyArticle);
        }).orElseThrow(()->new RuntimeException("게시글을 찾을 수 없음"));
    }
}
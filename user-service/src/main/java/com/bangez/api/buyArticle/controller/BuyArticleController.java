package com.bangez.api.buyArticle.controller;

import com.bangez.api.buyArticle.domain.BuyArticle;
import com.bangez.api.buyArticle.domain.BuyArticleDTO;
import com.bangez.api.buyArticle.service.BuyArticleService;
import com.bangez.api.common.MessengerVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/buy-article")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class BuyArticleController {

    private final BuyArticleService service;

    @PostMapping("/save")
    public ResponseEntity<MessengerVO> save(@RequestBody BuyArticleDTO dto) {
        log.info("입력받은 정보 : {}", dto);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<MessengerVO> deleteById(@RequestParam Long id)  {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<BuyArticleDTO>> findAll( ) {
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<BuyArticle> modify(@PathVariable Long id, @RequestBody BuyArticle newBuyArticle){
        log.info("입력받은 정보 : {}", newBuyArticle);
        return ResponseEntity.ok(service.modify(id, newBuyArticle));
    }


}
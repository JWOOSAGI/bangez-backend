package com.bangez.tx.service;

import com.bangez.tx.domain.dto.PointDto;
import com.bangez.tx.domain.model.PointModel;

import java.math.BigDecimal;

public interface PointService {
     void savePoint(BigDecimal amount, Long userId) ;
     int getPointDetail(Long id);
     PointDto deductionPoint(Long userId);

     default PointModel convertToModel(PointModel pointModel) {
         return PointModel.builder()
                 .pointId(pointModel.getPointId())
                 .point(pointModel.getPoint())
                 .userId(pointModel.getUserId())
                 .lastChargeDate(pointModel.getLastChargeDate())
                 .build();
     }
     default PointDto convertToDto(PointModel pointModel) {
         return PointDto.builder()
                 .pointId(pointModel.getPointId())
                 .point(pointModel.getPoint())
                 .lastChargeDate(pointModel.getLastChargeDate())
                 .userId(pointModel.getUserId())
                 .build();
     }
    
}

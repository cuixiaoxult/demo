package com.example.demo.service.impl;

import com.example.demo.BaseTest;
import com.example.demo.service.StoreGoodsRecordService;
import com.example.demo.vo.StoreGoodsRecordVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StoreGoodsRecordServiceImplTest extends BaseTest {

    @Autowired
    private StoreGoodsRecordService storeGoodsRecordService;

    @Test
    void updateByWrapper() {
        StoreGoodsRecordVo storeGoodsRecordVo = new StoreGoodsRecordVo();
        storeGoodsRecordVo.setGoodsNo("3223003");
        storeGoodsRecordVo.setStoreNo("W072");
        storeGoodsRecordVo.setBasePrice(new BigDecimal(100));
        boolean result = storeGoodsRecordService.updateByWrapper(storeGoodsRecordVo);
        assertTrue(result);
    }
}
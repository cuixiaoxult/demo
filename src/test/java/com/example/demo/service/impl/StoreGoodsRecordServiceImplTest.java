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
        storeGoodsRecordVo.setBasePrice(new BigDecimal(102));
        boolean result = storeGoodsRecordService.updateByWrapper(storeGoodsRecordVo);
        assertTrue(result);
    }

    @Test
    void saveStoreGoodsRecord() {
        StoreGoodsRecordVo storeGoodsRecordVo = new StoreGoodsRecordVo();
        storeGoodsRecordVo.setId(23893491L);
        storeGoodsRecordVo.setGoodsNo("3223004");
        storeGoodsRecordVo.setGoodsId(3223004L);
        storeGoodsRecordVo.setStoreNo("W080");
        storeGoodsRecordVo.setRegionCode("12309");
        storeGoodsRecordVo.setBasePrice(new BigDecimal(1));
        storeGoodsRecordVo.setSalePrice(new BigDecimal(1));
        storeGoodsRecordVo.setRealSalePrice(new BigDecimal(1));
        storeGoodsRecordVo.setSaleTaxRate("1");
        int result = storeGoodsRecordService.saveStoreGoodsRecord(storeGoodsRecordVo);
        assertEquals(1,result);
    }
}
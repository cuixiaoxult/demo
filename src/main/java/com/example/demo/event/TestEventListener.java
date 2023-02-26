package com.example.demo.event;

import com.example.demo.vo.StoreGoodsRecordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * @author mxy
 * @date 23.2.21
 */

@Slf4j
@Component
public class TestEventListener {


    @EventListener(condition = "#storeGoodsRecordVo.storeNo.equals('test_event_1')")
    public void handleEvent1(StoreGoodsRecordVo storeGoodsRecordVo) {
        try {
            Thread.sleep(1000);
            log.info("AhandleEvent1 storeNo:{},goodsNo:{}", storeGoodsRecordVo.getStoreNo(), storeGoodsRecordVo.getGoodsNo());
        } catch (Exception e) {
            log.error("b2cStatus event error", e);
        }

    }


    @EventListener(condition = "#storeGoodsRecordVo.storeNo.equals('test_event_2')")
    public void handleEvent2(StoreGoodsRecordVo storeGoodsRecordVo) {
        try {
            Thread.sleep(10000);
            log.info("BhandleEvent2 storeNo:{}", storeGoodsRecordVo.getStoreNo());
        } catch (Exception e) {
            log.error("b2cStatus event error", e);
        }

    }

}

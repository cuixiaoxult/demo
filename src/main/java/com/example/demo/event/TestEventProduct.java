package com.example.demo.event;

import com.example.demo.vo.StoreGoodsRecordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestEventProduct {
    @Autowired
    private ApplicationEventPublisher publisher;

    private Integer number = 0;

    //@Scheduled(cron = "0/5 * * * * ?")
    public void send() throws InterruptedException {
        for (long i = 1; i < 11; i++) {
            String goodNo = "A" + number + "_" + i;
            StoreGoodsRecordVo storeGoodsRecordVo = new StoreGoodsRecordVo();
            storeGoodsRecordVo.setStoreNo("test_event_1");
            storeGoodsRecordVo.setGoodsNo(goodNo);
            log.info("ATestEventProduct start send storeNo:{},goodNo:{}", storeGoodsRecordVo.getStoreNo(), storeGoodsRecordVo.getGoodsNo());
            publisher.publishEvent(storeGoodsRecordVo);
            log.info("ATestEventProduct end send storeNo:{},goodNo:{}", storeGoodsRecordVo.getStoreNo(), storeGoodsRecordVo.getGoodsNo());
        }
        Thread.sleep(100000);
        number++;
    }

    //@Scheduled(cron = "0/5 * * * * ?")
    public void send2() throws InterruptedException {
        for (long i = 1; i < 11; i++) {
            String goodNo = "B" + number + "_" + i;
            StoreGoodsRecordVo storeGoodsRecordVo = new StoreGoodsRecordVo();
            storeGoodsRecordVo.setStoreNo("test_event_1");
            storeGoodsRecordVo.setGoodsNo(goodNo);
            log.info("BTestEventProduct start send storeNo:{},goodNo:{}", storeGoodsRecordVo.getStoreNo(), storeGoodsRecordVo.getGoodsNo());
            publisher.publishEvent(storeGoodsRecordVo);
            log.info("BTestEventProduct end send storeNo:{},goodNo:{}", storeGoodsRecordVo.getStoreNo(), storeGoodsRecordVo.getGoodsNo());
        }
        Thread.sleep(100000);
        number++;
    }
}

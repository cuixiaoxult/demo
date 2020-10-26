package com.example.demo.service.impl;

import com.example.demo.BaseTest;
import com.example.demo.dao.StoreGoodsRecordDao;
import com.example.demo.domain.StoreGoodsRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@Slf4j
class OptimisticLockerTest extends BaseTest {

    @Resource
    private StoreGoodsRecordDao storeGoodsRecordDao;

    /**
     * 乐观锁测试
     */
    @Test
    void OptimisticLocker() {
        log.info("[乐观锁测试]start...");
        long id = 23893391L;
        StoreGoodsRecord storeGoodsRecord = storeGoodsRecordDao.selectById(id);
        log.info("[乐观锁测试] 模拟线程一 version:{}", storeGoodsRecord.getVersion());
        storeGoodsRecord.setGoodsNo("111abc");
        StoreGoodsRecord storeGoodsRecord2 = storeGoodsRecordDao.selectById(id);
        log.info("[乐观锁测试] 模拟线程二 version2:{}", storeGoodsRecord.getVersion());
        storeGoodsRecord.setGoodsNo("222abc");
        int result = storeGoodsRecordDao.updateById(storeGoodsRecord);
        log.info("[乐观锁测试] 模拟线程一 result:{}", result);
        int result2 = storeGoodsRecordDao.updateById(storeGoodsRecord2);
        log.info("[乐观锁测试] 模拟线程二 result2:{}", result2);
        if (result2 == 0) {
            StoreGoodsRecord storeGoodsRecord3 = storeGoodsRecordDao.selectById(id);
            log.info("[乐观锁测试] 模拟线程三 version3:{}", storeGoodsRecord3.getVersion());
            storeGoodsRecord.setGoodsNo("333abc");
            int result3 = storeGoodsRecordDao.updateById(storeGoodsRecord);
            log.info("[乐观锁测试] 模拟线程三 result3:{}", result3);
        }
        log.info("[乐观锁测试] 测试结束...");
    }

    @Test
    void getByStoreNoAndGoodsNo(){
        StoreGoodsRecord record = storeGoodsRecordDao.getByStoreNoAndGoodsNo("W072", "333ab");
        log.info("record:{}",record);
        assertNotNull(record);
    }

    @Test
    void getByFlag(){
        List<StoreGoodsRecord> storeGoodsRecords = storeGoodsRecordDao.getByFlag(16);
        log.info("查询个数size:{}",storeGoodsRecords.size());
        Assert.assertEquals(1, storeGoodsRecords.size());
    }

    @Test
    void addFlag(){
        int result = storeGoodsRecordDao.addFlag(16, "333ab","W072");
        Assert.assertEquals(1, result);
    }
}
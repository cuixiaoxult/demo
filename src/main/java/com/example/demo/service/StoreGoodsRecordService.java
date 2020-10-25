package com.example.demo.service;

import com.example.demo.domain.StoreGoodsRecord;
import com.example.demo.dto.StoreGoodsRecordDto;
import com.example.demo.util.MyPage;
import com.example.demo.vo.StoreGoodsRecordQueryVo;
import com.example.demo.vo.StoreGoodsRecordVo;

import java.util.List;

/**
 * <p>
 * 门店商品信息 服务类
 * </p>
 *
 * @author cuixiaoxu
 * @since 2020-10-21
 */

public interface StoreGoodsRecordService {

    /**
     * 分页查询
     */
    MyPage<StoreGoodsRecordVo> listPage(StoreGoodsRecordQueryVo query);

    List<StoreGoodsRecordVo> list(StoreGoodsRecordQueryVo query);

    int saveStoreGoodsRecord(StoreGoodsRecordVo storeGoodsRecordVo);

    int updateStoreGoodsRecord(StoreGoodsRecordVo storeGoodsRecordVo);

    boolean updateByWrapper(StoreGoodsRecordVo storeGoodsRecordVo);


    StoreGoodsRecordVo findById(Long Id);

    boolean delete(Long id);
}


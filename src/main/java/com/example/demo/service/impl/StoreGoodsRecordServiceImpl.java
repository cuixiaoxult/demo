package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.enums.ErrorEnum;
import com.example.demo.dao.StoreGoodsRecordDao;
import com.example.demo.domain.StoreGoodsRecord;
import com.example.demo.dto.StoreGoodsRecordDto;
import com.example.demo.model.StoreGoodsRecordM;
import com.example.demo.service.StoreGoodsRecordService;
import com.example.demo.util.FaultException;
import com.example.demo.util.MyPage;
import com.example.demo.vo.StoreGoodsRecordQueryVo;
import com.example.demo.vo.StoreGoodsRecordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 门店商品信息 服务实现类
 * </p>
 *
 * @author cuixiaoxu
 * @since 2020-10-21
 */
@Slf4j
@Service
public class StoreGoodsRecordServiceImpl extends ServiceImpl<StoreGoodsRecordDao, StoreGoodsRecord> implements StoreGoodsRecordService {

    @Resource
    private StoreGoodsRecordDao storeGoodsRecordDao;


    @Override
    public MyPage<StoreGoodsRecordVo> listPage(StoreGoodsRecordQueryVo query) {
        log.info("[根据条件查询] query:{}", query);
        if (StringUtils.isEmpty(query.getStoreNo())) {
            throw new FaultException(ErrorEnum.BASE.getCode(), ErrorEnum.BASE.getMsg());
        }
        QueryWrapper<StoreGoodsRecord> queryWrapper = new QueryWrapper<>();
        if (StringUtils.hasText(query.getStoreNo())) {
            queryWrapper.eq(StoreGoodsRecordM.STORE_NO, query.getStoreNo());
        }
        if (!CollectionUtils.isEmpty(query.getGoodsNo())) {
            queryWrapper.in(StoreGoodsRecordM.GOODS_NO, query.getGoodsNo());
        }
        if (query.getCreateTimeStart() != null) {
            queryWrapper.gt(StoreGoodsRecordM.CREATE_TIME, query.getCreateTimeStart());
        }
        if (query.getCreateTimeEnd() != null) {
            queryWrapper.lt(StoreGoodsRecordM.CREATE_TIME, query.getCreateTimeEnd());
        }
        queryWrapper.orderByDesc(StoreGoodsRecordM.ID);
        Page<StoreGoodsRecord> page = new Page<>(query.getPageNo(), query.getPageSize());
        IPage<StoreGoodsRecord> addressDictionaryPage = storeGoodsRecordDao.selectPage(page, queryWrapper);
        return getPageDto(addressDictionaryPage);
    }

    private MyPage<StoreGoodsRecordVo> getPageDto(IPage<StoreGoodsRecord> componentPage) {
        List<StoreGoodsRecordVo> storeGoodsRecordDtos = new LinkedList<>();
        for (StoreGoodsRecord storeGoodsRecord : componentPage.getRecords()) {
            StoreGoodsRecordVo storeGoodsRecordDto = new StoreGoodsRecordVo();
            BeanUtils.copyProperties(storeGoodsRecord, storeGoodsRecordDto);
            storeGoodsRecordDtos.add(storeGoodsRecordDto);
        }
        MyPage<StoreGoodsRecordVo> myPage = new MyPage();
        myPage.setContent(storeGoodsRecordDtos);
        myPage.setTotalElements(componentPage.getTotal());
        return myPage;
    }

    @Override
    public List<StoreGoodsRecordVo> list(StoreGoodsRecordQueryVo query) {
        log.info("[按条件查询指定字段] storeGoodsRecordVo：{}", query);
        List<StoreGoodsRecordVo> storeGoodsRecordVos = new LinkedList<>();
        List<StoreGoodsRecord> records = this.list(new QueryWrapper<StoreGoodsRecord>()
                .eq(StoreGoodsRecordM.STORE_NO, query.getStoreNo())
                .in(StoreGoodsRecordM.GOODS_NO, query.getGoodsNo()));
        log.info("[按条件查询指定字段] 查询条数size：{}", records.size());
        for (StoreGoodsRecord record : records) {
            StoreGoodsRecordVo storeGoodsRecordVo = new StoreGoodsRecordVo();
            BeanUtils.copyProperties(record, storeGoodsRecordVo);
            storeGoodsRecordVos.add(storeGoodsRecordVo);
        }
        return storeGoodsRecordVos;
    }

    @Override
    public int saveStoreGoodsRecord(StoreGoodsRecordVo storeGoodsRecordVo) {
        StoreGoodsRecord storeGoodsRecord = new StoreGoodsRecord();
        BeanUtils.copyProperties(storeGoodsRecordVo, storeGoodsRecord);
        storeGoodsRecord.setCreateTime(LocalDateTime.now());
        return storeGoodsRecordDao.insert(storeGoodsRecord);
    }

    @Override
    public int updateStoreGoodsRecord(StoreGoodsRecordVo storeGoodsRecordVo) {
        StoreGoodsRecord storeGoodsRecord = storeGoodsRecordDao.selectById(storeGoodsRecordVo.getId());
        BeanUtils.copyProperties(storeGoodsRecordVo, storeGoodsRecord);
        storeGoodsRecord.setUpdateTime(LocalDateTime.now());
        return storeGoodsRecordDao.updateById(storeGoodsRecord);
    }

    @Override
    public boolean updateByWrapper(StoreGoodsRecordVo storeGoodsRecordVo) {
        log.info("[按条件更新指定字段] storeGoodsRecordVo：{}", storeGoodsRecordVo);
        UpdateWrapper<StoreGoodsRecord> updateWrapper = new UpdateWrapper<StoreGoodsRecord>()
                .eq(StoreGoodsRecordM.GOODS_NO, storeGoodsRecordVo.getGoodsNo())
                .eq(StoreGoodsRecordM.STORE_NO, storeGoodsRecordVo.getStoreNo());
        StoreGoodsRecord storeGoodsRecord = new StoreGoodsRecord();
        storeGoodsRecord.setBasePrice(storeGoodsRecordVo.getBasePrice());
        storeGoodsRecord.setUpdateTime(LocalDateTime.now());
        return this.update(storeGoodsRecord, updateWrapper);
    }

    @Override
    public StoreGoodsRecordVo findById(Long Id) {
        StoreGoodsRecordVo vo = new StoreGoodsRecordVo();
        StoreGoodsRecord storeGoodsRecord = this.getById(Id);
        if (null == storeGoodsRecord) {
            return vo;
        }
        BeanUtils.copyProperties(storeGoodsRecord, vo);
        return vo;
    }

    @Override
    public boolean delete(Long id) {
        int result = storeGoodsRecordDao.deleteById(id);
        return result == 1 ? true : false;
    }
}


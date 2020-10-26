
package com.example.demo.controller;


import com.example.demo.service.StoreGoodsRecordService;
import com.example.demo.util.MyPage;
import com.example.demo.vo.StoreGoodsRecordQueryVo;
import com.example.demo.vo.StoreGoodsRecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 门店商品信息 前端控制器
 * </p>
 *
 * @author cuixiaoxu
 * @version v1.0
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/bb/store-goods-record")
public class StoreGoodsRecordController {

    @Autowired
    private StoreGoodsRecordService storeGoodsRecordService;

    /**
     * 查询分页数据
     */
    @PostMapping("/page")
    public MyPage<StoreGoodsRecordVo> listPage(@Valid @RequestBody StoreGoodsRecordQueryVo query) {
        return storeGoodsRecordService.listPage(query);
    }

    @PostMapping("/list")
    public List<StoreGoodsRecordVo> list(@Valid @RequestBody StoreGoodsRecordQueryVo query) {
        return storeGoodsRecordService.list(query);
    }

    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    public StoreGoodsRecordVo getById(@PathVariable("id") Long id) {
        return storeGoodsRecordService.findById(id);
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Long id) {
        return storeGoodsRecordService.delete(id);
    }


    /**
     * 新增
     */
    @PostMapping("/add")
    public int saveStoreGoodsRecord(@RequestBody @Valid StoreGoodsRecordVo storeGoodsRecordVo) {
        return storeGoodsRecordService.saveStoreGoodsRecord(storeGoodsRecordVo);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public int updateStoreGoodsRecord(@RequestBody @Valid StoreGoodsRecordVo storeGoodsRecordVo) {
        return storeGoodsRecordService.updateStoreGoodsRecord(storeGoodsRecordVo);
    }

}

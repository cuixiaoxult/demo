//package com.example.demo.dao;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.example.demo.domain.StoreGoodsRecord;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * @author cui
// */
//public interface StoreGoodsRecordDao extends BaseMapper<StoreGoodsRecord> {
//
//    /**
//     * 根据门店编号和商品编码查询
//     *
//     * @param storeNo
//     * @param goodsNo
//     * @return
//     */
//    @Select(value = "select * from store_goods_record where store_no = #{storeNo} and goods_no = #{goodsNo} for update")
//    StoreGoodsRecord getByStoreNoAndGoodsNo(@Param(value = "storeNo") String storeNo, @Param(value = "goodsNo") String goodsNo);
//
//    /**
//     * 根据flag查询
//     *
//     * @param bit
//     * @return
//     */
//    @Select(value = "select * from store_goods_record where flag = (IFNULL(flag,0)| #{bit}) for update")
//    List<StoreGoodsRecord> getByFlag(@Param(value = "bit") Integer bit);
//
//    /**
//     * 添加flag标签
//     *
//     * @param bit
//     * @param goodsNo
//     * @param storeNo
//     * @return
//     */
//    @Update({"update store_goods_record set `flag` = (IFNULL(flag,0)|#{bit}) where goods_no = #{goodsNo} and `store_no` = #{storeNo}"})
//    int addFlag(@Param("bit") Integer bit, @Param(value = "goodsNo") String goodsNo, @Param(value = "storeNo") String storeNo);
//}
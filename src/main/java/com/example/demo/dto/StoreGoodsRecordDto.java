package com.example.demo.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 门店商品信息
 * </p>
 *
 * @author cuixiaoxu
 * @since 2020-10-21
 */
public class StoreGoodsRecordDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 门店编号
     */


    private String storeNo;

    /**
     * 商品编号
     */


    private String goodsNo;


    private Long goodsId;


    private String regionCode;

    /**
     * 是否可订货  0:不可订货；1:可订货
     */


    private Boolean isOrderable;

    /**
     * 是否可退货  0:不可退货；1:可退货
     */


    private Boolean isReturnable;

    /**
     * 是否可销售  0:不可销售；1:可销售
     */


    private Boolean isSaleable;

    /**
     * 子商品是否线上可售 0：否 1：是
     */


    private Boolean isSubSaleOnline;

    /**
     * 是否可变价  0:不可变价；1:可变价
     */


    private Boolean isVariablePrice;

    /**
     * 是否采购推荐 0:否 1:是
     */


    private Boolean isPurchaseRecommend;

    /**
     * 是否新品 0:否 1:是
     */


    private Boolean isNew;

    /**
     * 销售渠道
     */


    private String saleChannel;

    /**
     * 配送基准价
     */


    private BigDecimal basePrice;


    private Long mainVendorId;

    /**
     * 默认会员价
     */


    private BigDecimal vipPrice;

    /**
     * 当前会员价
     */


    private BigDecimal realVipPrice;

    /**
     * 促销单号
     */


    private String promotionNo;

    /**
     * 二进制标识，0初始值，2正在促销，4binlog不同步，8必定，16日清
     */


    private Long flag;

    /**
     * 销项税率
     */


    private String saleTaxRate;

    /**
     * 结算方式
     */


    private String settlementMethodCode;

    /**
     * 结算方式值
     */


    private String settlementMethodName;

    /**
     * 二进制 0 初始 1 删除 2 可订货 4 可退货 8 是否可销售 16 是否可变价 64 是否季节性商品 128 是否线上销售 512 是否自营
     */


    private String state;


    private String mainVendorNo;

    /**
     * 当前售价(当前售价默认等于默认售价)
     */


    private BigDecimal realSalePrice;

    /**
     * 默认售价
     */


    private BigDecimal salePrice;

    /**
     * 该记录创建时间
     */


    private LocalDateTime createTime;

    /**
     * 该记录最后更新时间
     */


    private LocalDateTime updateTime;

    /**
     * 活动文本
     */


    private String disRuleDesc;

    /**
     * 促销开始时间
     */


    private LocalDateTime saleBeginDate;

    /**
     * 促销结束时间
     */


    private LocalDateTime saleEndDate;

    /**
     * VIP价格开始时间
     */


    private LocalDateTime vipBeginDate;

    /**
     * VIP价格结束时间
     */


    private LocalDateTime vipEndDate;

    /**
     * 价格变更日期
     */


    private LocalDateTime priceChangeDate;

    /**
     * 折扣单价
     */


    private BigDecimal disPrice;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {

        this.id = id;

    }

    public String getStoreNo() {
        return storeNo;
    }


    public void setStoreNo(String storeNo) {

        this.storeNo = storeNo;

    }

    public String getGoodsNo() {
        return goodsNo;
    }


    public void setGoodsNo(String goodsNo) {

        this.goodsNo = goodsNo;

    }

    public Long getGoodsId() {
        return goodsId;
    }


    public void setGoodsId(Long goodsId) {

        this.goodsId = goodsId;

    }

    public String getRegionCode() {
        return regionCode;
    }


    public void setRegionCode(String regionCode) {

        this.regionCode = regionCode;

    }

    public Boolean getOrderable() {
        return isOrderable;
    }


    public void setOrderable(Boolean isOrderable) {

        this.isOrderable = isOrderable;

    }

    public Boolean getReturnable() {
        return isReturnable;
    }


    public void setReturnable(Boolean isReturnable) {

        this.isReturnable = isReturnable;

    }

    public Boolean getSaleable() {
        return isSaleable;
    }


    public void setSaleable(Boolean isSaleable) {

        this.isSaleable = isSaleable;

    }

    public Boolean getSubSaleOnline() {
        return isSubSaleOnline;
    }


    public void setSubSaleOnline(Boolean isSubSaleOnline) {

        this.isSubSaleOnline = isSubSaleOnline;

    }

    public Boolean getVariablePrice() {
        return isVariablePrice;
    }


    public void setVariablePrice(Boolean isVariablePrice) {

        this.isVariablePrice = isVariablePrice;

    }

    public Boolean getPurchaseRecommend() {
        return isPurchaseRecommend;
    }


    public void setPurchaseRecommend(Boolean isPurchaseRecommend) {

        this.isPurchaseRecommend = isPurchaseRecommend;

    }

    public Boolean getNew() {
        return isNew;
    }


    public void setNew(Boolean isNew) {

        this.isNew = isNew;

    }

    public String getSaleChannel() {
        return saleChannel;
    }


    public void setSaleChannel(String saleChannel) {

        this.saleChannel = saleChannel;

    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }


    public void setBasePrice(BigDecimal basePrice) {

        this.basePrice = basePrice;

    }

    public Long getMainVendorId() {
        return mainVendorId;
    }


    public void setMainVendorId(Long mainVendorId) {

        this.mainVendorId = mainVendorId;

    }

    public BigDecimal getVipPrice() {
        return vipPrice;
    }


    public void setVipPrice(BigDecimal vipPrice) {

        this.vipPrice = vipPrice;

    }

    public BigDecimal getRealVipPrice() {
        return realVipPrice;
    }


    public void setRealVipPrice(BigDecimal realVipPrice) {

        this.realVipPrice = realVipPrice;

    }

    public String getPromotionNo() {
        return promotionNo;
    }


    public void setPromotionNo(String promotionNo) {

        this.promotionNo = promotionNo;

    }

    public Long getFlag() {
        return flag;
    }


    public void setFlag(Long flag) {

        this.flag = flag;

    }

    public String getSaleTaxRate() {
        return saleTaxRate;
    }


    public void setSaleTaxRate(String saleTaxRate) {

        this.saleTaxRate = saleTaxRate;

    }

    public String getSettlementMethodCode() {
        return settlementMethodCode;
    }


    public void setSettlementMethodCode(String settlementMethodCode) {

        this.settlementMethodCode = settlementMethodCode;

    }

    public String getSettlementMethodName() {
        return settlementMethodName;
    }


    public void setSettlementMethodName(String settlementMethodName) {

        this.settlementMethodName = settlementMethodName;

    }

    public String getState() {
        return state;
    }


    public void setState(String state) {

        this.state = state;

    }

    public String getMainVendorNo() {
        return mainVendorNo;
    }


    public void setMainVendorNo(String mainVendorNo) {

        this.mainVendorNo = mainVendorNo;

    }

    public BigDecimal getRealSalePrice() {
        return realSalePrice;
    }


    public void setRealSalePrice(BigDecimal realSalePrice) {

        this.realSalePrice = realSalePrice;

    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }


    public void setSalePrice(BigDecimal salePrice) {

        this.salePrice = salePrice;

    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }


    public void setCreateTime(LocalDateTime createTime) {

        this.createTime = createTime;

    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(LocalDateTime updateTime) {

        this.updateTime = updateTime;

    }

    public String getDisRuleDesc() {
        return disRuleDesc;
    }


    public void setDisRuleDesc(String disRuleDesc) {

        this.disRuleDesc = disRuleDesc;

    }

    public LocalDateTime getSaleBeginDate() {
        return saleBeginDate;
    }


    public void setSaleBeginDate(LocalDateTime saleBeginDate) {

        this.saleBeginDate = saleBeginDate;

    }

    public LocalDateTime getSaleEndDate() {
        return saleEndDate;
    }


    public void setSaleEndDate(LocalDateTime saleEndDate) {

        this.saleEndDate = saleEndDate;

    }

    public LocalDateTime getVipBeginDate() {
        return vipBeginDate;
    }


    public void setVipBeginDate(LocalDateTime vipBeginDate) {

        this.vipBeginDate = vipBeginDate;

    }

    public LocalDateTime getVipEndDate() {
        return vipEndDate;
    }


    public void setVipEndDate(LocalDateTime vipEndDate) {

        this.vipEndDate = vipEndDate;

    }

    public LocalDateTime getPriceChangeDate() {
        return priceChangeDate;
    }


    public void setPriceChangeDate(LocalDateTime priceChangeDate) {

        this.priceChangeDate = priceChangeDate;

    }

    public BigDecimal getDisPrice() {
        return disPrice;
    }


    public void setDisPrice(BigDecimal disPrice) {

        this.disPrice = disPrice;

    }

    @Override
    public String toString() {
        return "StoreGoodsRecord{" +
                "id=" + id +
                ", storeNo=" + storeNo +
                ", goodsNo=" + goodsNo +
                ", goodsId=" + goodsId +
                ", regionCode=" + regionCode +
                ", isOrderable=" + isOrderable +
                ", isReturnable=" + isReturnable +
                ", isSaleable=" + isSaleable +
                ", isSubSaleOnline=" + isSubSaleOnline +
                ", isVariablePrice=" + isVariablePrice +
                ", isPurchaseRecommend=" + isPurchaseRecommend +
                ", isNew=" + isNew +
                ", saleChannel=" + saleChannel +
                ", basePrice=" + basePrice +
                ", mainVendorId=" + mainVendorId +
                ", vipPrice=" + vipPrice +
                ", realVipPrice=" + realVipPrice +
                ", promotionNo=" + promotionNo +
                ", flag=" + flag +
                ", saleTaxRate=" + saleTaxRate +
                ", settlementMethodCode=" + settlementMethodCode +
                ", settlementMethodName=" + settlementMethodName +
                ", state=" + state +
                ", mainVendorNo=" + mainVendorNo +
                ", realSalePrice=" + realSalePrice +
                ", salePrice=" + salePrice +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", disRuleDesc=" + disRuleDesc +
                ", saleBeginDate=" + saleBeginDate +
                ", saleEndDate=" + saleEndDate +
                ", vipBeginDate=" + vipBeginDate +
                ", vipEndDate=" + vipEndDate +
                ", priceChangeDate=" + priceChangeDate +
                ", disPrice=" + disPrice +
                "}";
    }
}

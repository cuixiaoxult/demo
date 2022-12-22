package com.example.demo.domain;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.ToString;

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
@Data
@ToString
public class StoreGoodsRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableId(value = "id", type = IdType.AUTO)
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
    private Date createTime;
    /**
     * 该记录最后更新时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;
    /**
     * 活动文本
     */
    private String disRuleDesc;
    /**
     * 促销开始时间
     */
    private Date saleBeginDate;
    /**
     * 促销结束时间
     */
    private Date saleEndDate;
    /**
     * VIP价格开始时间
     */
    private Date vipBeginDate;
    /**
     * VIP价格结束时间
     */
    private Date vipEndDate;
    /**
     * 价格变更日期
     */
    private Date priceChangeDate;
    /**
     * 折扣单价
     */
    private BigDecimal disPrice;

    /**
     * 版本号
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

}

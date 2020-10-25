package com.example.demo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


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
public class StoreGoodsRecordQueryVo implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotNull
    @Range(min = 0, max = 99999, message = "页码pageNo不能为空")
    private Integer pageNo;

    @NotNull
    @Range(min = 5, max = 200, message = "页数pageSize在5~200范围取值")
    private Integer pageSize;

    /**
     * 门店编号
     */
    private String storeNo;

    /**
     * 商品编号
     */
    private List<String> goodsNo;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTimeStart;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTimeEnd;
}

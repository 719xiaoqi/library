package cn.zwz.ky.entity;

import cn.zwz.basics.baseClass.ZwzBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/**
 * 图书类型 实体类
 whp
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_book_type")
@TableName("a_book_type")
@ApiModel(value = "图书类型")
public class BookType extends ZwzBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书类型")
    private String title;

    @ApiModelProperty(value = "类型状态")
    private String status;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "备注")
    private String remark;
}

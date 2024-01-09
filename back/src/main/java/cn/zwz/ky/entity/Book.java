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

/**
 * 图书 实体类
 whp
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_book")
@TableName("a_book")
@ApiModel(value = "图书")
public class Book extends ZwzBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书名称")
    private String title;

    @ApiModelProperty(value = "出版社")
    private String press;

    @ApiModelProperty(value = "图书类型")
    private String type;

    @ApiModelProperty(value = "ISBN")
    private String isbn;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "备注")
    private String remark;
}

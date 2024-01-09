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
 * 图书馆 实体类
 whp
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_library")
@TableName("a_library")
@ApiModel(value = "图书馆")
public class Library extends ZwzBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书馆名称")
    private String title;

    @ApiModelProperty(value = "图书馆地址")
    private String address;

    @ApiModelProperty(value = "门头照片")
    private String image;

    @ApiModelProperty(value = "开业状态")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remark;
}

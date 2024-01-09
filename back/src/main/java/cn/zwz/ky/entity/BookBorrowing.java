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
 * 图书借阅 实体类
 whp
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_book_borrowing")
@TableName("a_book_borrowing")
@ApiModel(value = "图书借阅")
public class BookBorrowing extends ZwzBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书ID")
    private String bookId;

    @ApiModelProperty(value = "图书名称")
    private String bookName;

    @ApiModelProperty(value = "图书ISBN")
    private String bookIsbn;

    @ApiModelProperty(value = "借阅人ID")
    private String userId;

    @ApiModelProperty(value = "借阅人")
    private String userName;

    @ApiModelProperty(value = "借阅时间")
    private String time1;

    @ApiModelProperty(value = "借阅状态")
    private String status;

    @ApiModelProperty(value = "归还时间")
    private String time2;
}

package org.javatop.big.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Leo
 * @date  2023-11-25 13:00
 * @version 1.0
 * @description :
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    /**
    * ID
    */
    private Integer id;

    /**
    * 分类名称
    */
    private String categoryName;

    /**
    * 分类别名
    */
    private String categoryAlias;

    /**
    * 创建人ID
    */
    private Integer createUser;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
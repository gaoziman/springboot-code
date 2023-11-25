package org.javatop.big.pojo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : Leo
 * @date  2023-11-25 16:39
 * @version 1.0
 * @description : 分页返回结果对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean <T>{
    private Long total;//总条数
    private List<T> items;//当前页数据集合
}

package pers.design.cys.form;

import lombok.Data;

/**
 * 类目表单
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    //类目名
    private String categoryName;

    //类目类型
    private Integer categoryType;
}
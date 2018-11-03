package pers.design.cys.Exception;

import lombok.Getter;
import pers.design.cys.enums.ResultEnum;

/**
 * 自定义异常
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        //把message传到父类的构造方法里去
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
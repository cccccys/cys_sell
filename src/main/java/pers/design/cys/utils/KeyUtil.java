package pers.design.cys.utils;

import java.util.Random;

/**
 * 索引约束工具
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 规则：时间+随机数
     *
     * @return
     */
    public static synchronized String genUniqueKey() {

        Random random = new Random();
        //生成6位随机数
        Integer number = random.nextInt(900) + 100;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
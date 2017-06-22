package com.learning.demo.common.util;

import java.math.BigDecimal;

/**
 * Created by topaz on 2017/6/22.
 */
public class BigDecimalUtil {

    /**
     * null / 99999999.99 / #.##
     * 小数位不超过两位、最大数不超过99999999.99,或者为空
     * @return
     */
    public static boolean isLess8PointLess2Number(BigDecimal amount) {
        if (null != amount) {
            if (amount.compareTo(new BigDecimal("99999999.99")) > 0 ) {
                return false;
            }
            if (amount.scale() > 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否为0
     *
     * @param amount
     * @return
     */
    public static boolean isZero(BigDecimal amount) {
        if (null != amount) {
//            比较小数位，0.0 则为false
//            if (amount.equals(BigDecimal.ZERO)) {
//                return true;
//            }
            if (amount.compareTo(BigDecimal.ZERO) ==0 ) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否负数
     *
     * @param amount
     * @return
     */
    public static boolean isNegative(BigDecimal amount) {
        if (null != amount) {
            if (amount.signum()==-1 ) {
                return true;
            }
        }
        return false;
    }


}

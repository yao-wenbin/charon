package io.github.yaowenbin.charon.core;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
public class Times {

    /**
     *
     * @param timeStr
     */
    public static Long strToMills(String timeStr) {
        return Long.valueOf(timeStr.substring(0, timeStr.indexOf("s") + 1));
    }

}

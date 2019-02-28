package utils;

import java.util.List;
import java.util.Map;

/**
 * 封装一些常用的方法
 */
public class UltimateUtil {
    /**
     * 判断LIST是否为空
     *
     * @param object list入参
     * @return 结果
     */
    public static boolean isEmptyList(List<?> object) {
        return (object == null || object.isEmpty());
    }

    /**
     * 判断MPA是否为空
     * @param object map入参
     * @return 结果
     */
    public static boolean isEmptyMap(Map<?, ?> object) {
        return (object == null || object.isEmpty());
    }
}

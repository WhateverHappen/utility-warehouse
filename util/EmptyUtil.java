import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by thanatos on 2018/4/30.
 * <p>
 * 工具类，判断对象是否为空
 */

public class EmptyUtil {

    /**
     * 对于String类型的非空判断
     *
     * @param str 判断对象
     * @return boolean true-为空，false-不为空
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || "".equals(str.trim()) || "null".equalsIgnoreCase(str.trim())
                || "undefined".equalsIgnoreCase(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对于StringBuffer类型的非空判断
     *
     * @param str 判断对象
     * @return boolean true-为空，false-不为空
     */
    public static boolean isNullOrEmpty(StringBuffer str) {
        return (str == null || str.length() == 0);
    }

    /**
     * 对于string数组类型的非空判断
     *
     * @param str 判断对象
     * @return boolean true-为空，false-不为空
     */
    public static boolean isNullOrEmpty(String[] str) {
        if (str == null || str.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对于Long类型的非空判断
     *
     * @param longTime Long类型的时间
     * @return boolean true-为空或为0，false-不为空或大于0
     */
    public static boolean isNullOrEmpty(Long longTime) {
        if (longTime == null || longTime <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对于Object类型的非空判断
     *
     * @param obj 判断对象
     * @return boolean true-为空，false-不为空
     */
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null || "".equals(obj)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对于Object数组类型的非空判断
     *
     * @param obj 判断对象
     * @return boolean true-为空，false-不为空
     */
    public static boolean isNullOrEmpty(Object[] obj) {
        if (obj == null || obj.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对于Collection类型的非空判断
     *
     * @param collection 判断对象
     * @return boolean true-为空，false-不为空
     */
    public static boolean isNullOrEmpty(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对于Map类型的非空判断
     *
     * @param map 判断对象
     * @return boolean true-为空，false-不为空
     */
    public static boolean isNullOrEmpty(Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除集合中的空元素
     *
     * @param xllxList 要进行处理的集合
     * @param <T>
     * @return 删除掉空元素后的集合
     */
    public static <T> List<T> removeNullUnit(List<T> xllxList) {
        List<T> need = new ArrayList<T>();
        for (int i = 0; i < xllxList.size(); i++) {
            if (!isNullOrEmpty(xllxList.get(i))) {
                need.add(xllxList.get(i));
            }
        }
        return need;
    }
}

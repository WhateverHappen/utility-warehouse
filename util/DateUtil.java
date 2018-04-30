import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by thanatos on 2018/4/30.
 * <p>
 * 时间工具类
 */
public class DateUtil {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 判断时间是否在某时间范围内
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean isInDateScope(Date startTime, Date endTime, Date compareTime) {
        boolean isIn = true; // 是否在时间范围内,默认为true

		/* 判断开始时间是否大于要比较的时间 */
        if (startTime != null) {
            if (startTime.compareTo(compareTime) > 0) {
                isIn = false;
            }
        }

		/* 判断结束时间是否小于要比较的时间 */
        if (endTime != null) {
            if (endTime.compareTo(compareTime) < 0) {
                isIn = false;
            }
        }

        return isIn;
    }

    /**
     * 返回传入日期一年之后的日期
     *
     * @param startData 传入日期
     * @return Date 距传入日期一年一后的日期
     */
    public static Date dateAfterOneYear(Date startData) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startData);
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

    /**
     * 格式化日期
     * <p>
     * 日期格式yyyy-MM-dd
     *
     * @return
     */
    public static String formatDate(Date date) {
        return dateFormat.format(date);
    }

    /**
     * 得到格式化后的Date对象 日期格式yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static Date getDate(Date date) {
        try {
            return dateFormat.parse(formatDate(date));
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * 基于时间的累加
     *
     * @param date     在改Date 时间的基础上累加
     * @param addMinue 添加分钟数
     * @return Date 实例
     */
    public static Date getAddMinueFromData(Date date, int addMinue) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, addMinue);
        return cal.getTime();
    }

    /**
     * 基于时间的累加
     *
     * @param date 在改Date 时间的基础上累加
     * @param day  添加天数
     * @return Date 实例
     */
    public static Date getAddDayFromData(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }

    /**
     * 将字符串转换为Date类型
     *
     * @param strDate 时间表示的字符串；
     * @return Date 实例
     */
    public static Date stringTransformDate(String strDate) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // String str="2011-5-31 14:40:50";
        Date d = null;
        try {
            d = sim.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
}

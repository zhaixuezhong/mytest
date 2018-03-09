package common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期的相关工具类
 *
 * @author Administrator
 */
public class DateUtil {

  /* 将timestamp转换成date
   * @author hellostoy
   * @param tt
   * @return
   */
  public static Date timestampToDate(Timestamp tt) {
    return new Date(tt.getTime());
  }

  /**
   * date 转timestamp
   */
  public static Timestamp date2TimeStamp(Date date) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Timestamp ts = new Timestamp(((Date) sdf.parseObject(sdf.format(date))).getTime());
    return ts;
  }

  /**
   * date 转timestamp
   */
  public static Timestamp date2TimeStamp(String date) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Timestamp ts = new Timestamp(((Date) sdf.parseObject(date)).getTime());
    return ts;
  }

  /**
   * 得到两个时间之间的天数，字符串格式的
   */
  public static int getDaysBetween2Date(String date1, String date2) throws ParseException {
    int days = 0;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    long to = df.parse(date2).getTime();
    long from = df.parse(date1).getTime();
    days = (int) ((to - from) / (1000 * 60 * 60 * 24));
    return days;
  }

  /**
   * 得到两个时间之间的天数，日期格式的
   */
  public static int getDaysBetween2Date(Date date1, Date date2) throws ParseException {
    int days = 0;
    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    return days;
  }

  /**
   * 得到两个时间之间的分，日期格式的
   */
  public static int getMinutesBetween2Date(Date date1, Date date2) throws ParseException {
    int minutes = 0;
    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    minutes = (int) ((date2.getTime() - date1.getTime()) / (1000));
    return minutes;
  }

  /**
   * 得到两个时间之间的月数，日期格式的(暂时按一个月30天计算了)
   */
  public static Double getMonthsBetween2Date(Date date1, Date date2) throws ParseException {
    int beginYear = date1.getYear();
    int beginMonth = date1.getMonth();
    int beginDay = date1.getDay();

    int endYear = date2.getYear();
    int endMonth = date2.getMonth();
    int endDay = date2.getDay();

    //先减年*12，再减月 ，最后计算日期相差/30

    Double difMonth = Double.valueOf((endYear - beginYear) * 12 + (endMonth - beginMonth) + (endDay - beginDay) / 30);
    return difMonth;
  }

  /**
   * 格式化输出日期
   *
   * @param date   日期
   * @param format 格式
   * @return 返回字符型日期
   */
  public static String format(Date date, String format) {
    String result = "";
    try {
      if (date != null) {
        DateFormat df = new SimpleDateFormat(format);
        result = df.format(date);
      }
    } catch (Exception e) {
    }
    return result;
  }

  public static String format(Date date) {
    return format(date, "yyyy/MM/dd");
  }

  /**
   * 返回年份
   *
   * @param date 日期
   * @return 返回年份
   */
  public static int getYear(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.get(Calendar.YEAR);
  }

  /**
   * 返回月份
   *
   * @param date 日期
   * @return 返回月份
   */
  public static int getMonth(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.get(Calendar.MONTH) + 1;
  }

  /**
   * 返回日份
   *
   * @param date 日期
   * @return 返回日份
   */
  public static int getDay(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.get(Calendar.DAY_OF_MONTH);
  }

  /**
   * 返回小时
   *
   * @param date 日期
   * @return 返回小时
   */
  public static int getHour(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.get(Calendar.HOUR_OF_DAY);
  }

  /**
   * 返回分钟
   *
   * @param date 日期
   * @return 返回分钟
   */
  public static int getMinute(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.get(Calendar.MINUTE);
  }

  /**
   * 返回秒钟
   *
   * @param date 日期
   * @return 返回秒钟
   */
  public static int getSecond(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.get(Calendar.SECOND);
  }

  /**
   * 返回毫秒
   *
   * @param date 日期
   * @return 返回毫秒
   */
  public static long getMillis(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.getTimeInMillis();
  }

  /**
   * 返回字符型日期
   *
   * @param date 日期
   * @return 返回字符型日期
   */
  public static String getDate(Date date) {
    return format(date, "yyyy/MM/dd");
  }


  public static synchronized Calendar getLastDayOfMonth(
      Calendar gc) {
    /**
     * 详细设计：
     * 1.如果date在1月，则为31日
     * 2.如果date在2月，则为28日
     * 3.如果date在3月，则为31日
     * 4.如果date在4月，则为30日
     * 5.如果date在5月，则为31日
     * 6.如果date在6月，则为30日
     * 7.如果date在7月，则为31日
     * 8.如果date在8月，则为31日
     * 9.如果date在9月，则为30日
     * 10.如果date在10月，则为31日
     * 11.如果date在11月，则为30日
     * 12.如果date在12月，则为31日
     * 1.如果date在闰年的2月，则为29日
     */
    switch (gc.get(Calendar.MONTH)) {
      case 0:
        gc.set(Calendar.DAY_OF_MONTH, 31);
        break;
      case 1:
        gc.set(Calendar.DAY_OF_MONTH, 28);
        break;
      case 2:
        gc.set(Calendar.DAY_OF_MONTH, 31);
        break;
      case 3:
        gc.set(Calendar.DAY_OF_MONTH, 30);
        break;
      case 4:
        gc.set(Calendar.DAY_OF_MONTH, 31);
        break;
      case 5:
        gc.set(Calendar.DAY_OF_MONTH, 30);
        break;
      case 6:
        gc.set(Calendar.DAY_OF_MONTH, 31);
        break;
      case 7:
        gc.set(Calendar.DAY_OF_MONTH, 31);
        break;
      case 8:
        gc.set(Calendar.DAY_OF_MONTH, 30);
        break;
      case 9:
        gc.set(Calendar.DAY_OF_MONTH, 31);
        break;
      case 10:
        gc.set(Calendar.DAY_OF_MONTH, 30);
        break;
      case 11:
        gc.set(Calendar.DAY_OF_MONTH, 31);
        break;
    }
    //检查闰年
    if ((gc.get(Calendar.MONTH) == Calendar.FEBRUARY)
        && (isLeapYear(gc.get(Calendar.YEAR)))) {
      gc.set(Calendar.DAY_OF_MONTH, 29);
    }
    return gc;
  }

  /**
   * 取得指定日期的所处月份的第一天
   *
   * @param date 指定日期。
   * @return 指定日期的所处月份的第一天
   */
  public static synchronized Date getFirstDayOfMonth(Date date) {
    /**
     * 详细设计： 1.设置为1号
     */
    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    gc.set(Calendar.DAY_OF_MONTH, 1);
    return gc.getTime();
  }

  public static synchronized Calendar getFirstDayOfMonth(Calendar gc) {
    /**
     * 详细设计： 1.设置为1号
     */
    gc.set(Calendar.DAY_OF_MONTH, 1);
    return gc;
  }

  /**
   * 将日期对象转换成为指定ORA日期、时间格式的字符串形式。如果日期对象为空，返回 一个空字符串对象，而不是一个空对象。
   *
   * @param theDate 将要转换为字符串的日期对象。
   * @param hasTime 如果返回的字符串带时间则为true
   * @return 转换的结果
   */
  public static synchronized String toOraString(Date theDate, boolean hasTime) {
    /**
     * 详细设计：
     * 1.如果有时间，则设置格式为getOraDateTimeFormat()的返回值
     * 2.否则设置格式为getOraDateFormat()的返回值
     * 3.调用toString(Date theDate, DateFormat
     * theDateFormat)
     */
    DateFormat theFormat;
    if (hasTime) {
      theFormat = getOraDateTimeFormat();
    } else {
      theFormat = getOraDateFormat();
    }
    return toString(theDate, theFormat);
  }

  /**
   * 将日期对象转换成为指定日期、时间格式的字符串形式。如果日期对象为空，返回 一个空字符串对象，而不是一个空对象。
   *
   * @param theDate 将要转换为字符串的日期对象。
   * @param hasTime 如果返回的字符串带时间则为true
   * @return 转换的结果
   */
  public static synchronized String toString(Date theDate, boolean hasTime) {
    /**
     * 详细设计：
     * 1.如果有时间，则设置格式为getDateTimeFormat的返回值
     * 2.否则设置格式为getDateFormat的返回值
     * 3.调用toString(Date theDate, DateFormat theDateFormat)
     */
    DateFormat theFormat;
    if (hasTime) {
      theFormat = getDateTimeFormat();
    } else {
      theFormat = getDateFormat();
    }
    return toString(theDate, theFormat);
  }

  /**
   * 标准日期格式
   */
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
      "MM/dd/yyyy");
  /**
   * 标准时间格式
   */
  private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(
      "MM/dd/yyyy HH:mm");
  /**
   * 带时分秒的标准时间格式
   */
  private static final SimpleDateFormat DATE_TIME_EXTENDED_FORMAT = new SimpleDateFormat(
      "MM/dd/yyyy HH:mm:ss");
  /**
   * ORA标准日期格式
   */
  private static final SimpleDateFormat ORA_DATE_FORMAT = new SimpleDateFormat(
      "yyyyMMdd");
  /**
   * ORA标准时间格式
   */
  private static final SimpleDateFormat ORA_DATE_TIME_FORMAT = new SimpleDateFormat(
      "yyyyMMddHHmm");
  /**
   * 带时分秒的ORA标准时间格式
   */
  private static final SimpleDateFormat ORA_DATE_TIME_EXTENDED_FORMAT = new SimpleDateFormat(
      "yyyyMMddHHmmss");

  /**
   * 创建一个标准日期格式的克隆
   *
   * @return 标准日期格式的克隆
   */
  public static synchronized DateFormat getDateFormat() {
    /**
     * 详细设计： 1.返回DATE_FORMAT
     */
    SimpleDateFormat theDateFormat = (SimpleDateFormat)
        DATE_FORMAT.clone();
    theDateFormat.setLenient(false);
    return theDateFormat;
  }

  /**
   * 创建一个标准时间格式的克隆
   *
   * @return 标准时间格式的克隆
   */
  public static synchronized DateFormat getDateTimeFormat() {
    /**
     * 详细设计： 1.返回DATE_TIME_FORMAT
     */
    SimpleDateFormat theDateTimeFormat = (SimpleDateFormat) DATE_TIME_FORMAT
        .clone();
    theDateTimeFormat.setLenient(false);
    return theDateTimeFormat;
  }

  /**
   * 创建一个标准ORA日期格式的克隆
   *
   * @return 标准ORA日期格式的克隆
   */
  public static synchronized DateFormat getOraDateFormat() {
    /**
     * 详细设计： 1.返回ORA_DATE_FORMAT
     */
    SimpleDateFormat theDateFormat = (SimpleDateFormat) ORA_DATE_FORMAT
        .clone();
    theDateFormat.setLenient(false);
    return theDateFormat;
  }

  /**
   * 创建一个标准ORA时间格式的克隆
   *
   * @return 标准ORA时间格式的克隆
   */
  public static synchronized DateFormat getOraDateTimeFormat() {
    /**
     * 详细设计： 1.返回ORA_DATE_TIME_FORMAT
     */
    SimpleDateFormat theDateTimeFormat = (SimpleDateFormat)
        ORA_DATE_TIME_FORMAT.clone();
    theDateTimeFormat.setLenient(false);
    return theDateTimeFormat;
  }

  /**
   * 将一个日期对象转换成为指定日期、时间格式的字符串。 如果日期对象为空，返回一个空字符串，而不是一个空对象。
   *
   * @param theDate       要转换的日期对象
   * @param theDateFormat 返回的日期字符串的格式
   * @return 转换结果
   */
  public static synchronized String toString(Date theDate,
      DateFormat theDateFormat) {
    /**
     * 详细设计：
     * 1.theDate为空，则返回""
     * 2.否则使用theDateFormat格式化
     */
    if (theDate == null)
      return "";
    return theDateFormat.format(theDate);
  }

  /**
   * 计算当前年是否是闰年
   */
  public static synchronized boolean isLeapYear() {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    return isLeapYear(year);
  }

  /**
   * 计算指定年份是否是闰年
   */
  public static synchronized boolean isLeapYear(int year) {
    /**
     * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
     * 3.能被4整除同时能被100整除则不是闰年
     */
    if ((year % 400) == 0)
      return true;
    else if ((year % 4) == 0) {
      if ((year % 100) == 0)
        return false;
      else return true;
    } else return false;
  }

  /**
   * 判断指定日期的年份是否是闰年
   *
   * @param date 指定日期。
   * @return 是否闰年
   */
  public static synchronized boolean isLeapYear(Date date) {
    /**
     * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
     * 3.能被4整除同时能被100整除则不是闰年
     */
    // int year = date.getYear();
    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    int year = gc.get(Calendar.YEAR);
    return isLeapYear(year);
  }

  /**
   * 判断指定时间是否是闰年
   */
  public static synchronized boolean isLeapYear(Calendar gc) {
    /**
     * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
     * 3.能被4整除同时能被100整除则不是闰年
     */
    int year = gc.get(Calendar.YEAR);
    return isLeapYear(year);
  }

  /**
   * 取得指定日期的下一个月
   *
   * @param date 指定日期。
   * @return 指定日期的下一个月
   */
  public static synchronized Date getNextMonth(Date date) {
    /**
     * 详细设计：
     * 1.指定日期的月份加1
     */
    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    gc.add(Calendar.MONTH, 1);
    return gc.getTime();
  }

  public static synchronized Calendar getNextMonth(Calendar gc) {
    /**
     * 详细设计：
     * 1.指定日期的月份加1
     */
    gc.add(Calendar.MONTH, 1);
    return gc;
  }

  /**
   * 取得指定日期的下一天
   *
   * @param date 指定日期。
   * @return 指定日期的下一天
   */
  public static synchronized Date getNextDay(Date date) {
    /**
     * 详细设计： 1.指定日期加1天
     */
    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    gc.add(Calendar.DATE, 1);
    return gc.getTime();
  }

  public static synchronized Calendar getNextDay(Calendar gc) {
    /**
     * 详细设计： 1.指定日期加1天
     */
    gc.add(Calendar.DATE, 1);
    return gc;
  }

  /**
   * 取得指定日期的下一个星期
   *
   * @param date 指定日期。
   * @return 指定日期的下一个星期
   */
  public static synchronized Date getNextWeek(Date date) {
    /**
     * 详细设计：
     * 1.指定日期加7天
     */
    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    gc.add(Calendar.DATE, 7);
    return gc.getTime();
  }

  public static synchronized Calendar getNextWeek(Calendar gc) {
    /**
     * 详细设计：
     * 1.指定日期加7天
     */
    gc.add(Calendar.DATE, 7);
    return gc;
  }

  /**
   * 比较两个时间大小，带时分秒的，date2大于date1返回true
   */
  public static synchronized boolean compare2Date(String date1, String date2) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date d1 = sdf.parse(date1);
    Date d2 = sdf.parse(date2);

    if (d2.getTime() - d1.getTime() > 0) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * 比较两个时间大小，带时分秒的，date2大于date1返回true
   */
  public static synchronized boolean compare2Date(Date date1, Date date2) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date d1 = sdf.parse(sdf.format(date1));
    Date d2 = sdf.parse(sdf.format(date2));

    if (d2.getTime() - d1.getTime() > 0) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * 比较两个时间大小，不带时分秒的，date2大于date1返回true
   */
  public static synchronized boolean compare2DateNoHMS(String date1, String date2) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d1 = sdf.parse(date1);
    Date d2 = sdf.parse(date2);

    if (d2.getTime() - d1.getTime() > 0) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * 比较两个时间大小，不带时分秒的，date2大于date1返回true
   */
  public static synchronized boolean compare2DateNoHMS(Date date1, Date date2) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d1 = sdf.parse(sdf.format(date1));
    Date d2 = sdf.parse(sdf.format(date2));

    if (d2.getTime() - d1.getTime() > 0) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * 取得指定日期的加n天(n可为负数)
   *
   * @param date 指定日期。
   * @return 指定日期的加n天
   */
  public static synchronized Date getOtherDay(Date date, int n) {
    /**
     * 详细设计： 1.指定日期加n天
     */
    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
    gc.setTime(date);
    gc.add(Calendar.DATE, n);
    return gc.getTime();
  }
}

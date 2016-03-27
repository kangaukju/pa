package kr.co.projectd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Times {
	static private SimpleDateFormat yyyy_format = new SimpleDateFormat("yyyy");
	static private SimpleDateFormat yyyy_mm_format = new SimpleDateFormat("yyyy-MM");
	static private SimpleDateFormat yyyy_mm_dd_format = new SimpleDateFormat("yyyy-MM-dd");
	static private SimpleDateFormat yyyy_mm_dd_hh_format = new SimpleDateFormat("yyyy-MM-dd HH");
	static private SimpleDateFormat yyyy_mm_dd_hh_mm_format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	static private SimpleDateFormat yyyy_mm_dd_hh_mm_ss_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static private TimeZone seoul = TimeZone.getTimeZone("Asia/Seoul");
	static private Calendar c = Calendar.getInstance(seoul);
	
	public static Calendar getCalendar(Date date) {
		c.setTime(date);
		return c;
	}
	/**
	 * 날짜 변환 yyyy-mm-dd hh:mm:ss
	 * @param yyyy_mm_dd_hh_mm_ss String
	 * @return Date
	 */
	public static Date getDateYYYYMMDDHHMMSS(String yyyy_mm_dd_hh_mm_ss) {
		try {
			return yyyy_mm_dd_hh_mm_ss_format.parse(yyyy_mm_dd_hh_mm_ss);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 날짜 변환 yyyy-mm-dd hh:mm
	 * @param yyyy_mm_dd_hh_mm String
	 * @return Date
	 */
	public static Date getDateYYYYMMDDHHMM(String yyyy_mm_dd_hh_mm) {
		try {
			return yyyy_mm_dd_hh_mm_format.parse(yyyy_mm_dd_hh_mm);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 날짜 변환 yyyy-mm-dd hh
	 * @param yyyy_mm_dd_hh String
	 * @return Date
	 */
	public static Date getDateYYYYMMDDHH(String yyyy_mm_dd_hh) {
		try {
			return yyyy_mm_dd_hh_format.parse(yyyy_mm_dd_hh);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 날짜 변환 yyyy-mm-dd
	 * @param yyyy_mm_dd String
	 * @return Date
	 */
	public static Date getDateYYYYMMDD(String yyyy_mm_dd) {
		try {
			return yyyy_mm_dd_format.parse(yyyy_mm_dd);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 날짜 변환 yyyy-mm
	 * @param yyyy_mm String
	 * @return Date
	 */
	public static Date getDateYYYYMM(String yyyy_mm) {
		try {
			return yyyy_mm_format.parse(yyyy_mm);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 날짜 변환 yyyy
	 * @param yyyy String
	 * @return Date
	 */
	public static Date getDateYYYY(String yyyy) {
		try {
			return yyyy_format.parse(yyyy);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * date의 year
	 * @param date
	 * @return year
	 */
	public static int getYear(Date date) {
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	/**
	 * date의 month
	 * @param date
	 * @return month
	 */
	public static int getMonth(Date date) {
		c.setTime(date);
		return c.get(Calendar.MONTH);
	}
	/**
	 * date의 day
	 * @param date
	 * @return day
	 */
	public static int getDay(Date date) {
		c.setTime(date);
		return c.get(Calendar.DATE);
	}
	/**
	 * date의 hour
	 * @param date
	 * @return hour
	 */
	public static int getHour(Date date) {
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * date의 minute
	 * @param date
	 * @return minute
	 */
	public static int getMinute(Date date) {
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}
	/**
	 * date의 second
	 * @param date
	 * @return second
	 */
	public static int getSecond(Date date) {
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}
	/**
	 * 현재 date
	 * @return date
	 */
	public static Date now() {
		c.setTime(new Date());
		return c.getTime();
	}
	/**
	 * 현재 year
	 * @return year
	 */
	public static int nowYear() {
		c.setTime(new Date());
		return c.get(Calendar.YEAR);
	}
	/**
	 * 현재 month
	 * @return month
	 */
	public static int nowMonth() {
		c.setTime(new Date());
		return c.get(Calendar.MONTH);
	}
	/**
	 * 현재 day
	 * @return day
	 */
	public static int nowDay() {
		c.setTime(new Date());
		return c.get(Calendar.DATE);
	}
	/**
	 * 현재 hour
	 * @return hour
	 */
	public static int nowHour() {
		c.setTime(new Date());
		return c.get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * 현재 minute
	 * @return minute
	 */
	public static int nowMinute() {
		c.setTime(new Date());
		return c.get(Calendar.MINUTE);
	}
	/**
	 * 현재 second
	 * @return second
	 */
	public static int nowSecond() {
		c.setTime(new Date());
		return c.get(Calendar.SECOND);
	}
	/**
	 * date에 hour를 더한 날짜
	 * @param date
	 * @param hour
	 * @return date
	 */
	public static Date addHour(Date date, int hour) {
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, hour);
		return c.getTime();
	}
	/**
	 * date에 month를 더한 날짜
	 * @param date
	 * @param month
	 * @return date
	 */
	public static Date addMonth(Date date, int month) {
		c.setTime(date);
		c.add(Calendar.MONTH, month);
		return c.getTime();
	}
}

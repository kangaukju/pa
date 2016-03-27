package kr.co.projectd.matching.types;

import java.util.Calendar;
import java.util.Date;

import kr.co.projectd.utils.Times;

public class WorkMday {

	static public enum Mday {
		SUN(1<<0),
		MON(1<<1),
		TUE(1<<2),
		WEB(1<<3),
		THU(1<<4),
		FRI(1<<5),
		SAT(1<<6);
		private int value;
		private Mday(int value) {
			this.value = value;
		}
		/**
		 * 현재날짜의 Mday(요일) 가져오기
		 * @param date
		 * @return Mday
		 */
		static public Mday getMday(Date date) {
			Calendar c = Times.getCalendar(date);
			Mday mday = Mday.SUN;
			
			switch (c.get(Calendar.DAY_OF_WEEK)) {
				case Calendar.SUNDAY: mday = Mday.SUN; 
				case Calendar.MONDAY: mday = Mday.MON;
				case Calendar.TUESDAY: mday = Mday.TUE;
				case Calendar.WEDNESDAY: mday = Mday.WEB;
				case Calendar.THURSDAY: mday = Mday.THU;
				case Calendar.FRIDAY: mday = Mday.FRI;
				case Calendar.SATURDAY: mday = Mday.SAT;
			}
			return mday;
		}
		static public Mday getMday() {
			return getMday(new Date());
		}
		static public Mday getMdayYYYYMMDD(String yyyy_mm_dd) {
			Date date = Times.getDateYYYYMMDD(yyyy_mm_dd);
			return getMday(date);
		}
	}
	/**
	 * WorkMday value
	 */
	private int value;
	
	public WorkMday(int value) {
		this.value = value;
	}
	public WorkMday() {
		this(0);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Mday mday : Mday.values()) {
			if ((mday.value & value) == mday.value) {
				sb.append(" "+mday.name());
			}
		}
		return sb.toString();
	}
}

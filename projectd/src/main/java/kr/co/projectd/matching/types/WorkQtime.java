package kr.co.projectd.matching.types;

import java.util.Date;

import kr.co.projectd.utils.Times;

public class WorkQtime {
	static public enum Qtime {
		/**
		 * Q1("새벽(00:00 ~ 06:00)", 1<<0); // 0  ~ 6
		 * Q2("오전(06:00 ~ 12:00)", 1<<1), // 6  ~ 12
		 * Q3("오후(12:00 ~ 18:00)", 1<<2), // 12 ~ 18
		 * Q4("야간(18:00 ~ 24:00)", 1<<3), // 18 ~ 24
		 */
		Q1(1<<0),
		Q2(1<<1),
		Q3(1<<2),
		Q4(1<<3);
		private int value;
		private Qtime(int value) {
			this.value = value;
		}
	}
	/**
	 * WorkQtime value
	 */
	private int value;
	
	public WorkQtime(int value) {
		this.value = value;
	}
	public WorkQtime() {
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
		for (Qtime qtime : Qtime.values()) {
			if ((qtime.value & value) == qtime.value) {
				sb.append(" "+qtime.name());
			}
		}
		return sb.toString();
	}
	/**
	 * 출근시간 부터 근무시간을 계산하여 WorkQtime 객체 값을 생성한다.
	 * 예시1>
	 * 출근시간: 08:00
	 * 근무시간: 8
	 * 근무시간: 08:00 ~ 16:00(오후 04:00)
	 * QtimeBit 집합: Q2(오전), Q3(오후)
	 * 
	 * 예시2>
	 * 출근시간: 08:00
	 * 근무시간: 10
	 * 근무시간: 08:00 ~ 18:00(오후 06:00)
	 * QtimeBit 집합: Q2(오전), Q3(오후), Q4(야간)
	 *  
	 * @param date
	 * @param workTime
	 * @return
	 */
	public static WorkQtime valueOf(Date date, int time) {
		int startQtimeIndex = Times.getHour(date) / 6;
		int endQtimeIndex = Times.getHour(Times.addHour(date, time)) / 6;
		Qtime [] qtimes = Qtime.values();
		int qvalue = 0;
		
		if (startQtimeIndex > endQtimeIndex) {
			for (int i=startQtimeIndex; i<qtimes.length; i++) {
				qvalue |= qtimes[i].value;
			}
			for (int i=0; i<=startQtimeIndex; i++) {
				qvalue |= qtimes[i].value;
			}
		} else {
			for (int i=startQtimeIndex; i<=endQtimeIndex; i++) {
				qvalue |= qtimes[i].value;
			}
		}
		return new WorkQtime(qvalue);
	}
	public static void main(String [] args) {
		WorkQtime workQtime = new WorkQtime();
		
		System.out.println("[1]");
		workQtime.setValue(
				Qtime.Q1.value|
				Qtime.Q3.value|
				Qtime.Q4.value);
		System.out.println(workQtime);
		
		System.out.println("[2]");
		Date workTime = Times.getDateYYYYMMDDHHMM("2016-04-21 08:00");
		int howlong = 10;
		// times : 9 10 11 12 13 14 15 16 17 18
		// result: Q2 Q3 Q4
		System.out.println(
				Times.getHour(workTime)+":00 ~ "+
				Times.getHour(Times.addHour(workTime, howlong))+":00");
		System.out.println(WorkQtime.valueOf(workTime, howlong));
	}
}

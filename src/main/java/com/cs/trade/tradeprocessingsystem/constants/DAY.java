package com.cs.trade.tradeprocessingsystem.constants;

/**
 * @author SoumyaRanjan Moharana
 *
 */
public enum DAY {

	SATURDAY(7), SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THRUSDAY(5), FRIDAY(6);

	int day;

	/**
	 * @param day
	 */
	DAY(int day) {
		this.day = day;
	}

	private int getDay() {
		return this.day;
	}

	public boolean equals(int compareDay) {
		if ((compareDay == SATURDAY.getDay()) || (compareDay == SUNDAY.getDay()))
			return true;
		return false;
	}

}

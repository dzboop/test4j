package org.test4j.datafilling.model;

import java.util.Calendar;

import org.test4j.datafilling.annotations.FillInteger;

public abstract class AbstractOneDimensionalPojo {

	@FillInteger(max = 10)
	private int parentIntField;

	private Calendar parentCalendarField;

	public int getParentIntField() {
		return parentIntField;
	}

	protected void setParentIntField(int parentIntField) {
		this.parentIntField = parentIntField;
	}

	public Calendar getParentCalendarField() {
		return parentCalendarField;
	}

	protected void setParentCalendarField(Calendar parentCalendarField) {
		this.parentCalendarField = parentCalendarField;
	}
}

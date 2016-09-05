package com.github.gin.qcsv.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter{

    private String dateFormat;

    public DateConverter(String dateFormat){
        this.dateFormat = dateFormat;
    }

	@Override
	public Date convert(String arg) {
		Date date = null;
		DateFormat format = new SimpleDateFormat(dateFormat);
		try {
			date = format.parse(arg);
		} catch (ParseException e) {}
		return date;
	}

    @Override
    public String convert(Object object) {
        Date date = (Date) object;
        DateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}

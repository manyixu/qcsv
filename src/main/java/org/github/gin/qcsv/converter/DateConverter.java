package org.github.gin.qcsv.converter;

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

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}

package com.github.gin.qcsv.converter;

public class StringConverter implements Converter{

	@Override
	public String convert(String arg) {
		return arg;
	}

    @Override
    public String convert(Object object) {
        return object.toString();
    }

}

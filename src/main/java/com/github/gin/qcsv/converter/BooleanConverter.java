package com.github.gin.qcsv.converter;

public class BooleanConverter implements Converter{

	@Override
	public Boolean convert(String arg) {
		Boolean bool = Boolean.parseBoolean(arg);
		return bool;
	}

    @Override
    public String convert(Object object) {
        Boolean bool = (Boolean) object;
        return Boolean.toString(bool);
    }

}

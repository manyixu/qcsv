package com.github.gin.qcsv.converter;

public interface Converter {

	public Object convert(String arg);

    public String convert(Object object);
}

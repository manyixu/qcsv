package org.github.gin.qcsv.converter;

public class BooleanConverter implements Converter{

	@Override
	public Boolean convert(String arg) {
		Boolean bool = Boolean.parseBoolean(arg);
		return bool;
	}

}

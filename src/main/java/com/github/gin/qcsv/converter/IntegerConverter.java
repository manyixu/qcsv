package com.github.gin.qcsv.converter;

public class IntegerConverter implements Converter{

    public boolean nullable ;

    public IntegerConverter(boolean nullable){
        this.nullable = nullable;
    }

	@Override
	public Integer convert(String arg) {
		try{
            return Integer.parseInt(arg);
		} catch (NumberFormatException e){
            return nullable ? null : 0;
		}
	}

    @Override
    public String convert(Object object) {
        Integer i = (Integer) object;
        return i.toString();
    }

}

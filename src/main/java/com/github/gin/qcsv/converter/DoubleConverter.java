package com.github.gin.qcsv.converter;

public class DoubleConverter implements Converter{

    private boolean nullable ;

    public DoubleConverter(boolean nullable){
        this.nullable = nullable;
    }

	@Override
	public Double convert(String arg) {
		try{
			return Double.parseDouble(arg);
		} catch(NumberFormatException e){
			return nullable ? null : 0d;
		}
		
	}

    @Override
    public String convert(Object object) {
        Double d = (Double) object;
        return d.toString();
    }

}

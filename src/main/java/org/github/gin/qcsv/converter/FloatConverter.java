package org.github.gin.qcsv.converter;

public class FloatConverter implements Converter{

    private boolean nullable;

    public FloatConverter(boolean nullable){
        this.nullable = nullable;
    }

	@Override
	public Float convert(String arg) {
		try{
			return Float.parseFloat(arg);
		}catch(NumberFormatException e){
			return nullable ? null : 0f;
		}
	}
}

package org.github.gin.qcsv.converter;

public class LongConverter implements Converter{

    private boolean nullable ;

    public LongConverter(boolean nullable){
        this.nullable = nullable;
    }

	@Override
	public Long convert(String arg) {
		try{
			return Long.parseLong(arg);
		} catch (NumberFormatException e){
			return nullable ? null : 0l;
		}
	}

}

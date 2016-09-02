package org.github.gin.qcsv.converter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TypeConverter {

	public static final Map<Class<?>,Converter> TYPE_HOLDER = new HashMap<>();
	
	static{
		TYPE_HOLDER.put(boolean.class, new BooleanConverter());
		TYPE_HOLDER.put(Boolean.class, new BooleanConverter());
		TYPE_HOLDER.put(int.class, new IntegerConverter(false));
		TYPE_HOLDER.put(Integer.class, new IntegerConverter(true));
		TYPE_HOLDER.put(float.class, new FloatConverter(false));
		TYPE_HOLDER.put(Float.class, new FloatConverter(true));
		TYPE_HOLDER.put(double.class, new DoubleConverter(false));
		TYPE_HOLDER.put(Double.class, new DoubleConverter(true));
		TYPE_HOLDER.put(long.class, new LongConverter(false));
		TYPE_HOLDER.put(Long.class, new LongConverter(true));
		TYPE_HOLDER.put(String.class, new StringConverter());
		TYPE_HOLDER.put(Date.class, new DateConverter("yyyy-MM-dd HH:mm:ss"));
	}
	
	public static Object convert(String dataText,Class<?> fieldType){
		Converter converter = TYPE_HOLDER.get(fieldType);
		return converter.convert(dataText);
	}

    public static Object convert(String dataText,Class<?> fieldType,String format){
        Converter converter = TYPE_HOLDER.get(fieldType);
        if(converter instanceof DateConverter){
            DateConverter dateConverter = (DateConverter) converter;
            dateConverter.setDateFormat(format);
        }
        return converter.convert(dataText);
    }
}

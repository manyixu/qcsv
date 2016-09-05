package com.github.gin.qcsv.util;

import com.github.gin.qcsv.annotation.CSV;
import com.github.gin.qcsv.vo.CSVList;
import com.github.gin.qcsv.vo.CSVVO;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by FSTMP on 2016/9/2.
 */
public class BeanUtil {

    public static CSVList getCSVList(Class clazz){
        CSVList csvList = new CSVList();
        for(Field field : clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(CSV.class)){
                CSV csv = field.getAnnotation(CSV.class);
                CSVVO csvvo = new CSVVO();
                csvvo.setName(csv.name());
                csvvo.setDateFormat(csv.dateFormat());
                csvvo.setFieldName(field.getName());
                csvvo.setFieldType(field.getType());
                csvList.add(csvvo);
            }
        }
        return csvList;
    }

    public static <T> T newInstance(Class<T> clazz){
        T instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public static <T> Object invokeMethod(Object instance,Method method,Object...args){
        Object res = null;
        try {
            res = method.invoke(instance, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static <T> Method getSetter(String fieldName,Class<T> clazz){
        Method method = null;
        try {
            PropertyDescriptor fieldDesc = new PropertyDescriptor(fieldName,clazz);
            method = fieldDesc.getWriteMethod();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return method;
    }

    public static <T> Method getGetter(String fieldName,Class<T> clazz){
        Method method = null;
        try {
            PropertyDescriptor fieldDesc = new PropertyDescriptor(fieldName,clazz);
            method = fieldDesc.getReadMethod();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return method;
    }

    public static <T> Object setValue(String fieldName, Object instance, Object... args){
        Method method = getSetter(fieldName, instance.getClass());
        Object res = invokeMethod(instance, method,args);
        return res;
    }


    public static <T>Object getValue(String fieldName,Object instance,Object...args){
        Method method = getGetter(fieldName, instance.getClass());
        Object res = invokeMethod(instance, method,args);
        return res;
    }

    public static<T> Object getCSVValue(String header,Object instance){
        for(Field field : instance.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(CSV.class)){
                CSV csv = field.getAnnotation(CSV.class);
                if(header.equals(csv.name()))
                    return getValue(field.getName(),instance);
            }
        }
        return null;
    }
}

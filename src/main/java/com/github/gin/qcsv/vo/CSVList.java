package com.github.gin.qcsv.vo;

import com.github.gin.qcsv.annotation.CSV;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by FSTMP on 2016/9/2.
 */
public class CSVList extends ArrayList<CSVVO> {

    public CSVList(){}

    public CSVList(CSVVO... csvs){
        super(Arrays.asList(csvs));
    }

    public String[] getHeaders(){
        String[] headers = new String[this.size()];
        for(int i = 0; i<this.size(); i++){
            CSVVO vo = this.get(i);
            headers[i] = vo.getName();
        }
        return headers;
    }

    public Class<?> getFieldType(String name){
        for(CSVVO csvvo : this){
            if(name.equals(csvvo.getName())){
                return csvvo.getFieldType();
            }
        }
        return null;
    }

    public CSVVO get(String name){
        for(CSVVO csvvo : this){
            if(name.equals(csvvo.getName()))
                return csvvo;
        }
        return null;
    }
}

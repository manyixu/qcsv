package org.github.gin.qcsv.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}

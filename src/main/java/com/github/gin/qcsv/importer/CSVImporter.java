package com.github.gin.qcsv.importer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import com.github.gin.qcsv.converter.TypeConverter;
import com.github.gin.qcsv.util.BeanUtil;
import com.github.gin.qcsv.vo.CSVList;
import com.github.gin.qcsv.vo.CSVVO;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by GinPonson on 2016/9/2.
 */
public class CSVImporter<T> {

    private Class<T> clazz;

    private CSVFormat csvFormat;

    private CSVList csvList;

    public CSVImporter(Class<T> clazz){
        this.clazz = clazz;
        csvList = BeanUtil.getCSVList(clazz);
        csvFormat = CSVFormat.DEFAULT.withHeader(csvList.getHeaders()).withSkipHeaderRecord();
    }

    public List<T> importCSV(File file,Charset charset){
        List<T> list = new ArrayList<>();

        try {
            CSVParser p = CSVParser.parse(file, charset, csvFormat);
            Iterator<CSVRecord> iterator = p.iterator();

            while (iterator.hasNext()){
                CSVRecord csvRecord = iterator.next();

                T instance = BeanUtil.newInstance(clazz);
                for(CSVVO csvvo : csvList){
                    Object fieldValue = TypeConverter.convert(csvRecord.get(csvvo.getName()), csvvo.getFieldType(),csvvo.getDateFormat());
                    BeanUtil.setValue(csvvo.getFieldName(),instance,fieldValue);
                }
                list.add(instance);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CSVFormat getCsvFormat() {
        return csvFormat;
    }

    public void setCsvFormat(CSVFormat csvFormat) {
        this.csvFormat = csvFormat;
    }
}

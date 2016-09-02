package org.github.gin.qcsv.importer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.github.gin.qcsv.converter.TypeConverter;
import org.github.gin.qcsv.util.BeanUtil;
import org.github.gin.qcsv.vo.CSVList;
import org.github.gin.qcsv.vo.CSVVO;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by FSTMP on 2016/9/2.
 */
public class CSVImporter<T> {

    public List<T> importCSV(File file,Class<T> clazz,Charset charset){
        List<T> list = new ArrayList<>();

        CSVList csvList = BeanUtil.getCSVList(clazz);
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(csvList.getHeaders());

        try {
            CSVParser p = CSVParser.parse(file, charset, csvFormat.withSkipHeaderRecord());
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
}

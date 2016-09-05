package com.github.gin.qcsv.exporter;

import com.github.gin.qcsv.converter.TypeConverter;
import com.github.gin.qcsv.util.BeanUtil;
import com.github.gin.qcsv.vo.CSVList;
import com.github.gin.qcsv.vo.CSVVO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by FSTMP on 2016/9/2.
 */
public class CSVExporter<T> {

    private Class<T> clazz;

    private CSVFormat csvFormat;

    private CSVList csvList;

    public CSVExporter(Class<T> clazz){
        this.clazz = clazz;
        csvList = BeanUtil.getCSVList(clazz);
        csvFormat = CSVFormat.DEFAULT.withHeader(csvList.getHeaders());
    }

    public void exportCSV(File dist ,Collection<T> datas,Charset charset){
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter writer = null;
        CSVPrinter csvPrinter = null;
        try {
            fileOutputStream = new FileOutputStream(dist);
            writer = new OutputStreamWriter(fileOutputStream, charset);

            csvPrinter = new CSVPrinter(writer,csvFormat);

            for(T t : datas){
                List<String> rawList = new ArrayList<>();
                for(String header : csvFormat.getHeader()){
                    CSVVO csvvo = csvList.get(header);
                    String rawdata = TypeConverter.convert(BeanUtil.getCSVValue(header, t),csvvo.getFieldType(),csvvo.getDateFormat());
                    rawList.add(rawdata);
                }
                csvPrinter.printRecord(rawList);
            }

            writer.flush();
            csvPrinter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(csvPrinter != null)
                    csvPrinter.close();
                if(writer != null)
                    writer.close();
                if(fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public CSVFormat getCsvFormat() {
        return csvFormat;
    }

    public void setCsvFormat(CSVFormat csvFormat) {
        this.csvFormat = csvFormat;
    }
}

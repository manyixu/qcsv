package com.github.gin.qcsv.util;

import com.github.gin.qcsv.exporter.CSVExporter;
import org.apache.commons.csv.CSVFormat;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Collection;

/**
 * Created by FSTMP on 2016/9/5.
 */
public class CSVExportUtil<T> {

    public static<T> void exportCSV(File dist,Class<T> clazz,Collection<T> datas,Charset charset){
        CSVExporter<T> csvExporter = new CSVExporter<>(clazz);
        csvExporter.exportCSV(dist,datas,charset);
    }

    public static<T> void exportCSV(File dist,Class<T> clazz,Collection<T> datas,Charset charset,CSVFormat csvFormat){
        CSVExporter<T> csvExporter = new CSVExporter<>(clazz);
        csvExporter.setCsvFormat(csvFormat);
        csvExporter.exportCSV(dist,datas,charset);
    }
}

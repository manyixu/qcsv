package com.github.gin.qcsv.util;

import com.github.gin.qcsv.exporter.CSVExporter;
import org.apache.commons.csv.CSVFormat;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Collection;

/**
 * Created by GinPonson on 2016/9/5.
 */
public class CSVExportUtil {

    public static void exportCSV(File dist,Class<?> clazz,Collection<?> datas,Charset charset){
        CSVExporter csvExporter = new CSVExporter(clazz);
        csvExporter.exportCSV(dist,datas,charset);
    }

    public static void exportCSV(File dist,Class<?> clazz,Collection<?> datas,Charset charset,CSVFormat csvFormat){
        CSVExporter csvExporter = new CSVExporter(clazz);
        csvExporter.setCsvFormat(csvFormat);
        csvExporter.exportCSV(dist,datas,charset);
    }
}

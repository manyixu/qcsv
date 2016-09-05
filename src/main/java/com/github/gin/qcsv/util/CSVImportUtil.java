package com.github.gin.qcsv.util;

import com.github.gin.qcsv.importer.CSVImporter;
import org.apache.commons.csv.CSVFormat;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by FSTMP on 2016/9/5.
 */
public class CSVImportUtil<T> {

    public static<T> List<T> importCSV(File file,Class<T> clazz,Charset charset){
        CSVImporter<T> csvImporter = new CSVImporter<>(clazz);
        return csvImporter.importCSV(file,charset);
    }

    public static<T> List<T> importCSV(File file,Class<T> clazz,Charset charset,CSVFormat csvFormat){
        CSVImporter<T> csvImporter = new CSVImporter<>(clazz);
        csvImporter.setCsvFormat(csvFormat);
        return csvImporter.importCSV(file,charset);
    }
}

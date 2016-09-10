qcsv
=====

快速读取csv文件。

##qcsv操作csv文件

1.注解,导入导出都是基于@CSV注解的,实体上做上注解。<br>
@CSV注解使用在实体的字段上，name是该字段导入导出csv文件的标题，dateFormat是时间格式(可选)

2.导入csv文件
CSVImportUtil.importCSV(File file,Class\<T> clazz,Charset charset)

3.导出csv文件
CSVExportUtil.exportCSV(File dist,Class<?> clazz,Collection<?> datas,Charset charset)

##依赖项目
commons-csv



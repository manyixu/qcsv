qcsv
=====

快速读取csv文件。

##qcsv操作csv文件

1.注解,导入导出都是基于@CSV注解的,实体上做上注解。<br>
@CSV注解使用在实体的字段上，name是该字段导入导出csv文件的标题，dateFormat是时间格式(可选)

```Java
public class Student {

    private Integer id;

    @CSV(name="姓名")
    private String name;

    @CSV(name="生日",dateFormat = "yyyy-MM-dd")
    private Date birthday;
}
```

2.导入csv文件
```Java
List<Student> students = CSVImportUtil.importCSV(new File("d:/student.csv"),Student.class,Charset.forName("GBK"))
```

3.导出csv文件
```Java
CSVExportUtil.exportCSV(new File("d:/student.csv"),Student.class,students,Charset.forName("GBK"))
```

##依赖项目
commons-csv



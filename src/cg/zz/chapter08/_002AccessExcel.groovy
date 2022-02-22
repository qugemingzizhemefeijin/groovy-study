package cg.zz.chapter08

import groovy.sql.Sql

/*
class RunTest extends TestBase {
    void testAccessExcel() {
        result = "cmd /c groovy AccessExcel.groovy".execute().text
        result = result.replaceAll('\n', '').replaceAll(' ', '').replaceAll('\t', '')
        assertResultEquals new File('AccessExcel.output').text
                .replaceAll('\n', '').replaceAll(' ', '').replaceAll('\t', '')
    }
}
*/

// 没测试通过。。应该是需要设置啥ODBC鬼的。
def sql = Sql.newInstance(
        """jdbc:odbc:Driver=
{Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};
DBQ=CE:\\eclipse\\mygithub\\groovy-study\\src\\cg\\zz\\chapter08\\weather.xlsx;READONLY=false""", '', '')

println "City\t\tTemperature"
sql.eachRow('SELECT * FROM [temperatures$]') {
    println "${it.city}\t\t${it.temperature}"
}

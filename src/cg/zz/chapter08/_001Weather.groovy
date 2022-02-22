package cg.zz.chapter08

import groovy.sql.Sql
import groovy.xml.MarkupBuilder

import java.sql.ResultSet

/*
class RunTest extends TestBase {
    void testWeather() {
        result = " groovy -classpath /opt/java/mysql/mysql-connector-java-5.1.18/mysql-connector-java-5.1.18-bin.jar Weather.groovy".execute().text
        assertResultMatchesFileContent 'Weather.output'
    }
}
*/

// mysql 数据库读取

// 必须添加这两个注解，加载数据库连接驱动包
@GrabConfig(systemClassLoader = true)
@Grab('mysql:mysql-connector-java:5.1.25')

userid = 'root'
password = 'abcd1234'

def sql = Sql.newInstance(
        'jdbc:mysql://localhost:3306/test',
        userid,
        password,
        'com.mysql.jdbc.Driver')

// 打印数据库名称
println sql.connection.catalog

// 打印表信息
println "City                Temperature"
sql.eachRow('SELECT * from weather') {
    printf "%-20s%s\n", it.city, it[1]
}

println '======================================'

// 直接从数据库中获取元数据信息
processMeta = { metaData ->
    metaData.columnCount.times { i ->
        printf "%-21s", metaData.getColumnLabel(i+1)
    }
    println ""
}

sql.eachRow('SELECT * from weather', processMeta) {
    printf "%-20s %s\n", it.city, it[1]
}

println '======================================'

// 将获取的结果存储到list中
rows = sql.rows('SELECT * from weather')
println "Weather info available for ${rows.size()} cities"
println "rows class ${rows.getClass().name}"

// 获取第一行数据
row = sql.firstRow('SELECT * from weather')
println "Weather first row for ${row}"

println '======================================'

// 将数据转化成XML
bldr = new MarkupBuilder()
bldr.weather {
    sql.eachRow('SELECT * from weather') {
        city(name: it.city, temperature: it.temperature)
    }
}

println '======================================'

// 使用DataSet，简化操作
dataSet = sql.dataSet('weather')
println "Cities below freezing:"
println dataSet.sql
dataSet.each {
    println it.city
}

// 添加数据
println "Number of cities : " + sql.rows('SELECT * from weather').size()
dataSet.add(city: 'Denver', temperature: 19)
println "Number of cities : " + sql.rows('SELECT * from weather').size()

// 还可以使用sql
temperature = 50
sql.executeInsert("""INSERT INTO weather (city, temperature) 
                    VALUES ('Oklahoma City', ${temperature})""")
println sql.firstRow(
        "SELECT temperature from weather WHERE city='Oklahoma City'")
/* 必须基于主键
// allow resultSets to be able to be changed
sql.resultSetConcurrency = ResultSet.CONCUR_UPDATABLE

// change the data
sql.eachRow("select * from weather") {
    it.temperature = it.temperature * 2
}

// reset resultSetsConcurrency back to read only (no further changes required)
sql.resultSetConcurrency = ResultSet.CONCUR_READ_ONLY

// do a query to confirm that our change actually worked
results = sql.firstRow("SELECT temperature from weather WHERE city='Oklahoma City'").temperature
println results
*/

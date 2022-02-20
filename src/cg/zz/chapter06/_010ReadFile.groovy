package cg.zz.chapter06

// 读取文件，Groovy通过向BufferedReader、InputStream和File添加一个text属性。
println new File("thoreau.txt").text

// 如果不想一次性读取出去，而是一行一行的读取，可以使用eachLine()方法。
new File("thoreau.txt").eachLine {line ->
    println line
}

// 如果只是想取的满足特性条件的行文本，可以使用filterLine()
println new File("thoreau.txt").filterLine { it =~ /life/ }
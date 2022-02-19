package cg.zz.chapter04

// 双引号("")或者正斜杠(//)来创建表达式。。。转义字符为(\)可以来打印$字符

value = 12
println "He paid \$${value} for that."

// 如果定义字符串时使用的是正斜杠，而非双引号，则不必转义$。
println(/He paid $$value for that/)

// Groovy 支持惰性传值，即把表达式保存在一个字符串中，稍后打印。
what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text

what.replace(0, 5, "moon")
println text

// 使用单引号创建的字符串和使用双引号或正斜杠创建的字符串不同。前者是java.lang.String，而后者被称为GString。
def printClassInfo(obj) {
    println "class: ${obj.getClass().name}"
    println "superClass: ${obj.getClass().superclass.name}"
}

val = 125
printClassInfo("The Stock closed at ${val}")
printClassInfo(/The stock closed at ${val}/)
printClassInfo("This is a simple String")

//class: org.codehaus.groovy.runtime.GStringImpl
//superClass: groovy.lang.GString
//class: org.codehaus.groovy.runtime.GStringImpl
//superClass: groovy.lang.GString
//class: java.lang.String
//superClass: java.lang.Object

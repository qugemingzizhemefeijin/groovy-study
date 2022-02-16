package cg.zz.chapter01

// groovy中==默认使用equals比较，如果想使用引用比较，则需要使用is()函数，如果==比较的对象实现了Comparable接口，则会使用compareTo()方法

str1 = 'hello'
str2 = str1
str3 = new String('hello')
str4 = 'Hello'

println "str1 == str2 : ${str1 == str2}"
println "str1 == str3 : ${str1 == str3}"
println "str1 == str4 : ${str1 == str4}"

println "str1.is(str2): ${str1.is(str2)}"
println "str1.is(str3): ${str1.is(str3)}"
println "str1.is(str4): ${str1.is(str4)}"

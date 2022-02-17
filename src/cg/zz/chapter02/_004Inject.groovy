package cg.zz.chapter02

import groovy.transform.TypeChecked

// @TypeChecked 这里如果加上这个注解，则shout()方法会报错。但是实际上是可以运行的。。但是如果是invokeMethod()的方法则会没事。
def shoutString(String str) {
    println str.shout()
}

str = "Hello"
str.metaClass.shout = { -> toUpperCase() }
shoutString(str)

package cg.zz.chapter10

// 动态调用方法

def printInfo(obj) {

    usrRequestedProperty = 'bytes'
    usrRequestedMethod = 'toUpperCase'

    println obj[usrRequestedProperty]
    // 或
    println obj."${usrRequestedProperty}"

    println obj."$usrRequestedMethod"()
    // 或
    println obj.invokeMethod(usrRequestedMethod, null)
}

printInfo('hello')

// 迭代对象的所有属性

println "Properties of 'hello' are: "
'hello'.properties.each { println it }

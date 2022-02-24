package cg.zz.chapter11

import groovy.transform.Immutable

// 默认情况下，Groovy并没有使用ExpandoMetaClass。当我们向metaClass中添加一个方法时，默认的metaClass会被用一个ExpandoMetaClass替换掉。

// 一开始Integer实例所用的metaClass是HandleMetaClass，还有一个用于委托方法调用的隐藏的MetaClassImpl
// 当我们向Integer的metaClass添加方法时，它被一个ExpandoMetaClass实例替换掉了。delegate也变成了ExpandoMetaClass实例，不是原来的MetaClassImpl。
def printMetaClassInfo(instance) {
    print "MetaClass of ${instance} is ${instance.metaClass.class.simpleName}"
    println " with delegate ${instance.metaClass.delegate.class.simpleName}"
}

printMetaClassInfo(2)
println "MetaClass of Integer is ${Integer.metaClass.class.simpleName}"
println "Adding a method to Integer metaClass"
Integer.metaClass.someNewMethod = { -> /* */ }
printMetaClassInfo(2)
println "MetaClass of Integer is ${Integer.metaClass.class.simpleName}"

@Immutable
class MyClass {
    String name
}

obj1 = new MyClass("obj1")

printMetaClassInfo(obj1)
println "Adding a method to MyClass metaClass"
MyClass.metaClass.someNewMethod = { -> /* */}
printMetaClassInfo(obj1)

println "obj2 created later"
obj2 = new MyClass("obj2")
printMetaClassInfo(obj2)

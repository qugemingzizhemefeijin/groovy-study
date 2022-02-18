package cg.zz.chapter03

// this,owner,delegate是闭包的三个属性，用于确定由哪个对象处理该闭包的方法调用。
// 一般而言，delegate会设置为owner，但是对其加以修改，可以挖掘出Groovy的一些非常好的元编程能力。

def examiningClosure(closure) {
    closure()
}

examiningClosure() {
    println "In First Closure:"
    println "class is " + getClass().name
    println "this is " + this + ", super:" + this.getClass().superclass.name
    println "owner is " + owner + ", super:" + owner.getClass().superclass.name
    println "delegate is " + delegate + ", super:" + delegate.getClass().superclass.name
    println "========================================="
    // 闭包内部的闭包
    examiningClosure() {
        println "In Closure within the First Closure:"
        println "class is " + getClass().name
        println "this is " + this + ", super:" + this.getClass().superclass.name
        println "owner is " + owner + ", super:" + owner.getClass().superclass.name
        println "delegate is " + delegate + ", super:" + delegate.getClass().superclass.name
    }
    // 闭包内的this指定该闭包所绑定的对象(正在执行的上下文)，在闭包内引用的变量和方法都会绑定到this，它负责处理任何方法调用，以及对任何属性或变量的访问。
    // 如果this无法处理，则转向owner，最后是delegate
    // 这里可以看到 this是指向的是第一次进入的闭包，owner在第二次就不等于this
}
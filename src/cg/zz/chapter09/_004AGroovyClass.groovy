package cg.zz.chapter09

// 在java中创建与传递Groovy闭包
class AGroovyClass {

    // 要在java中调用useClosure方法，我们需要提供一个实现了Call()方法的实例；见UseAGroovyClass.java
    def useClosure(closure) {
        println "Calling closure"
        closure()
    }

    // 调用接收一个参数的闭包方法，查看 UseAGroovyClass2.java
    def passToClosure(int value, closure) {
        println "Simply passing $value to the given closure"
        closure(value)
    }
}
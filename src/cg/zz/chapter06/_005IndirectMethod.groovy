package cg.zz.chapter06

// 如果以String形式接受一个方法名，而且想调用该方法，使用反射。。但是在Groovy中不需要做这些，只需要简单的调用invokeMethod()方法。

class Person {
    def walk() {println "Walking..."}
    def walk(int miles) {println "Walking $miles miles..."}
    def walk(int miles, String where) {println "Walking $miles miles $where"}
}

peter = new Person()

peter.invokeMethod("walk", null)
peter.invokeMethod("walk", 10)
peter.invokeMethod("walk", [2, 'uphill'] as Object[])
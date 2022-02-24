package cg.zz.chapter11

// 这里要用 System.out.print 替代 print，避免提供信息打印的方法被拦截。这是因为print()方法是Groovy在Object上注入的一个方法。
// 如果调用它，则会被我们编写的代码给拦截了。

// 这种方式适合拦截类作者是开发者自己。如果类作者不是自己，可以通过MetaClass来拦截
class Car implements GroovyInterceptable {

    def check() { System.out.println "check called..." }

    def start() { System.out.println "start called..." }

    def drive() { System.out.println "drive called..." }

    def invokeMethod(String name, args) {
        System.out.print("Call to $name intercepted... ")

        // 如果不是check方法，则打印一下，并且前置调用check方法。
        if (name != 'check') {
            System.out.print("running filter... ")
            Car.metaClass.getMetaMethod('check').invoke(this, null)
        }

        // 这里判断是否存在方法，如果存在则直接调用，否则调用metaClass的invokeMethod方法，如果继续没有，则会报错MissingMethodException
        def validMethod = Car.metaClass.getMetaMethod(name, args)
        if (validMethod != null) {
            validMethod.invoke(this, args)
        } else {
            Car.metaClass.invokeMethod(this, name, args)
        }
    }

}

car = new Car()

car.start()
car.drive()
car.check()

try {
    car.speed()
} catch (ex) {
    println ex
}

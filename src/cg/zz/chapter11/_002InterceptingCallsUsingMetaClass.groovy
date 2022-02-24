package cg.zz.chapter11

class Car2 {
    def check() { System.out.println "check called..." }

    def start() { System.out.println "start called..." }

    def drive() { System.out.println "drive called..." }
}

// 这里以闭包的形式实现invokeMethod()，并将其设置到Car2的metaClass上。
// 这个与上面一个版本不同的是，这里使用的是delegate，而非this。
// 在用于拦截的闭包内，delegate指向的是要拦截其方法的目标对象。
// 第二个是调用了invokeMissingMethod，因为我们已经在invokeMethod方法中了，不应该递归的调用该方法。
Car2.metaClass.invokeMethod = {String name, args ->
    System.out.print("Call to $name intercepted... ")

    if (name != 'check') {
        System.out.print("running filter... ")
        Car2.metaClass.getMetaMethod('check').invoke(delegate, null)
    }

    def validMethod = Car2.metaClass.getMetaMethod(name, args)
    if (validMethod != null) {
        validMethod.invoke(delegate, args)
    } else {
        Car2.metaClass.invokeMissingMethod(delegate, name, args)
    }
}

car = new Car2()

car.start()
car.drive()
car.check()
try {
    car.speed()
} catch(Exception ex) {
    println ex
}

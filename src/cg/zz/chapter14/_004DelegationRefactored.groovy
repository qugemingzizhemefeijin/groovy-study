package cg.zz.chapter14

// 比上一个更好的实现。
Object.metaClass.delegateCallsTo = {Class... klassOfDelegates ->
    // 初始化所有的实例
    def objectOfDelegates = klassOfDelegates.collect { it.newInstance() }
    // 设置调用方的methodMissing方法
    delegate.metaClass.methodMissing = { String name, args ->
        println "intercepting call to $name..."
        // 查找被代理的是否有对应的方法
        def delegateTo = objectOfDelegates.find {
            it.metaClass.respondsTo(it, name, args)
        }

        if (delegateTo) {
            // 存在的话则缓存到调用类中
            delegate.metaClass."${name}" = { Object[] varArgs ->
                delegateTo.invokeMethod(name, varArgs)
            }
            // 并调用实际的方法
            delegateTo.invokeMethod(name, args)
        } else {
            throw new MissingMethodException(name, delegate.getClass(), args)
        }
    }
}

class Worker2 {
    def simpleWork1(spec) { println "worker does work1 with spec $spec" }
    def simpleWork2() { println "worker does work2" }
}

class Expert2 {
    def advancedWork1(spec) { println "Expert does work1 with spec $spec" }
    def advancedWork2(scope, spec) {
        println "Expert does work2 with scope $scope spec $spec"
    }
}

class Manager2 {
    { delegateCallsTo Worker2, Expert2, GregorianCalendar }

    def schedule() { println "Scheduling ..." }
}

peter = new Manager2()
peter.schedule()
peter.simpleWork1('fast')
peter.simpleWork1('quality')
peter.simpleWork2()
peter.simpleWork2()
peter.advancedWork1('fast')
peter.advancedWork1('quality')
peter.advancedWork2('prototype', 'fast')
peter.advancedWork2('product', 'quality')
println "Is 2008 a leap year? " + peter.isLeapYear(2008)
try {
    peter.simpleWork3()
} catch(Exception ex) {
    println ex
}

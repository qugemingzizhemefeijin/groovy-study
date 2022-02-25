package cg.zz.chapter14

// 一个Manager想把工作委托给一个Worker或一个Expert。使用methodMissing()和ExpandoMetaClass来实现功能。
// 如果在Manager上调用的一个方法并不存在，该实例的methodMissing()方法会将调用路由给Worker或Expert
// 只要其中有一个能够成功处理respondsTo()方法即可。如果这些委托对象都不能处理某个方法，则Manager无法处理该方法。
class Worker {
    def simpleWork1(spec) { println "worker does work1 with spec $spec" }

    def simpleWork2() { println "worker does work2" }
}

class Expert {
    def advancedWork1(spec) { println "Expert does work1 with spec $spec" }

    def advancedWork2(scope, spec) {
        println "Expert does work2 with scope $scope spec $spec"
    }
}

class Manager {
    def worker = new Worker()
    def expert = new Expert()

    def schedule() { println "Scheduling ..." }

    def methodMissing(String name, args) {
        println "intercepting call to $name..."
        def delegateTo = null

        if (name.startsWith('simple')) {
            delegateTo = worker
        } else if (name.startsWith('advanced')) {
            delegateTo = expert
        }
        if (delegateTo?.metaClass.respondsTo(delegateTo, name, args)) {
            Manager instance = this
            instance.metaClass."${name}" = { Object[] varArgs ->
                delegateTo.invokeMethod(name, varArgs)
            }
            delegateTo.invokeMethod(name, args)
        } else {
            throw new MissingMethodException(name, Manager.class, args)
        }
    }
}

peter = new Manager()
peter.schedule()
peter.simpleWork1('fast')
peter.simpleWork1('quality')
peter.simpleWork2()
peter.simpleWork2()
peter.advancedWork1('fast')
peter.advancedWork1('quality')
peter.advancedWork2('prototype', 'fast')
peter.advancedWork2('product', 'quality')
try {
    peter.simpleWork3()
} catch(Exception ex) {
    println ex
}

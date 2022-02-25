package cg.zz.chapter13

// 对于实现了GroovyInterceptable的对象，调用该对象上的任何方法， 都会调用到invokeMethod()。
// 与invokeMethod()不同的是，只有调用不存在的方法时，才会调用到methodMissing()。
// 如果一个对象实现了GroovyInterceptable，不管被调用的方法是否存在，invokeMethod()都会被调用。
// 只有对象将控制转移给其MetaClass的invokeMethod()时，methodMissing()才会被调用。

class Human implements GroovyInterceptable {
    def work() { "working..." }
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']
    def invokeMethod(String name, args) {
        System.out.println "Intercepting call for $name"

        def method = metaClass.getMetaMethod(name, args)

        if (method) {
            method.invoke(this, args)
        } else{
            metaClass.invokeMethod(this, name, args)
        }
    }

    def methodMissing(String name, args) {
        System.out.println "methodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1] }

        if (methodInList) {
            def impl = {Object[] vargs ->
                "playing ${name.split('play')[1]}..."
            }

            Human instance = this
            instance.metaClass."$name" = impl // 以后调用就会使用它

            impl(args)
        } else {
            throw new MissingMethodException(name, Human.class, args)
        }
    }
}

jack = new Human()
println jack.work()
println jack.playTennis()
// 这里可以看出如果将方法缓存，下次再调用，会被invokeMethod拦截
println jack.playTennis()

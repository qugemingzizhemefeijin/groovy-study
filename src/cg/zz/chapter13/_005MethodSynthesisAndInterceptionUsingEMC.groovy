package cg.zz.chapter13

// 还可以混合使用invokeMethod()和methodMissing()，来拦截对现有的方法和合成的方法的调用

class Cat {
    def work() { "working..." }
}

// invokeMethod()是GroovyObject的一个方法。methodMissing()则是Groovy中后来引入的，是基于MetaClass的方法处理的组成部分。
// 如果目标是处理对不存在的方法的调用，应该事先methodMissing()，因为它的开销较低。
// 如果目标是拦截所有的方法调用，而不管方法存在与否，则应使用invokeMethod()。
Cat.metaClass.invokeMethod = {String name, args ->
    System.out.println "intercepting call for ${name}"

    def method = Cat.metaClass.getMetaMethod(name, args)

    if(method) {
        method.invoke(delegate, args)
    } else {
        Cat.metaClass.invokeMissingMethod(delegate, name, args)
    }
}

Cat.metaClass.methodMissing = {String name, args ->
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    System.out.println "methodMissing called for ${name}"
    def methodInList = plays.find { it == name.split('play')[1]}

    if (methodInList) {
        def impl = { Object[] vargs ->
            "playing ${name.split('play')[1]}..."
        }

        Cat.metaClass."$name" = impl //future calls will use this

        impl(args)
    } else {
        throw new MissingMethodException(name, Cat.class, args)
    }
}

jack = new Cat()
println jack.work()
println jack.playTennis()
// 第二次调用不会输出 methodMissing called for playTennis
println jack.playTennis()

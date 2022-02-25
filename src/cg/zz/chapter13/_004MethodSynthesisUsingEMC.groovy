package cg.zz.chapter13

// 如果我们无权编辑类的源文件，或者该类并非一个POGO，前面的方法就行不通了。不过可以使用ExpandoMetaClass来合成方法。

class Dog {
    def work() { "working..." }
}

// 如果我们的类中也提供了methodMissing()方法，MetaClass的methodMissing()方法会优先被调用。类的MetaClass上的方法会覆盖掉类中的方法。
Dog.metaClass.methodMissing = {String name, args ->
    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    System.out.println "methodMissing called for $name"
    def methodInList = plays.find { it == name.split('play')[1]}

    if (methodInList) {
        def impl = { Object[] vargs ->
            "playing ${name.split('play')[1]}..."
        }

        Dog.metaClass."$name" = impl // 以后再调用就会使用它
        impl(args)
    } else {
        throw new MissingMethodException(name, Dog.class, args)
    }
}

jack = new Dog()
println jack.work()
println jack.playTennis()
println jack.playTennis()

try {
    jack.playPolitics()
} catch(ex) {
    println ex
}

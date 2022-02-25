package cg.zz.chapter13

class Person2 {
    def work() { "working..." }

    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def methodMissing(String name, args) {
        System.out.println "methodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1] }

        // 如果调用的犯法不存在，则缓存到metaClass中，就可以直接被调用了
        if (methodInList) {
            def impl = { Object[] vargs ->
                "playing ${name.split('play')[1]}..."
            }

            Person2 instance = this
            instance.metaClass."$name" = impl // 以后再调用就会使用它

            impl(args)
        } else {
            throw new MissingMethodException(name, Person2.class, args)
        }
    }
}

jack = new Person2()
println jack.playTennis()
// 第二次调用就不会输出 methodMissing called for playTennis
println jack.playTennis()

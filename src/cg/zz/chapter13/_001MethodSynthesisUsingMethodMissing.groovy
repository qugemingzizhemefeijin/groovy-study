package cg.zz.chapter13

class Person {
    def work() { "working..." }

    def plays = ['Tennis', 'VolleyBall', 'BasketBall']

    def methodMissing(String name, args) {
        System.out.println "MethodMissing called for $name"
        def methodInList = plays.find { it == name.split('play')[1] }
        if (methodInList) {
            "playing ${name.split('play')[1]}..."
        } else {
            throw new MissingMethodException(name, Person.class, args)
        }
    }
}

jack = new Person()
println jack.work()
println jack.playTennis()
println jack.playBasketBall()
println jack.playVolleyBall()
println jack.playTennis()

// 重复调用一个不存在的方法，每次处理都会带来同样的性能问题。可以将其注入到MetaClass中缓存下来。看002案例。
try {
    jack.playPolitics()
} catch(Exception ex) {
    println "Error: " + ex
}


package cg.zz.chapter12

// Mixin是一种运行时能力，可以将多个类中的实现引入进来或混入。如果将一个类混入到另一个类中，Groovy会在内存中把这些类的类实例链接起来。
// 当调用一个方法时，Groovy首先将调用路由到混入的类中，如果该方法存在于这个类中，则在此处理。否则由主类处理。
// 可以将多个类混入到一个类中，最后加入的Mixin优先级最高
class Friend {
    def listen() {
        "$name is listening as a friend"
    }
}
// class Person { static { mixin Friend }}

class Teacher {
    def talk() {
        "$name talk to me"
    }
}

//@Mixin(Friend)
@Mixin([Friend, Teacher])
class Human {
    String firstName
    String lastName
    String getName() { "$firstName $lastName" }
}

john = new Human(firstName: "John", lastName: "Smith")
println john.listen()
println john.talk()

// Mixin的语法非常优雅，而且简洁，但是注解本身限制了这种方式只能由类的作者使用。
// 下面是没有源代码也可以实现混入

class Dog {
    String name
}

Dog.mixin Friend

buddy = new Dog(name: "Buddy")
println buddy.listen()

// 也可以选择向一个类的具体实例混入类
class Cat {
    String name
}

try {
    rude = new Cat(name: "Rude")
    rude.listen()
} catch (ex) {
    println ex.message
}

socks = new Cat(name: "Socks")
socks.metaClass.mixin Friend
println socks.listen()

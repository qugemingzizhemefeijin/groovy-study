package cg.zz.chapter01

import groovy.transform.Canonical
import groovy.transform.Immutable

// 使用Groovy代码生成变化

// 排除掉toString中的指定字段值，默认是N个值以够好间隔
@Canonical(excludes = "lastName, age")
class Person {
    String firstName
    String lastName
    int age
}

def sara = new Person(firstName: "Sara", lastName: "Walker", age: 18)
println sara

// 委托，而不是走继承
class Worker {
    def work() { println 'get work done' }

    def analyze() { println 'analyze...' }

    def writeReport() { println 'get report written' }
}

class Expert {
    def analyze() { println "expert analysis..." }
}

// 委托的话，如果类中没有委托的方法，则会被引入，否则将忽略。所以analyze会走Expert的类
class Manager {
    @Delegate Expert expert = new Expert()
    @Delegate Worker worker = new Worker()
}

def bernie = new Manager()
bernie.work()
bernie.writeReport()
bernie.analyze()

// 这个会对类中的方法设置为final类型，并且添加全属性的构造函数，自动添加hashCode，toString，equals方法等
@Immutable
class CreditCard {
    String cardNumber
    int creditNumber
}

println new CreditCard(cardNumber: "100-100-1100", creditNumber: 10)

// 懒加载
class Heavy {
    def size = 10
    Heavy() { println "Creating Heavy with $size" }
}

class AsNeeded {
    def value
    @Lazy Heavy heavy1 = new Heavy()
    @Lazy Heavy heavy2 = new Heavy(size: value)

    AsNeeded() {
        println "Created AsNeeded"
    }
}

def asNeeded = new AsNeeded(value: 1000)
println asNeeded.heavy1.size
println asNeeded.heavy2.size
println asNeeded.heavy1.size
println()

// 简化new语句
@Newify([Person, CreditCard])
def fluentCreate() {
    println Person.new(firstName: "John", lastName: "Doe", age: 30)
    println Person(firstName: "John", lastName: "Doe", age: 20)
    println CreditCard("112-11-1-2-23-222", 2000)
}

fluentCreate()

// 单例，使用 @Singleton 会使目标类的构造器成为私有的
@Singleton(lazy = true)
class TheUnique {

    def hello(){
        print 'hello'
    }
}

println "Accessing TheUnique"
TheUnique.instance.hello()
TheUnique.instance.hello()
println '=============='

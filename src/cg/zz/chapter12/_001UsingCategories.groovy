package cg.zz.chapter12

// Groovy的MOP支持以下3种技术注入行为中的任何一种：
// 分类(category)
// ExpandoMetaClass
// Mixin

// category
class StringUtil {
    def static toSSN(self) { // 如果想将参数限制为String，则使用toSSN(String self)
        if (self.size() == 9) {
            "${self[0..2]}-${self[3..4]}-${self[5..8]}"
        }
    }
}

// 使用use，则在内部调用不会报错。这里注入的方法只会在use中生效。
// 在块内调用String和StringBuilder实例上的toSNN()，会被路由到分类StringUtil中的静态方法。
// toSSN()方法的self参数会被指派在任何对象的实例上，如果想显示的限制该方法仅支持String和StringBuilder，
// 则需要使用显示的参数类型创建两个版本的toSSN()方法。
use(StringUtil) {
    println "123456789".toSSN()
    println new StringBuilder("987654321".toSSN())
}

// 这里就会报错
try {
    println "123456789".toSSN()
} catch (Exception ex) {
    println ex
}

// 这里还可以使用注解实现此功能，@Category会根据我们传入的String参数将新定义的StringUtilAnnotated类的toSSN()转变成
// public static toSSN(String self)
@Category(String)
class StringUtilAnnotated {
    def toSSN() {
        if (size() == 9) {
            "${this[0..2]}-${this[3..4]}-${this[5..8]}"
        }
    }
}
use(StringUtilAnnotated) {
    println "123456789".toSSN()
}

// 可以使用Object来注解，这样子String和StringBuilder都可以调用了
@Category(Object)
class StringUtilAnnotated2 {
    def toSSN() {
        if (size() == 9) {
            "${this[0..2]}-${this[3..4]}-${this[5..8]}"
        }
    }
}

use(StringUtilAnnotated2) {
    println "123456789".toSSN()
    println new StringBuilder("987654321").toSSN()
}

// 注入的方法可以以对象或闭包为参数
class FindUtil {
    def static extractOnly(String self, closure) {
        def result = ''
        self.each {
            if (closure(it)) { result += it }
        }
        result
    }
}

use(FindUtil) {
    println "121254123".extractOnly({it == '4' || it == '5'})
}

// 可以同时使用多个分类，带入多组方法。
// use可以接收由Class实例组成的一个List。 // String == String.class
// use还可以嵌套使用，可以在一个use()调用所使用的闭包内调用另一个use()。内部的分类优先于外部的。
use(StringUtil, FindUtil) {
    str = '123487651'
    println str.toSSN()
    println str.extractOnly({it == '8' || it == '1'})
}

// 还可以使用use来做拦截器
// 分类提供了一个漂亮的注入协议，其效果包含在use()块内的控制流。一旦离开代码块，注入的方法就消失了。
// 限制就是只能在代码块中有效，所以也只限定于执行线程。多次进入和退出这个块是有代价的。
// 每次进入的时候，Groovy都必须检查静态方法，并将其加入到新作用域的一个方法列表中。在退出块还要清理该作用域。
class Helper {
    def static toString(String self) {
        def method = self.metaClass.methods.find { it.name == 'toString' }
        // 这里调用真正的toString方法
        '!!' + method.invoke(self, null) + '!!'
    }
}

use(Helper) {
    println 'hello'.toString()
}

package cg.zz.chapter12

// 当混入多个类时，所有这些类的方法在目标类中都是可用的。默认情况下，方法会因为冲突而被隐藏。
// 换言之，当作为Mixin的两个或多个类中存在名字相同、参数签名也相同的方法时，最后加入到Mixin中的方法会隐藏掉已经注入的方法。

abstract class Writer {
    abstract void write(String message)
}

class StringWriter extends Writer {
    def target = new StringBuilder()

    void write(String message) {
        target.append(message)
    }

    String toString() { target.toString() }
}

def writeStuff(writer) {
    writer.write("This is stupid")
    println writer
}

def create(theWriter, Object[] filters = []) {
    def instance = theWriter.newInstance()
    filters.each { filter -> instance.metaClass.mixin filter }
    instance
}

writeStuff(create(StringWriter))

// writeStuff方法接收一个Writer实例，使用write()方法写入一条有智能的消息，然后打印Writer中保存的内容。
// 对于作为第一个参数提供的Writer的一个具体的派生类，使用create()方法来创建其实例。
// 之后将一个由类组成的可选的列表混入到这个实例中，并返回完成混入的实例。

class UppercaseFilter {

    void write(String message) {
        def allUpper = message.toUpperCase()

        invokeOnPreviousMixin(metaClass, "write", allUpper)
    }
}

// 链条中最左侧的实例的类型就是目标类型，可以使用delegate.getClass()获得。
// 之后遍历保存在mixedIn这个LinkedHashSet中的类的链表，直到找到当前Mixin的前一个Mixin。
// 最后在一个Mixin的上下文中，调用这个Minxin或是位于链表前面的目标实例上的给定方法。
Object.metaClass.invokeOnPreviousMixin = {
    MetaClass currentMixinMetaClass, String method, Object[] args ->
        def previousMixin = delegate.getClass()
        for(mixin in mixedIn.mixinClasses) {
            if(mixin.mixinClass.theClass ==
                    currentMixinMetaClass.delegate.theClass) break
            previousMixin = mixin.mixinClass.theClass
        }
        mixedIn[previousMixin]."$method"(*args)
}

writeStuff(create(StringWriter, UppercaseFilter))

// 去掉脏字
class ProfanityFilter {
    void write(String message) {
        def filtered = message.replaceAll('stupid', 's*****')
        invokeOnPreviousMixin(metaClass, "write", filtered)
    }
}

writeStuff(create (StringWriter, ProfanityFilter))

println "================================="
// 这里可以改变顺序，通过Mixin来实现装饰模式。
writeStuff(create(StringWriter, UppercaseFilter, ProfanityFilter))
writeStuff(create(StringWriter, ProfanityFilter, UppercaseFilter))

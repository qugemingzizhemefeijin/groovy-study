package cg.zz.chapter12

// 如果希望某个实例与其他实例有所不同，可以通过注入实例上的metaClass来实现。

class Person {
    def play() { println "playing..." }
}

// 可以通过创建ExpandoMetaClass，注入增强的方法，并绑定到具体的实例上

def emc = new ExpandoMetaClass(Person)
emc.sing = { ->
    'oh baby baby...'
}
emc.initialize()

def jack = new Person()
def paul = new Person()

jack.metaClass = emc

println jack.sing()

try {
    paul.sing()
} catch (Exception ex) {
    println ex
}

// 如果将去掉增强的方法，只需要讲metaClass设置为null即可
jack.metaClass = null
try {
    jack.play()
    jack.sing()
} catch (ex) {
    println ex
}

// 这里用的ExpandoMetaClass，向其中加入方法以及初始化，其实不必要这么麻烦，看006案例
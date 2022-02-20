package cg.zz.chapter06

list = [1, 2]
list.add(3)
list.add(4)

println list.size()
println list.contains(2)

// with()方法支持创建一个上下文，来简化方法的调用。
lst = [1, 2]
lst.with {
    add(3)
    add(4)
    println size()
    println contains(2)
}

// with()方法是怎么知道闭包内的调用路由到上下文对象的呢？魔力在于该闭包的delegate属性。
// 当我们调用with()方法时，它会将该闭包的delegate属性设置到调用with()的对象上。
lst.with {
    println "this is ${this}"
    println "owner is ${owner}"
    println "delegate is ${delegate}"
}

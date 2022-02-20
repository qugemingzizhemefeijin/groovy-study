package cg.zz.chapter06

// 如果想知道类的实例包含哪些内容，可以在运行时使用dump()
// inspect()方法说明创建一个对象需要提供什么，如果类没有实现该方法，会简单的返回toString()所返回的内容。
str = 'hello'

println str
println str.dump()

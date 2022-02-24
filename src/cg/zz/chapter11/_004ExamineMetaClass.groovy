package cg.zz.chapter11

// 能够使用MetaClass拦截方法调用，是受到了Grails的影响。

Integer.metaClass.invokeMethod = {String name, args -> /* */}
println Integer.metaClass.getClass().name


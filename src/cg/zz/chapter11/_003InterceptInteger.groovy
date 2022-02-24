package cg.zz.chapter11

// 使用MetaClass拦截调用有一个好处，就是可以拦截POJO上的调用。
// 我们可以在MetaClass上同时提供invokeMethod和methodMissing。invokeMethod会优先于methodMissing处理。
// 然而，在调用invokeMissingMethod时，我们其实就是在调用methodMissing来处理不存在的方法。
Integer.metaClass.invokeMethod = {String name, args ->
    System.out.println("Call to $name intercepted on $delegate... ")

    def validMethod = Integer.metaClass.getMetaMethod(name, args)
    if(validMethod == null) {
        Integer.metaClass.invokeMissingMethod(delegate, name, args)
    } else {
        System.out.println("running pre-filter... ")
        result = validMethod.invoke(delegate, args)

        System.out.println("running post-filter...")
        result
    }
}

println 5.floatValue()
println 5.intValue()
try {
    println 5.empty()
} catch(Exception ex) {
    println ex
}
package cg.zz.chapter12

// 一种思路就是把这个闭包保存到一个变量中，然后将其指派给那些类

daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, ((Number)delegate).intValue())
    today.time
}

Long.metaClass.getDaysFromNow = daysFromNow
Integer.metaClass.getDaysFromNow = daysFromNow

println 5.daysFromNow
println 5L.daysFromNow

// 第二种是直接在Integer和Long的基类Number上提供这个方法。
Number.metaClass.someMethod = { ->
    println "someMethod called"
}

2.someMethod()
2L.someMethod()
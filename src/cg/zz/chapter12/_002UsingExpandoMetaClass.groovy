package cg.zz.chapter12

Integer.metaClass.daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate as int)
    today.time
}

println 5.daysFromNow()

// 如果没有括号，Groovy会将方法当成一个属性，所以需要设置一个属性，而非方法。

Integer.metaClass.getDaysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH, delegate as int)
    today.time
}

println 5.daysFromNow

// 既然Integer上已经注入了一个方法，但是与其类似的Short和Long这些类上没有这个方法。该怎么做呢？
// 看003案例

// 知道了如果向类层级结构中注入一个方法后，可能也想把方法引入到一个接口层次的结构中，这样所有实现该接口的类就都可以用到这个方法了。19.11节

// 向类中注入静态方法也是可以的，只需要讲其加入到MetaClass的static属性中
Integer.metaClass.'static'.isEven = { val -> val % 2 == 0 }
println "Is 2 even ? " + Integer.isEven(2)
println "Is 3 even ? " + Integer.isEven(3)

// 通过一个名为constructor的特殊属性可以注入构造器，注意不能使用<<来覆盖现有的构造器和方法。
Integer.metaClass.constructor << { Calendar calendar ->
    new Integer(calendar.get(Calendar.DAY_OF_YEAR))
}

println new Integer(Calendar.instance)

// 如果不是想添加一个新的构造器，而是想替换（严格讲构造器是不可覆盖的）一个原来的，可以使用=操作符代替<<操作符
Integer.metaClass.constructor = { int val ->
    println "Intercepting constructor call"
    constructor = Integer.class.getConstructor(Integer.TYPE)
    constructor.newInstance(val)
}

println new Integer(4)
println new Integer(Calendar.instance)

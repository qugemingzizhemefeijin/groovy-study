package cg.zz.chapter05

// 默认Groovy的Map是LinkedHashMap
langs = ['C++': 'Stroustrup', 'Java': 'Gosling', 'Lisp': 'McCarthy']

println langs.Java.class.name
println langs.getClass().name

println langs['Java']
println langs['C++']

// 这里还可以直接像访问属性的方式来访问键
// 这里有有一个问题，就是不能使用.class.name来访问langs的类信息。因为会被当做键
println langs.Java

// 这里的错误是因为涉及到操作符重载的冲突，看成了获取C键，并对值进行++
try {
    println langs.C++
} catch(ex) {
    println ex
}

// 可以使用这种方式
println langs.'C++'

// 对于规规矩矩的键名，可以省略其引号
langs = ['C++' : 'Stroustrup', Java : 'Gosling', Lisp : 'McCarthy']
println langs
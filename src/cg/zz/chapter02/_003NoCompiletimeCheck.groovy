package cg.zz.chapter02

// 静态类型检查
//@TypeChecked // 如果加上这个注解，则str.toUppercase()将报错
def shout(String str) {
    println "Printing in uppercase"
    println str.toUpperCase()
    println "Printing in uppercase"
    println str.toUppercase() // 这里编译器不会强制指出你的问题，但是运行的时候会报错
}

try {
    shout('Hello')
} catch (ex) {
    println "Failed..."
}

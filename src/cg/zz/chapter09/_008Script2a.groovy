package cg.zz.chapter09

println "In Script2"

name = "Venkat"

// 向 _008Script1a.groovy 脚本传递参数 name
// 可以使用一个Binding实例来绑定变量
shell = new GroovyShell(binding)
result = shell.evaluate(new File("_008Script1a.groovy"))

println "Script1a returned : $result"
println "Hello $name"
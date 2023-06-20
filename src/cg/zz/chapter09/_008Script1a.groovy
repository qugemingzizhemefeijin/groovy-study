package cg.zz.chapter09

// 向脚本中传递参数

println "Hello ${name}"
name = "Dan"

if (binding.hasVariable('xxx')) {
    println "xxx found"
} else {
    println "xxx not found"
}
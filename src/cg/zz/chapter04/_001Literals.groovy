package cg.zz.chapter04

println 'He said, "That is Groovy"'

str = 'A string'
println str.getClass().name

value = 25
println 'The value is ${value}'

str = 'Hello'
println str[2]

// 当尝试修改字符串的时候，会抛出异常
try {
    str[2] = '!'
} catch (Exception ex) {
    println ex
}
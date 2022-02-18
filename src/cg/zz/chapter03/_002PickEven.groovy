package cg.zz.chapter03

// 闭包

def pickEvent(n, block) {
    for (int i = 2; i <= n; i += 2) {
        block(i)
    }
}

pickEvent(10, {println it})
// 还可以这么写
pickEvent(10) { println it }
// 还可以给变量取名字
pickEvent(10) {eventNumber -> println eventNumber}

// 求和
total = 0
pickEvent(10) { total += it }
println "Sum of even numbers from 1 to 10 is ${total}"

// 求乘
product = 1
pickEvent(10) { product *= it }
println "Product of even numbers from 1 to 10 is ${product}"

package cg.zz.chapter18

value = 0

def clear() { value = 0 }

def add(number) {
    value += number
}

def total() {
    println "Total is $value"
}

def getClear() {
    value = 0
}

def getTotal() {
    println "Total is $value"
}

clear()
add 2
add 5
add 7
total()

// Groovy认为对total的调用引用了一个不存在的属性。所以会报错。
// 可以通过编写getTotal()和getClear()方法，实现了名为total和clear的属性。
try {
    total
} catch (Exception ex) {
    pritnln ex
}

println "============================================"
clear
add 2
add 5
add 7
total
clear
total

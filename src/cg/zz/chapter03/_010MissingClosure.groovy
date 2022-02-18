package cg.zz.chapter03

// 动态闭包，如果没有传入闭包的话，可以提供一个默认的实现

def doSomeThing(closure) {
    if (closure) {
        closure()
    } else {
        println "Using default implementation"
    }
}

doSomeThing() {
    println 'Use specialized implementation'
}

// 这里将使用默认的
doSomeThing()

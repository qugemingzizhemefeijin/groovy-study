package cg.zz.chapter03

def iterate(n, closure) {
    1.upto(n) {
        println "In iterate with value ${it}"
        closure(it)
    }
}

println "Calling iterate"
total = 0
// 1 - 4 的 和
iterate(4) {
    total += it
    println "In closure total so far is ${total}"
}
println "Done"

package cg.zz.chapter03

// 闭包的应用

def totalSelectValues(n, closure) {
    total = 0
    for(i in 1..n) {
        if(closure(i)) {
            total += i
        }
    }
    total
}

print "Total of even numbers from 1 to 10 is "
println totalSelectValues(10) { it % 2 == 0 }

// 这里还可以将闭包赋值给变量
def isOdd = { it % 2 != 0}
print "Total of odd numbers from 1 to 10 is "
println totalSelectValues(10, isOdd)

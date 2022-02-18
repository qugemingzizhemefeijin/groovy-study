package cg.zz.chapter03

// 传统的sum
def sum(n) {
    total = 0
    for (int i = 2; i <= n; i += 2) {
        total += i
    }
    total
}

println "Sum of even numbers from 1 to 10 is ${sum(10)}"

def product(n) {
    total = 1
    for (int i = 2; i <= n; i += 2) {
        total *= i
    }
    total
}

println "Product of even numbers from 1 to 10 is ${product(10)}"

def sqr(n) {
    squared = []
    for (int i = 2; i <= n; i += 2) {
        squared << i**2
    }
    squared
}

println "Squares of even numbers from 1 to 10 is ${sqr(10)}"

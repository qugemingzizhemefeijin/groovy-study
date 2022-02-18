package cg.zz.chapter03

// 使用尾递归编写程序，可以避免StackOverflowError

// 这个是会出问题的递归，最后会移除

def factorial(BigInteger number) {
    if (number == 1) 1 else number * factorial(number - 1)
}

try {
    println "factorial of 5 is ${factorial(5)}"
    println "Number of bits in the result is ${factorial(5000).bitCount()}"
} catch (Throwable ex) {
    println "Caught ${ex.class.name}"
}
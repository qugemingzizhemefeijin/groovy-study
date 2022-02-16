package cg.zz.chapter01

// 操作符重载

for (ch = 'a'; ch < 'e'; ch++) {
    print "$ch "
}
println()

for (ch in 'a'..'c') {
    print "$ch "
}
println()

// 默认创建的是ArrayList
lst = ['hello']
lst << 'world'
println lst.join(", ")

// 自定义类的操作符重载
class ComplexNumber {
    def real, imaginary
    def plus(other) {
        new ComplexNumber(real: real + other.real, imaginary: imaginary + other.imaginary)
    }
    String toString() {
        "$real ${imaginary > 0 ? '+' : ''} ${imaginary}i"
    }
}

c1 = new ComplexNumber(real: 1, imaginary: 2)
c2 = new ComplexNumber(real: 2, imaginary: 3)
c3 = c1 + c2
println c3

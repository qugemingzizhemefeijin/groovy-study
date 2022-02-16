package cg.zz.chapter01

class Calibrator {
    Calibrator(calculationBlock) {
        print 'using...'
        calculationBlock()
    }
}
/* 当构造器接口收一个闭包作为参数时，不能直接在构造器上使用花括号。
def calibrator = new Calibrator() {
    println "the calculation provided"
}*/

//可以这么使用
def calibrator = new Calibrator({
    println 'the calculation provided'
})

// 或者这么使用
def calculation = {println 'another calculation provided'}
def calibrator2 = new Calibrator(calculation)

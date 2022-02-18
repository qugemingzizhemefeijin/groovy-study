package cg.zz.chapter03

// 获取传入闭包的参数类型
def examine(closure) {
    println "$closure.maximumNumberOfParameters parameter(s) given:"
    for(aParameter in closure.parameterTypes) {
        println aParameter.name
    }
    println "------------------"
}

// 即时不传入，则默认其实还是有一个it，it的值为空
examine() { }
examine() { it }
// 闭包完全不接受参数
examine() {-> }
examine() { val1 -> }
examine() {Date val1 -> }
examine() {Date val1, val2 -> }
examine() {Date val1, String val2 -> }

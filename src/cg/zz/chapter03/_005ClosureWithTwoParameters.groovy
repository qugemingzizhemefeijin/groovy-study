package cg.zz.chapter03

// 向闭包传递参数

// 对于单参数的闭包，it是该参数的默认名称。如果传入的参数是多个，就需要通过名字一一列出

def tellFortune(closure) {
    closure new Date("09/20/2012"), "Your day is filled with ceremony"
}

tellFortune() { date, fortune ->
    println "Fortune for ${date} is '${fortune}'"
}

// 可以支持可选的指定类型填写，如Date
tellFortune() { Date date, fortune ->
    println "Fortune for ${date} is '${fortune}'"
}

package cg.zz.chapter03

// 科里化闭包，就是给闭包提供预绑定形参

def tellFortunes(closure) {
    Date date = new Date("09/20/2012")
    //closure date, "Your day is filled with ceremony"
    //closure date, "They're features, not bugs"
    // 可以通过科里化避免重复发送date
    postFortune = closure.curry(date)
    postFortune "Your day is filled with ceremony"
    postFortune "They're features, not bugs"

    // 这里也可以直接绑定两个参数，但是调用的时候记得需要填写()
    postFortune2 = closure.curry(date, "aaa")
    postFortune2()
}

// 就是对闭包需要的参数提前绑定上，这样子可以不用每次调用都传递date参数了。。
tellFortunes() { date, fortune ->
    println "Fortune for ${date} is '${fortune}'"
}

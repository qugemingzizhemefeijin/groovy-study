package cg.zz.chapter04

// GString的惰性求值问题

// 这段代码没什么问题。。
what = new StringBuilder('fence')
text = "the cow jumped over the $what"
println text

what.replace(0, 5, "moon")
println text

// 有问题的代码，修改惰性中的变量的值。(如果绑定的对象不可变，那么直接修改引用是无法生效的)，下面的案例
price = 684.71
company = 'Google'
// 这里的两个变量的引用指向的均是不可变的值，所以下面修改的话，不会修改这里的引用
quote = "Today $company stock closed at $price"
println(quote)

stocks = [Apple: 663.01, Microsoft: 30.95]
stocks.each {key, value ->
    company = key
    price = value
    // 注意，这里修改了price,company的引用。
    println(quote)
}

// 解决办法就是让GString重新求值
// 当对一个GString实例求值时，如果其中包含一个变量，该变量的值会被简单的打印到一个Writer，通常是一个StringWriter。
// 然而，如果GString中包含的是一个闭包，而非变量，该闭包就会被调用。
// 如果闭包接收一个参数，GString会把Writer对象当作一个参数发送给它。
// 如果闭包不接收任何参数，GString会简单的调用该闭包，并打印我们想返回给Writer的结果。
// 如果闭包接收的参数不止一个，调用则会失败，并抛出一个异常。

companyClosure = { it.write(company) }
priceClosure = { it.write("$price") }
quote = "Today ${companyClosure} stock closed at ${priceClosure}"
stocks.each{key, value ->
    company = key
    price = value
    println quote
}

// 上面的代码有点啰嗦，还可以如下简写
quote = "Today ${-> company} stock closed at ${-> price}"
stocks.each{key, value ->
    company = key
    price = value
    println quote
}

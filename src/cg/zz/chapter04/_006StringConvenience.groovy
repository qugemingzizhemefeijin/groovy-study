package cg.zz.chapter04

// String的execute()方法可以帮我们创建一个Process对象，只需要几行代码就可以执行系统级进程

// -= 操作符对于操纵字符串很有用，它会将左侧的字符串中与右侧字符串相匹配的部分取消
// Groovy在String类上添加的minus()方法使其成为了可能。
// Groovy还向String类添加了plus(+),multiply(*),next(++),replaceAll()和tokenize()等方法。

str = "It's a rainy day in Seattle"
println str

str -= "rainy "
println str


package cg.zz.chapter06

// 如果想将命令行参数发送给晋城，有两个选择：
// 把参数格式化为一个字符串，或者创建一个参数的String数组。
// String[]也支持execute()方法，数组的第一个元素会被当做要执行的命令，其他元素则被视作该命令的参数。
// 作为替代，可以使用List的execute()方法

String[] command = ['groovy', '-e', '"print \'Groovy\'"']
println "Calling ${command.join(" ")}"
println command.execute().text
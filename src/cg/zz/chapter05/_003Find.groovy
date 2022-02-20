package cg.zz.chapter05

// 查找，find只会查找第一个匹配的元素
lst = [4, 3, 1, 2, 4, 1, 8, 9, 2, 6]

println lst.find { it == 2 }

println lst.find { it > 4 }

println lst.findAll { it == 2 }

println lst.findAll { it > 4 }
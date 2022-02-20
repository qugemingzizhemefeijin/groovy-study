package cg.zz.chapter05

// 迭代
lst = [1, 3, 4, 1, 8, 9, 2, 6]
lst.each { println it }

// 说那个reverseEach反向迭代
total = 0
lst.each { total += it }
println "Total is $total"

// 假设想把集合中的每个元素变为原来的2being
doubled = []
lst.each { doubled << it * 2 }
println doubled

println lst.collect { it * 2 }

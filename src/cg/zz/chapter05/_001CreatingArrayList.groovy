package cg.zz.chapter05

// 使用List

lst = [1, 2, 4, 1, 8, 9, 2, 6]
println lst
println lst.getClass().name
//[1, 2, 4, 1, 8, 9, 2, 6]
//java.util.ArrayList

println lst[0]
println lst[lst.size() - 1]
//1
//6

println lst[-1]
println lst[-2]

println lst[2..5]
println lst[-6..-3]

// 这个会返回一个指向原来列表部分内容的示例。修改了其中一个列表的元素，另一个也会受到影响。
subLst = lst[2..5]
println subLst.dump()
subLst[0] = 55
println "After subLst[0] = 55 lst = $lst"

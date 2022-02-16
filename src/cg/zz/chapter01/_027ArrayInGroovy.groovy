package cg.zz.chapter01

int[] arr = [1, 2, 3, 4, 5]

println arr
println "class is " + arr.getClass().name

// 如果省略int[]，则需要这么定义
def arr2 = [1, 2, 3, 4, 5] as int[]
println arr2
println "class is " + arr.getClass().name

package cg.zz.chapter05

// 假设一个字符串集合，计算其中总的字符数
lst = ['Programming', 'In', 'Groovy']

count = 0
lst.each { count += it.size() }
println count

// 在collect方法返回的集合上调用sum
println lst.collect { it.size() }.sum()

// inject方法也可以实现此功能，inject需要注入一个初始值当参数。然后进行累计计算
println lst.inject(0) {carryOver, element -> carryOver + element.size() }

println lst.join(' ')

lst[0] = ['Be', 'Productive']
println lst

// 通过flatten将lst拉平
lst = lst.flatten()
println lst

// 说那个操作符删除元素
println lst - ['Productive', 'In']

// reverse方法得到列表的一个副本，其中元素是反向排列的
println lst.reverse()
println lst

// 获取每个元素的大小
println lst.size()
// lst*.size()的作用于lst.collect { it.size() }的作用相同
println lst*.size()

// 直接使用List打散传递参数值
def words(a, b, c, d) {
    println "$a $b $c $d"
}
words(*lst)
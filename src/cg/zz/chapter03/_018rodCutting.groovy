package cg.zz.chapter03

import groovy.transform.Immutable

// 使用记忆化改进闭包的性能
// memoize()方法没有限制的使用缓存。
// memoizeAtMost()方法可以限制缓存大小，当到达限制的时候，使用LRU方法淘汰缓存
// memoizeAtLeast()可以设置缓存的下限
// memoizeAtLeastBetween() 可以设置缓存的上下限

// 程序耗时小程序
def timeInt(length, closure) {
    long start = System.nanoTime()
    println "Max revenue for $length is ${closure(length)}"
    long end = System.nanoTime()
    println "Time taken ${(end - start) / 1.0e9} seconds"
}

// 一个棍子，可以分割为1-30英寸的长度。。（0是为了占位数组索引0）。下面的数组代表长度对应的价格
// 这里计算一根27英寸长度的棍子，最佳的销售组合是哪种？
def rodPrices = [0, 1, 3, 4, 5, 8, 9, 11, 12, 14,
                 15, 15, 16, 18, 19, 15, 20, 21, 22, 24,
                 25, 24, 26, 28, 29, 35, 37, 38, 39, 40]
def desiredLength = 27

@Immutable
class RevenueDetails {
    int revenue
    ArrayList splits
}

// 这段代码非常的耗时，大概需要3分钟
def cutRod(prices, length) {
    if(length == 0) {
        return new RevenueDetails(0, [])
    }

    def maxRevenueDetails = new RevenueDetails(Integer.MIN_VALUE, [])
    for(rodSize in 1..length) {
        def revenueFromSecondHalf = cutRod(prices, length - rodSize)
        def potentialRevenue = new RevenueDetails(
                prices[rodSize] + revenueFromSecondHalf.revenue,
                revenueFromSecondHalf.splits + rodSize)
        if(potentialRevenue.revenue > maxRevenueDetails.revenue)
            maxRevenueDetails = potentialRevenue
    }
    maxRevenueDetails
}

//timeInt desiredLength, {length -> cutRod(rodPrices, length)}

// 但是如果使用记忆集的话，1秒不到就计算出结果了
def cutRod
cutRod = {prices, length ->
    if(length == 0) {
        return new RevenueDetails(0, [])
    }
    def maxRevenueDetails = new RevenueDetails(Integer.MIN_VALUE, [])
    for(rodSize in 1..length) {
        def revenueFromSecondHalf = cutRod(prices, length - rodSize)
        def potentialRevenue = new RevenueDetails(
                prices[rodSize] + revenueFromSecondHalf.revenue,
                revenueFromSecondHalf.splits + rodSize
        )
        if(potentialRevenue.revenue > maxRevenueDetails.revenue) {
            maxRevenueDetails = potentialRevenue
        }
    }
    maxRevenueDetails
}.memoize()

timeInt desiredLength, {length -> cutRod(rodPrices, length)}
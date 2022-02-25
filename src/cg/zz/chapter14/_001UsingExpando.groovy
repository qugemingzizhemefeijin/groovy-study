package cg.zz.chapter14

// 使用Expando创建动态类

carA = new Expando()
carB = new Expando(year: 2012, miles: 0)
carA.year = 2012
carA.miles = 10

println "carA: " + carA
println "carB: " + carB

// 不仅可以定义属性，还可以定义方法
car = new Expando(year: 2012, miles: 0, turn: { println 'turning...' })
car.drive = {
    miles += 10
    println "$miles miles diven"
}

car.drive()
car.turn()


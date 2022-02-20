package cg.zz.chapter06


// 如果我们不知道具体的属性名称，可以使用[]操作符来动态的访问属性
class Car {
    int miles, fuelLevel
}

car = new Car(fuelLevel: 80, miles: 25)
properties = ['miles', 'fuelLevel']
// 上面的列表可能通过一些输入来填充
// 或者来自一个Web应用中的动态表单

properties.each { name ->
    println "$name = ${car[name]}"
}

car[properties[1]] = 100

println "fuelLevel now is ${car.fuelLevel}"

package cg.zz.chapter14

data = new File('car.dat').readLines()

props = data[0].split(", ")
data -= data[0]

def averageMilesDrivenPerYear = { miles.toLong() / (2008 - year.toLong()) }

// 这个其实就是动态创建并赋值给对象属性
cars = data.collect {
    car = new Expando()
    it.split(", ").eachWithIndex{ value, index ->
        car[props[index]] = value
    }

    car.ampy = averageMilesDrivenPerYear

    car
}

// 打印第一行title
props.each { name -> print "$name " }
println " Avg. MPY"

// 循环打印每个对象的属性和方法值
ampyMethod = 'ampy'
cars.each { car ->
    for(String property : props) { print "${car[property]} "}
    println car."$ampyMethod"()
}

// 你也可能想通过名字访问属性或方法
car = cars[0]
println "$car.miles $car.year $car.make ${car.ampy()}"

// miles year make  Avg. MPY
// 42451 2003 Acura 8490.2
// 24031 2003 Chevy 4806.2
// 14233 2006 Honda 7116.5
// 42451 2003 Acura 8490.2

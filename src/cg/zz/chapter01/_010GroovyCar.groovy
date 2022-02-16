package cg.zz.chapter01

// javabean
class Car1 {

    def miles = 0
    final year

    Car1(theYear) {
        year = theYear
    }

}

Car1 car = new Car1(2008)

println "Year: $car.year"
println "Miles: $car.miles"
println  'Setting miles'
car.miles = 25
println "Miles: $car.miles"


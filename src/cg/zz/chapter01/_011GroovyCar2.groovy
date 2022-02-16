package cg.zz.chapter01

class Car2 {
    final year
    // 这里给miles定义为private是没有用的
    private miles = 0

    Car2(theYear) { year = theYear }

    def getMiles() {
        println "getMiles called"
        miles
    }

    // 这里可以给set定义private
    private void setMiles(miles) {
        throw new IllegalAccessException("you're not allowed to change miles")
    }

    def drive(dist) { if (dist > 0) miles += dist }
}

def car = new Car2(2012)

println "Year: $car.year"
println "Miles: $car.miles"
println  'Driving'
car.drive(10)
println "Miles: $car.miles"

try {
    print 'Can I set the year? '
    car.year = 1900
} catch(ReadOnlyPropertyException ex) {
    println ex.message
}

try {
    print 'Can I set the miles? '
    car.miles = 12
} catch(IllegalAccessException ex) {
    println ex.message
}

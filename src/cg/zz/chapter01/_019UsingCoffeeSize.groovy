package cg.zz.chapter01

// 枚举使用

enum CoffeeSize {
    SHORT, SMALL, MEDIUM, LARGE, MUG
}

def orderCoffee(size) {
    println "Coffee Order Print size $size"
    switch(size) {
        case [CoffeeSize.SHORT, CoffeeSize.MEDIUM]:
            println "you're health conscious"
            break
        case CoffeeSize.MEDIUM..CoffeeSize.LARGE:
            println "you gotta be a programmer"
            break
        case CoffeeSize.MUG:
            println "you should try Caffeine IV"
            break
    }
}

orderCoffee(CoffeeSize.SMALL)
orderCoffee(CoffeeSize.LARGE)
orderCoffee(CoffeeSize.MUG)
print 'Available sizes are: '
for(size in CoffeeSize.values()) {
    print "$size "
}
println()


enum Methodologies {
    Evo(5),
    XP(21),
    Scrum(30);

    final int daysInIteration

    Methodologies(days) { daysInIteration = days }

    def iterationDetails() {
        println "${this} recommends $daysInIteration days for iteration"
    }
}

for(methodology in Methodologies.values()) {
    methodology.iterationDetails()
}
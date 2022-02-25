package cg.zz.chapter12

class Person2 {
    def play() { println 'playing...' }
}

def jack = new Person2()
def paul = new Person2()

jack.metaClass.sing = { ->
    'oh baby baby...'
}

println jack.sing()

try {
    paul.sing()
} catch (ex) {
    println(ex)
}

jack.metaClass = null
try {
    jack.play()
    jack.sing()
} catch (ex) {
    println ex
}

// 也可以像EMC DSL将方法分组，一次性注入。
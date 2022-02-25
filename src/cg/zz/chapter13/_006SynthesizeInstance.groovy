package cg.zz.chapter13

class Shark {}

// 为具体的实例合成方法，能够在实例的层次合成方法，非常有用。
def emc = new ExpandoMetaClass(Shark)
emc.methodMissing = {String name, args ->
    "I'm Jack of all trades... I can $name"
}
emc.initialize()

def jack = new Shark()
def paul = new Shark()

jack.metaClass = emc

println jack.sing()
println jack.dance()
println jack.juggle()

try {
    paul.sing()
} catch(ex) {
    println ex
}

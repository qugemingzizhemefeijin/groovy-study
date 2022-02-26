package cg.zz.chapter16

import groovy.json.JsonBuilder

class Person {
    String first
    String last
    def sigs
    def tools
}

john = new Person(first: 'John', last: 'Smith', sigs: ['Java', 'Groovy'], tools: ['script' : 'Groovy', 'test' : 'Spock'])
bldr = new JsonBuilder(john)
writer = new StringWriter()
bldr.writeTo(writer)
println writer

println '=============================='

bldr = new JsonBuilder()
bldr {
    firstName john.first
    lastName john.last
    "special interest groups" john.sigs
    "perferred tools" {
        numberOfTools john.tools.size()
        tools john.tools
    }
}

writer = new StringWriter()
bldr.writeTo(writer)
println writer

package cg.zz.chapter09

// java中调用Groovy动态方法，调用CallDynamicMethod.java

class DynamicGroovyClass {
    def methodMissing(String name, args) {
        println "You called $name with ${args.join(', ')}."
        args.size()
    }
}
package cg.zz.chapter01

class A {
    boolean equals(other) {
        println "eauals called"
        false
    }
}

class B implements Comparable {
    boolean equals(other) {
        println "equals called"
        false
    }
    int compareTo(other) {
        println "compareTo called"
        0
    }
}

new A() == new A();
new B() == new B();

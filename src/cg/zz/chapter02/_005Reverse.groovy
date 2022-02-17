package cg.zz.chapter02

import groovy.transform.TypeChecked

@TypeChecked //虽然reverse不是java.lang.String的原生方法，但是这里加上注解则不会报错。
def printInReverse(String str) {
    println str.reverse()
}

printInReverse "Hello"

package cg.zz.chapter02

import groovy.transform.TypeChecked

// 与java相比的优势就是如果使用instanceOf检查类型，在使用该类的特性方法和属性时，不需要执行强制类型转换
@TypeChecked
def use(Object instance) {
    if(instance instanceof String) {
        println instance.length()
    } else {
        println instance
    }
}

use 'hello'
use 100

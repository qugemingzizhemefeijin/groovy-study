package cg.zz.chapter02

import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode

// 这里注解放在类上就是整个类的静态类型检查，还可以在指定的方法上使用 TypeCheckingMode.SKIP 来终止类型检查
@TypeChecked
class Sample{
    def method1(){

    }

    @TypeChecked(TypeCheckingMode.SKIP)
    def method2(String str) {
        str.shout()
    }
}

println "works"

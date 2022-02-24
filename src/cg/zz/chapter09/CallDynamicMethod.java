package cg.zz.chapter09;

import groovy.lang.GroovyObject;

public class CallDynamicMethod {

    public static void main(String[] args) {
        // java中调用Groovy的动态方法
        GroovyObject instance = new DynamicGroovyClass();

        Object result1 = instance.invokeMethod("squeak", new Object[] {});
        System.out.println("Received: " + result1);

        Object result2 = instance.invokeMethod("quack", new Object[] {"like", "a", "duck"});
        System.out.println("Received: " + result2);
    }

}

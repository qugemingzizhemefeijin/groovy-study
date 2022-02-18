package cg.zz.chapter03

// Groovy中闭包方法的查找顺序

class Handler {
    def f1() { println "f1 of Handler called ..."}
    def f2() { println "f2 of Handler called ..."}
}

// 如果修改闭包的delegate属性，如果被用于其他的函数或者多线程，为避免副作用，最好是复制该闭包，在副本上设置delegate，并使用副本。
// def clone = closure.clone()
// clone.delegate = handler
// clone

// 不过新的可以使用handler.with closure 一次性执行上面的三个动作。

class Example {
    def f1() { println "f1 of Example called ..."}
    def f2() { println "f2 of Example called ..."}

    def foo(closure) {
        closure.delegate = new Handler()
        closure()
    }
}

def f1() { println "f1 of Script called..." }

def c = {
    f1()
    f2()
}

new Example().foo(c)

// 输出结果
// f1 of Script called...
// f2 of Handler called ...

package cg.zz.chapter17

import groovy.mock.interceptor.StubFor

class _011TestUsingStubFor extends GroovyTestCase {

    void testMethodB() {
        def testObj = new ClassWithDependency()

        // 在创建StubFor的实例时，首先提供想为其创建存根的类-FileWriter。
        // 之后为write()方法的存根实现创建一个闭包。
        // 在该存根上调用use()方法，此时，它会将FileWriter的MetaClass替换为一个ProxyMetaClass。
        // 在所附的闭包内，对FileWriter实例的任何调用都会被路由到该存根。

        // 然后存根和模拟不会帮助拦截对构造器的调用。FileWriter的构造器被调用了，结果在磁盘上创建了一个名为output.text的文件。
        def fileMock = new StubFor(FileWriter)
        def text

        fileMock.demand.write { text = it.toString() }
        fileMock.demand.close {}

        fileMock.use {
            testObj.methodB(1)
        }

        assertEquals "The value is 1.", text
    }

}

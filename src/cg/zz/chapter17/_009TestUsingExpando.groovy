package cg.zz.chapter17

// 通过创建一个Expando实例，为其提供一个text属性和一个write()方法的模拟实现。
class _009TestUsingExpando extends GroovyTestCase {

    void testMethodA() {
        def fileMock = new Expando(text: '', write: { text = it })

        def testObj = new ClassWithDependency()
        testObj.methodA(1, fileMock)

        assertEquals "The value is 1.", fileMock.text
    }

}

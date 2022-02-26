package cg.zz.chapter17

// 通过Map实现模拟。Map中有键和与键关联的值。其中值可以是对象，甚至可以是闭包。利用这一点，可以使用一个Map来代替协作对象。
class _010TestUsingMap extends GroovyTestCase {

    void testMethodA() {
        def text = ''
        def fileMock = [write: {text = it}]

        def testObj = new ClassWithDependency()
        testObj.methodA(1, fileMock)

        assertEquals "The value is 1.", text
    }

}

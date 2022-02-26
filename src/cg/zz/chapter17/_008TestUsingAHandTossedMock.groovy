package cg.zz.chapter17

// 使用Expando实现模拟
class _008TestUsingAHandTossedMock extends GroovyTestCase {

    void testMethodA() {
        def testObj = new ClassWithDependency()
        def fileMock = new HandTossedFileMock()
        testObj.methodA(1, fileMock)

        assertEquals "The value is 1.", fileMock.result
    }

}

// 这个需要创建一个新的类型，挺麻烦的。。可以不需要创建一个新的类来模拟。通过Expando
class HandTossedFileMock {
    def result
    def write(value) {
        result = value
    }
}
package cg.zz.chapter17

// 使用ExpandoMetaClass 实现模拟
class _007TestUsingExpandoMetaClass extends GroovyTestCase {

    void testMyMethod() {
        def result
        def emc = new ExpandoMetaClass(CodeWithHeavierDependencies, true)
        emc.println = { text -> result = text }
        emc.someAction = { -> 25 }
        emc.initialize()

        def testObj = new CodeWithHeavierDependencies()
        testObj.metaClass = emc

        testObj.myMethod()

        assertEquals 35, result
    }

}

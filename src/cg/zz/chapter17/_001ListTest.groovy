package cg.zz.chapter17

class ListTest extends GroovyTestCase {

    void testListSize() {
        def lst = [1, 2]
        assertEquals "ArrayList size must be 2", 2, lst.size()
    }

}

package cg.zz.chapter17

class CodeWithHeavierDependencies {

    public void myMethod() {
        def value = someAction() + 10
        println value
    }

    int someAction() {
        Thread.sleep(5000) // 模拟消耗时间的动作
        return Math.random() * 100 // 模拟某个动作的结果
    }

}

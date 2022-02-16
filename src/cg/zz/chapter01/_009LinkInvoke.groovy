package cg.zz.chapter01

// 链式调用
class Wizard {

    def static learn(String s) {
        println s
        // 这里其实返回的是 Wizard Class对象
        return this
    }

}

Wizard.learn("alohmora")
.learn("cctv")
.learn("xxy")

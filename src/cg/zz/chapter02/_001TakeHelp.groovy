package cg.zz.chapter02

// 实用动态类型。只要有同样的方法，就可以被调用。而不用关注类型

def takeHelp(helper) {
    helper.helpMoveThings()
}

class Man {
    void helpMoveThings() {
        println "Man's helping"
    }
}

class Woman {
    void helpMoveThings() {
        println "Woman's helping"
    }
}

class Elephant {
    void helpMoveThings() {
        println "Elephant's helping"
    }
    void eatSugarcane() {
        println "I love sugarcanes..."
    }
}

takeHelp(new Man())
takeHelp(new Woman())
takeHelp(new Elephant())

def takeHelpAndReward(helper) {
    helper.helpMoveThings()
    // 这里可以通过respondsTo是否具有eatSugarcane方法，来调用此方法
    if (helper.metaClass.respondsTo(helper, 'eatSugarcane')) {
        helper.eatSugarcane()
    }
}

takeHelpAndReward(new Man())
takeHelpAndReward(new Woman())
takeHelpAndReward(new Elephant())


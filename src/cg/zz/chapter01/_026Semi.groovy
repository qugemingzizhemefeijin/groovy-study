package cg.zz.chapter01

// groovy虽然不需要分号，但是有时候却需要
class Semi {
    def val = 3;
    // 这里会发生错误是因为groovy将实例化器看成闭包了。所以如果将val = 3后面加上分号就可以了
    {
        println "Instance Initializer called..."
    }
}

println new Semi()
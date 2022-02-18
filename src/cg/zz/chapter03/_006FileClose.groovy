package cg.zz.chapter03

// 使用闭包进行资源清理

// writer = new FileWriter('output.txt')
// writer.write('!')
// forgot to call writer.close() 则不会存在输入的字符

new FileWriter('E:/output.txt').withWriter { writer ->
    writer.write('a')
} // no need to close() 内部withWriter自动close了

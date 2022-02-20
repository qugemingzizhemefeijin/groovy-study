package cg.zz.chapter06

// 字符串管道
process = "wc".execute()

process.out.withWriter {
    // 将输入发送到进行
    it << "Let the world know...\n"
    it << 'Groovy Rocks!\n'
}

// 从晋城读取输入
println process.in.text
// 或
// println process.text
package cg.zz.chapter01

// 异常处理

def openFile(fileName) {
    new FileInputStream(fileName)
}

try {
    openFile("nonexistentfile")
} catch(FileNotFoundException ex) {
    println "Oops: " + ex
}

try {
    openFile("nonexistentfile")
} catch(ex) {
    println "Oops: " + ex
}

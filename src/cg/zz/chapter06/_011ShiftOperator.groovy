package cg.zz.chapter06

new File("E:/output.txt").withWriter {file ->
    file << "some data..."
}

println new File("E:/output.txt").text

println "delete ${new File("E:/output.txt").delete()}"
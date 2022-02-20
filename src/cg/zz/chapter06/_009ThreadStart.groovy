package cg.zz.chapter06

// 如果想创建多个线程，并将任务分派给单独的线程执行。Groovy可以让我们少敲代码
def printThreadInfo(msg) {
    def currentThread = Thread.currentThread()
    println "$msg Thread is ${currentThread}. Deamon? ${currentThread.isDaemon()}"
}

printThreadInfo 'Main'

Thread.start {
    printThreadInfo("Started")
    sleep(3000) {
        println "Interrupted"
    }
    println "Finished Started"
}

sleep(1000)

Thread.startDaemon {
    printThreadInfo("Started Deamon")
    sleep(5000) {println "Interrupted"}
    println "Finished Started Deamon"  // 不会执行到这里，因为主线程完成了。。首先线程就自动终止了
}
package cg.zz.chapter06

thread = Thread.start {
    println "Thread started"
    startTime = System.nanoTime()
    new Object().sleep(2000)
    endTime = System.nanoTime()
    println "Thread done in ${(endTime - startTime) / 10 ** 9} seconds"
}

new Object().sleep(100)
println "Let's interrupt that thread"
thread.interrupt()
thread.join()

// start()方法内部抓去了InterruptedException异常。
def playWithSleep(flag) {
    thread = Thread.start {
        println "Thread started"
        startTime = System.nanoTime()
        new Object().sleep(2000) {
            println "Interrupted ..." + it
            flag
        }
        endTime = System.nanoTime()
        println "Thread done in ${(endTime - startTime) / 10 ** 9} seconds"
    }

    thread.interrupt()
    thread.join()
}

// 如果我们在sleep中返回false，则sleep将继续等待指定的时间
playWithSleep(true)
playWithSleep(false)

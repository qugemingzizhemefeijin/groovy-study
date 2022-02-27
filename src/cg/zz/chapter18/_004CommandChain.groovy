package cg.zz.chapter18

// 使用命令链接特性改进流畅性

def (forward, left, then, fast, right) = ['forward', 'left', '', 'fast', 'right']

def move(dir) {
    println "moveing $dir"
    this
}

def and(then) { this }

def turn(dir) {
    println "turning $dir"
    this
}

def jump(speed, dir) {
    println "jumping $speed and $dir"
    this
}

move forward and then turn left
jump fast, forward and then turn right

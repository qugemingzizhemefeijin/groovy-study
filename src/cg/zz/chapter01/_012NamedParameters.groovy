package cg.zz.chapter01

class Robot {

    def type, height, width

    def access(location, weight, fragile) {
        println "Received fragile? $fragile, weight: $weight, loc: $location"
    }

}

// 这里可以主动的指定参数名称来赋值
robot = new Robot(type: 'arm', width: 10, height: 40)
println "$robot.type, $robot.height, $robot.width"

robot.access(x: 30, y: 20, z: 10, 50, true)
//You can change the order
robot.access(50, true, x: 30, y: 20, z: 10)
//混乱
robot.access(50, true,1)

// 这里可以显示的定义Map，避免混乱
def access(Map location, weight, fragile) {
    print "Received fragile? $fragile, weight: $weight, loc: $location"
}

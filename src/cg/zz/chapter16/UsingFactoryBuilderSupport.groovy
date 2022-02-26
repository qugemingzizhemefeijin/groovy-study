package cg.zz.chapter16

class RobotBuilder extends FactoryBuilderSupport {

    {
        registerFactory('robot', new RobotFactory())
        registerFactory('forward', new ForwardMoveFactory())
        registerFactory('left', new LeftTurnFactory())
    }

}

class Robot {
    String name
    def movements = []
    void go() {
        println "Robot $name operating..."
        movements.each { movement -> println movement }
    }
}

class ForwardMove {
    def dist
    String toString() {
        "move distance ... $dist"
    }
}

class LeftTurn {
    def rotation
    String toString() {
        "turn left... $rotation degress"
    }
}

class RobotFactory extends AbstractFactory {
    // 每个工厂的newInstance()方法负责实例化相应节点。
    def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
        new Robot(name: value)
    }

    // 会在父节点的工厂上调用
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        parent.movements << child
    }
}

class ForwardMoveFactory extends AbstractFactory {
    // 默认返回false，说明该节点可以有一个处理子节点的闭包
    boolean isLeaf() { true }
    def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
        new ForwardMove()
    }

    boolean onHandleNodeAttributes(FactoryBuilderSupport builder, Object node, Map attributes) {
        if(attributes.speed && attributes.duration) {
            node.dist = attributes.speed * attributes.duration
            attributes.remove('speed')
            attributes.remove('duration')
        }
        true
    }
}

class LeftTurnFactory extends AbstractFactory {
    boolean isLeaf() { true }

    def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
        new LeftTurn()
    }
}

def bldr = new RobotBuilder()

def robot = bldr.robot('iRobot') {
    forward(dist: 20)
    left(rotation: 90)
    forward(speed: 10, duration: 5)
}

robot.go()

try {
    def robotBldr = new RobotBuilder()
    robotBldr.robot('bRobot') {
        forward(dist: 20) { }
    }
} catch(ex) {
    println ex
}

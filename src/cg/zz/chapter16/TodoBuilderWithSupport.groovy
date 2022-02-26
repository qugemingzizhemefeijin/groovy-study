package cg.zz.chapter16

// 如果要创建的生成器不止一个，可能要将某些方法识别代码重构到一个公共基类中，可以通过BuilderSupport类来实现。
// 因为此类提供了用于识别节点结构的便捷方法。这样就不用亲自编写处理结构的逻辑了。
class TodoBuilderWithSupport extends BuilderSupport {

    int level = 0
    def result = new StringWriter()
    void setParent(parent, child) {}

    def createNode(name) {
        if (name == 'build') {
            result << "To-Do:\n"
            'buildnode'
        } else {
            handle(name, [:])
        }
    }

    def createNode(name, Object value) {
        throw new Exception("Invalid format")
    }

    def createNode(name, Map attribute) {
        handle(name, attribute)
    }

    def createNode(name, Map attribute, Object value) {
        throw new Exception("Invalid format")
    }

    def propertyMissing(String name) {
        handle(name, [:])
        level--
    }

    void nodeCompleted(parent, node) {
        level--
        if (node == 'buildnode') {
            println result
        }
    }

    def handle(String name, attributes) {
        level++
        level.times { result << " "}
        result << placeXifStatusDone(attributes)
        result << name.replaceAll("_", " ")
        result << printParameters(attributes)
        result << "\n"
        name
    }

    def placeXifStatusDone(attributes) {
        attributes['status'] == 'done' ? "x " : "- "
    }

    def printParameters(attributes) {
        def values = ""
        if(attributes.size() > 0) {
            values += " ["
            def count = 0
            attributes.each { key, value ->
                if (key == 'status') return
                count++
                values += (count > 1 ? " " : "")
                values += "${key}: ${value}"
            }
            values += "]"
        }
        values
    }

}

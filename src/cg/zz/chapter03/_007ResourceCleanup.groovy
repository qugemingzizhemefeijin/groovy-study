package cg.zz.chapter03

class Resource {

    def open() { print "opened..." }
    def close() { print "closed" }
    def read() { print "read..." }
    def write() { print "write..." }

    def static use(closure) {
        def r = new Resource()
        try {
            r.open()
            closure(r)
        } finally {
            r.close()
        }
    }

}

// 这里如果直接使用，会造成忘记关闭
def resource = new Resource()
resource.open()
resource.read()
resource.write()
println()

// 使用闭包可以防止忘记关闭
Resource.use { res ->
    res.read()
    res.write()
}
println()
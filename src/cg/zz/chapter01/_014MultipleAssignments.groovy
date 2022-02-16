package cg.zz.chapter01;

// 使用多赋值

def splitName(fullName) { fullName.split(' ') }

// 多赋值
def (firstName, lastName) = splitName('James Bond')
println "$lastName, $firstName $lastName"

println splitName('James Bond').getClass()

// 不使用第三个参数来交换变量值
def name1 = "Thomson"
def name2 = "Thompson"

println "$name1 and $name2"
(name1, name2) = [name2, name1]
println "$name1 and $name2"

// 如果赋值少于，则自动匹配前N个
def (String cat, String mouse) = ['Tom', 'Jerry', 'Spike', 'Tyke']
println "$cat and $mouse"

// 如果赋值多，则多的默认为null
def (first, second, third) = ['Tom', 'Jerry']
println "$first, $second, and $third"

// 这里要注意third会被设置为null
third = 'Tyke'
(first, second, third) = ['Tom', 'Jerry']
println "$first, $second, and $third"

// 如果不能被赋值为null，将抛出异常 org.codehaus.groovy.runtime.typehandling.GroovyCastException
try {
    def (int one, int two) = [1]
} catch(ex) {
    println ex.getClass()
}


package cg.zz.chapter09

// 在_008Script2a.groovy中我们使用了调用脚本的Binding实例，如果希望影响当前的Binding，可以创建一个新的实例

println "In Script3"

binding1 = new Binding()
binding1.setProperty('name', 'Venkat')
shell = new GroovyShell(binding1)
shell.evaluate(new File('_008Script1a.groovy'))

binding2 = new Binding()
binding2.setProperty('name', 'Dan')
// 这里将上一个bind重新修改一下
shell.binding = binding2
shell.evaluate(new File('_008Script1a.groovy'))


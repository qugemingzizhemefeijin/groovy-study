package cg.zz.chapter10

// 可以使用MetaObjectProtocol的getMetaMethod()来获取一个元方法。如果要超找static方法，可以使用GetStaticMetaMethod()。
// 要获得重载方法的列表，可以使用getMetaMethods()额getStaticMetaMethods()。
// 类似的，使用getMetaProperty()和getStaticMetaProperty()可以获得一个元属性。
// 如果只是想检查方法是否存在，可以使用respondsTo()检查方法，使用hasProperty()检查属性是否存在。

// respondsTo返回的是一个匹配的列表，如果用于判断的话，会判断列表>0则为true，否则为false

str = "hello"
methodName = 'toUpperCase'

methodOfInterest = str.metaClass.getMetaMethod(methodName)
println methodOfInterest.invoke(str)

print "Does String respond to toUpperCase()? "
println String.metaClass.respondsTo(str, 'toUpperCase')? 'yes' : 'no'

print "Does String respond to compareTo(String)? "
println String.metaClass.respondsTo(str, 'compareTo', "test")? 'yes' : 'no'

print "Does String respond to toUpperCase(int)? "
println String.metaClass.respondsTo(str, 'toUpperCase', 5)? 'yes' : 'no'

package cg.zz.chapter18

def dslDef = new File('_006GroovyPizzaDSL.groovy').text
def dsl = new File('orderPizza.dsl').text

def script = """
${dslDef}
acceptOrder {
    ${dsl}
}
"""

println script

new GroovyShell().evaluate(script)

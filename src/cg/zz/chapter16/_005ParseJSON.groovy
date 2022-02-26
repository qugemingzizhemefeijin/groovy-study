package cg.zz.chapter16

import groovy.json.JsonSlurper

def sluper = new JsonSlurper()
def person= sluper.parse(new FileReader('person.json'))

println "$person.first $person.last is interested in ${person.sigs.join(', ')}"

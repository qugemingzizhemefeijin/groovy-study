package cg.zz.chapter16

import groovy.xml.MarkupBuilder;

bldr = new MarkupBuilder()
bldr.languages {
    language(name : 'C++') { author('Stroustrup')}
    language(name : 'Java') { author('Gosling')}
    language(name : 'Lisp') { author('McCarthy')}
}
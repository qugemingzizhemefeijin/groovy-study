package cg.zz.chapter16

import groovy.swing.SwingBuilder

import javax.swing.WindowConstants
import java.awt.FlowLayout

bldr = new SwingBuilder()

frame = bldr.frame(
        title: 'Swing',
        size: [50, 100],
        layout: new FlowLayout(),
        defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
) {
    lbl = label(text: 'test')
    btn = button(text: 'Click me', actionPerformed: {
        btn.text = 'Clicked'
        lbl.text = 'Groovy!'
    })
}

frame.show()

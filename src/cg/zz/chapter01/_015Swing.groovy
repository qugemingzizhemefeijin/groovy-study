package cg.zz.chapter01

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.WindowConstants
import java.awt.Button
import java.awt.FlowLayout
import java.awt.event.ActionListener
import java.awt.event.FocusListener
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener

// 接口的实现，这里java实现的比较啰嗦。特别是匿名类

/*import javax.swing.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener;

public class Swing {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        JButton button = new JButton("click");
        frame.getContentPane().add(button);

        // Java code
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(frame, "You clicked!");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
*/

frame = new JFrame(size: [300, 300], layout: new FlowLayout(), defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE)
button = new JButton("click")
positionLabel = new JLabel("")
msgLabel = new JLabel("")

frame.contentPane.add button
frame.contentPane.add positionLabel
frame.contentPane.add msgLabel

// 比java层级的new ActionListener方便多了
button.addActionListener({ JOptionPane.showMessageDialog(frame, "You Clicked~") } as ActionListener)

// 通过as可以指定定义的接口的类型
displayMouseLocation = { positionLabel.setText("$it.x, $it.y") }
frame.addMouseListener(displayMouseLocation as MouseListener)
frame.addMouseMotionListener(displayMouseLocation as MouseMotionListener)

// 这里可以看到不需要定义出所有的实现方法，可以只定义出你关心的那几个方法
handleFocus = [
    focusGained: { msgLabel.setText("Good to see you!") },
    focusLost  : { msgLabel.setText("Come back soon!") }
]

button.addFocusListener(handleFocus as FocusListener)

events = ["WindowListener", "ComponentListener"]
// 这里event可以是动态传入的
handler = { msgLabel.setText("$it") }
for (event in events) {
    // 可以这么实现，太厉害了。。。。
    handlerImpl = handler.asType(Class.forName("java.awt.event.${event}"))
    frame."add${event}"(handlerImpl)
}

frame.setVisible(true)
frame

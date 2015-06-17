/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycalculator;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

/**
 *
 * @author user
 */
public class ScientificCalculator implements ActionListener {

    JFrame frame;
    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;
    JMenuItem menu1Item1, menu1Item2, menu2Item1, menu2Item2;
    BasicCalculator basicCalculator;
    MiddleCalculator contents;

    public ScientificCalculator() {
        basicCalculator=new BasicCalculator();
        contents=new MiddleCalculator();
        frame = new JFrame("Calculator");

        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        menu1 = new JMenu("编辑");
        menu2 = new JMenu("查看");
        menu3 = new JMenu("帮助");
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        menu1Item1 = new JMenuItem("复制");
        menu1Item2 = new JMenuItem("粘贴");

        menu1.add(menu1Item1);
        menu1.add(menu1Item2);

        menu2Item1 = new JMenuItem("标准型");
        menu2Item1.addActionListener(this);
        menu2Item2 = new JMenuItem("科学型");
        menu2Item2.addActionListener(this);

        menu2.add(menu2Item1);
        menu2.add(menu2Item2);


//       contents=new MiddleCalculator();
//        basicCalculator = new BasicCalculator();
        Container container = basicCalculator.go();//rame.getContentPane();
        container.requestFocusInWindow();
        container.setSize(350, 800);
       // frame.setFocusable(true);
        
        frame.getContentPane().add(container);
        frame.getContentPane().setSize(400, 300);
//        frame.setSize(700, 300);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        try {
            String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ScientificCalculator calculator = new ScientificCalculator();

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("科学型")) {
//            contents = new MiddleCalculator();
            Container container = contents.go();//rame.getContentPane();
            frame.getContentPane().removeAll();
            container.setSize(700, 300);
            frame.getContentPane().add(container);
            frame.pack();
            frame.validate();
        } else if (e.getActionCommand().equals("标准型")) {
//            basicCalculator = new BasicCalculator();
            Container container = basicCalculator.go();//rame.getContentPane();
            frame.getContentPane().removeAll();
            frame.getContentPane().add(container);
            System.out.println("标准型");
            frame.pack();
            frame.validate();
        }

    }
}

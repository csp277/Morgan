package mycalculator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
/**
 *
 * @author Administrator
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class BasicCalculator implements ActionListener, KeyListener{

    /**
     * @param args the command line arguments
     */
    JFrame frame;
    Container container;
//    JButton addBn,divBn,subBn,timesBn,dotBn,flagBn,equalBn,sinBn,backBn,clearBn;//非数字按钮共计10个
//    JButton Bn0,Bn1,Bn2,Bn3,Bn4,Bn5,Bn6,Bn7,Bn8,Bn9;//数字按钮共计十个
    final int length = 20;
    JFileChooser fc;
    JButton[] Bn = new JButton[length];
    JPanel panel1, panel2, panel3, panel4;
    JTextField textField1;
    JTextArea textArea;
    JButton saveBn, copyBn, clearTextBn;
    String operation = "", temp = "";
    String operand1, operand2, operand3;
    boolean flag = true;
    int oper1 = 0, oper2 = 0, oper3 = 0;//当输入为整型
    double doper1 = 0.0, doper2 = 0.0, doper3 = 0.0;//当输入为浮点型
    Clipboard clipboard;

    public Container go() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        frame = new JFrame();
        container = frame.getContentPane();
        container.setLayout(new GridLayout(1, 2, 5, 0));
        panel1 = new JPanel();//网格左边的整体
        panel3 = new JPanel();//左边面板的按键面板
//        panel3.setFocusable(true);
//        panel3.requestFocus();
        panel1.setLayout(new BorderLayout());


        textField1 = new JTextField();
        textField1.addKeyListener(this);
//        textField1.addFocusListener(this);
//        textField1.requestFocus();
        textField1.requestFocusInWindow();
        textField1.setHorizontalAlignment(JTextField.RIGHT);
        panel1.add(textField1, BorderLayout.NORTH);
//        panel1.setVisible(false);


        //设计网格布局，并且初始化网格上的每个按钮
        panel3.setLayout(new GridLayout(4, 5));
        Bn[0] = new JButton("1");
        Bn[0].addKeyListener(this);
        Bn[0].setActionCommand("digit");
        Bn[1] = new JButton("2");
        Bn[1].setActionCommand("digit");
        Bn[2] = new JButton("3");
        Bn[2].setActionCommand("digit");
        Bn[3] = new JButton("+");
        Bn[3].addKeyListener(this);
        Bn[3].setActionCommand("operation");
        Bn[4] = new JButton("C");
        Bn[5] = new JButton("4");
        Bn[5].setActionCommand("digit");
        Bn[6] = new JButton("5");
        Bn[6].setActionCommand("digit");
        Bn[7] = new JButton("6");
        Bn[7].setActionCommand("digit");
        Bn[8] = new JButton("-");
        Bn[8].setActionCommand("operation");
        Bn[9] = new JButton("退格");
        Bn[9].setActionCommand("back");
        Bn[10] = new JButton("7");
        Bn[10].setActionCommand("digit");
        Bn[11] = new JButton("8");
        Bn[11].setActionCommand("digit");
        Bn[12] = new JButton("9");
        Bn[12].setActionCommand("digit");
        Bn[13] = new JButton("*");
        Bn[13].setActionCommand("operation");
        Bn[14] = new JButton("%");
        Bn[15] = new JButton("0");
        Bn[15].setActionCommand("digit");
        Bn[16] = new JButton("+/-");
        Bn[17] = new JButton(".");
        Bn[18] = new JButton("/");
        Bn[18].setActionCommand("operation");
        Bn[19] = new JButton("=");
        for (JButton jButton : Bn) {
            jButton.addActionListener(this);
            jButton.addKeyListener(this);
            panel3.add(jButton);
        }


        panel1.add(panel3, BorderLayout.CENTER);
        container.add(panel1);
        container.setSize(700, 500);
        //  frame.setFocusable(true);
        return container;
    }

    public void keyPressed(KeyEvent e) {
//        System.out.println("key click!");
        char key = e.getKeyChar();
        System.out.println(key);
        switch (key) {
            case '1':
                 {
                    Bn[0].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '2':
                 {
                    Bn[1].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '3':
                 {
                    Bn[2].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '4':
                 {
                    Bn[5].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '5':
                 {
                    Bn[6].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '6':
                 {
                    Bn[7].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '7':
                 {
                    Bn[10].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '8':
                 {
                    Bn[11].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '9':
                 {
                    Bn[12].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '0':
                 {
                    Bn[15].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            case '+':
                 {
                    Bn[3].doClick();
                }
                break;
            case '-':
                 {
                    Bn[8].doClick();
                }
                break;
            case '*':
                 {
                    Bn[13].doClick();
                }
                break;
            case '/':
                 {
                    Bn[18].doClick();
                }
                break;
            case '.':
                 {
                    Bn[17].doClick();
                    String text1 = textField1.getText();
                    textField1.setText(text1.substring(0, text1.length() - 1));
                }
                break;
            default:
                 {
                    Bn[19].doClick();
                }
                break;
        }


    }

//    @Override
    public void actionPerformed(ActionEvent e) {

       
        char branch = e.getActionCommand().charAt(0);
        switch (branch) {
            case '%':
                 {
                    if (temp.equals("digit")) {
                        operand1 = textField1.getText();

                        doper1 = Double.parseDouble(operand1);
                        doper3 = doper1 * 0.01;
                        textField1.setText(String.valueOf(doper3));
                    }
                }
                break;
            case 'b':
                 {
                    String text1 = textField1.getText();
                    if (text1.length() > 0) {
                        textField1.setText(text1.substring(0, text1.length() - 1));
                    }
                }
                break;
            case '.':
                 {
                    if (textField1.getText().indexOf(".") != -1) {
                        break;
                    } else {
                        textField1.setText(textField1.getText() + ".");
                    }
                }
                break;
            case '+':
                 {
                    String temp1 = textField1.getText();
                    char negetive = textField1.getText().charAt(0);
                    if (negetive == '-') {
                        textField1.setText(temp1.substring(1, temp1.length()));
                    } else {
                        textField1.setText("-" + temp1);
                    }
                }
                break;
            case 'd':
                 {//当按下的JButton是数字
                    System.out.println("button0 click");
                    if (temp.equals("digit")) {
                        textField1.setText(textField1.getText() + ((JButton) e.getSource()).getText());
                    } else {
                        textField1.setText(((JButton) e.getSource()).getText());
                    }
                    temp = "digit";
                }
                break;
            case 'o':
                 {//当按下的JButton是+、-、*、/
                    if (temp.equals("operation")) {
                        break;
                    } else {
                        operation = ((JButton) e.getSource()).getText();
                        operand1 = textField1.getText();
                        //将textFeild1中的数赋给operand1
                        if (operand1.indexOf(".") == -1) {//字符串中不含小数点，operand1为整型
                            oper1 = Integer.parseInt(operand1);
                            doper1 = (double) oper1;
                        } else {
                            doper1 = Double.parseDouble(operand1);
                        }
                    }
                    temp = "operation";
                }
                break;
            case 'C':
                 {
                    oper1 = 0;
                    doper1 = 0;
                    oper2 = 0;
                    doper2 = 0;
                    textField1.setText("");
                    textField1.requestFocus(true);
                }
                break;
            case '=':
                 {
                    boolean flagOfpoint = false;
                    operand2 = textField1.getText();
                    char oper = operation.charAt(0);
                    if (operand2.indexOf(".") == -1 && operand1.indexOf(".") == -1) {//字符串中不含小数点，operand2为整型
                        oper2 = Integer.parseInt(operand2);
                        switch (oper) {
                            case '+':
                                oper3 = oper1 + oper2;
                                break;
                            case '-':
                                oper3 = oper1 - oper2;
                                break;
                            case '*':
                                oper3 = oper1 * oper2;
                                break;
                            case '/':
                                if (oper2 == 0) {
                                    operand3 = "除数不为零！";
                                } else //                                operand3=String.valueOf((1.0*oper1/oper2)>(oper1/oper2) ? (1.0*oper1/oper2):(oper1/oper2));
                                if ((1.0 * oper1 / oper2) > (oper1 / oper2)) {
                                    operand3 = String.valueOf(1.0 * oper1 / oper2);
                                } else {
                                    operand3 = String.valueOf(oper1 / oper2);
                                }
                                break;
                        }
                    } else {
                        flagOfpoint = true;
                        doper2 = Double.parseDouble(operand2);
                        switch (oper) {
                            case '+':
                                doper3 = doper1 + doper2;
                                break;
                            case '-':
                                doper3 = doper1 - doper2;
                                break;
                            case '*':
                                doper3 = doper1 * doper2;
                                break;
                            case '/':
                                doper3 = doper1 / doper2;
                                break;
                        }
                    }
                    if (flagOfpoint) {//计算结果为浮点数
                        textField1.setText(String.valueOf(doper3));


                    } else if (oper != '/') {//整型 去掉 除数的情况
                        textField1.setText(String.valueOf(oper3));
                    } else {
                        textField1.setText(operand3);
                    }
                    temp = "=";
                }
                break;
        }
         
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

//    public void focusGained(FocusEvent e) {
////        TextField text = (TextField) e.getSource();
////        text.setText(null);
//    }

    public void focusLost(FocusEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
}









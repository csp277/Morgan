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
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MiddleCalculator implements ActionListener, ClipboardOwner {

    /**
     * @param args the command line arguments
     */
    JFrame frame;
    Container container;
//    JButton addBn,divBn,subBn,timesBn,dotBn,flagBn,equalBn,sinBn,backBn,clearBn;//非数字按钮共计10个
//    JButton Bn0,Bn1,Bn2,Bn3,Bn4,Bn5,Bn6,Bn7,Bn8,Bn9;//数字按钮共计十个
    final int length = 20;
    JFileChooser fc;
    JScrollPane js;
    JButton[] Bn = new JButton[length];
    JPanel panel1, panel2, panel3, panel4;
    JTextField textField1, textField2;
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
        panel2 = new JPanel();//网格右边的整体
        panel3 = new JPanel();//左边面板的按键面板
        panel4 = new JPanel();//右边面板的 按键面板
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());


        textField1 = new JTextField();
        textField1.setHorizontalAlignment(JTextField.RIGHT);
        panel1.add(textField1, BorderLayout.NORTH);
        textField2 = new JTextField();
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.setBackground(Color.yellow);
        textArea = new JTextArea();
        textArea.setLineWrap(true);        //激活自动换行功能
//        textArea.setWrapStyleWord(true);
        saveBn = new JButton("保存");
//        panel1.setVisible(false);
        saveBn.addActionListener(new ActionListener() {

//            @Override
            public void actionPerformed(ActionEvent e) {
                fc = new JFileChooser();
                int select = fc.showSaveDialog(frame);
                if (select == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    String StextArea = textArea.getText();
                    //方法二，用时间戳转化
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
                    StextArea += df.format(new Date());
                    try {
                        FileOutputStream out = new FileOutputStream(file.getPath());
                        OutputStreamWriter osw = new OutputStreamWriter(out);
                        BufferedWriter bw = new BufferedWriter(osw);
                        System.out.println(StextArea);
                        bw.write(StextArea);
                        bw.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MiddleCalculator.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MiddleCalculator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        copyBn = new JButton("复制");
        copyBn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                StringSelection contents = new StringSelection(textArea.getText());
                clipboard.setContents(contents, MiddleCalculator.this);
            }
        });
        clearTextBn = new JButton("清除");
        clearTextBn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        panel4.add(saveBn);
        panel4.add(copyBn);
        panel4.add(clearTextBn);
        panel2.add(textField2, BorderLayout.NORTH);
        js=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        panel2.add(js, BorderLayout.CENTER);
        panel2.add(panel4, BorderLayout.SOUTH);


        //设计网格布局，并且初始化网格上的每个按钮
        panel3.setLayout(new GridLayout(4, 5));
        Bn[0] = new JButton("1");
        Bn[0].setActionCommand("digit");
        Bn[1] = new JButton("2");
        Bn[1].setActionCommand("digit");
        Bn[2] = new JButton("3");
        Bn[2].setActionCommand("digit");
        Bn[3] = new JButton("+");
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
        Bn[14] = new JButton("SIN");
        Bn[15] = new JButton("0");
        Bn[15].setActionCommand("digit");
        Bn[16] = new JButton("+/-");
        Bn[17] = new JButton(".");
        Bn[18] = new JButton("/");
        Bn[18].setActionCommand("operation");
        Bn[19] = new JButton("=");
        for (JButton jButton : Bn) {
            jButton.addActionListener(this);
            panel3.add(jButton);
        }


        panel1.add(panel3, BorderLayout.CENTER);
        container.add(panel1);
        container.add(panel2);
//        System.out.println(container.getSize());
//                frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(700, 300);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
        container.setSize(700, 500);
        return container;
    }

//    public static void main(String[] args) {
//        // TODO code application logic here
//
//        new MiddleCalculator();
//    }
//    @Override
    public void actionPerformed(ActionEvent e) {


        char branch = e.getActionCommand().charAt(0);
        switch (branch) {
            case 'S': {
                operand1 = textField1.getText();
                doper1 = Double.parseDouble(operand1);
                if (temp.equals("digit")) {
                    doper3 =Math.sin(doper1*Math.PI/180);
                    textField1.setText(String.valueOf(doper3));
//                    temp="SIN";
                    }

            }
            break;
            case 'b': {
                String text1 = textField1.getText();
                String text2 = textField2.getText();
                if (text1.length() > 0 && text2.length() > 0) {
                    textField1.setText(text1.substring(0, text1.length() - 1));
                    textField2.setText(text2.substring(0, text2.length() - 1));
                }
            }
            break;
            case '.': {
                if (textField1.getText().indexOf(".") != -1) {
                    break;
                } else {
                    textField1.setText(textField1.getText() + ".");
                    textField2.setText(textField2.getText() + ".");
                }
            }
            break;
            case '+': {
                String temp1 = textField1.getText();
                String temp2 = textField2.getText();
                char negetive = textField1.getText().charAt(0);
                int position = textField2.getText().indexOf(operation);
                if (negetive == '-') {
                    textField1.setText(temp1.substring(1, temp1.length()));
                    textField2.setText(temp2.substring(0, position + 1) + textField1.getText());
                } else {
                    textField1.setText("-" + temp1);
                    textField2.setText(temp2.substring(0, position + 1) + "(" + textField1.getText() + ")");
                }
            }
            break;
            case 'd': {//当按下的JButton是数字
                if (temp.equals("digit")) {
//                double number = Double.parseDouble(textField1.getText());
//                int unit = Integer.parseInt(((JButton) e.getSource()).getText());
//                number = number * 10 + unit;
                    textField1.setText(textField1.getText() + ((JButton) e.getSource()).getText());
                    textField2.setText(textField2.getText() + ((JButton) e.getSource()).getText());
                } else {
                    textField1.setText(((JButton) e.getSource()).getText());
                    if (temp.equals("=")) {
                        textField2.setText(((JButton) e.getSource()).getText());
                    } else {
                        textField2.setText(textField2.getText() + ((JButton) e.getSource()).getText());
                    }
                }
                temp = "digit";
            }
            break;
            case 'o': {//当按下的JButton是+、-、*、/
                if (temp.equals("operation")) {
                    break;
                } else {
                    operation = ((JButton) e.getSource()).getText();
                    operand1 = textField1.getText();
                    textField2.setText(textField2.getText() + operation);
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
            case 'C': {
                oper1 = 0;
                doper1 = 0;
                oper2 = 0;
                doper2 = 0;
                textField1.setText("");
                textField2.setText("");
            }
            break;
            case '=': {
                boolean flagOfpoint = false;
                textField2.setText(textField2.getText() + e.getActionCommand());
                //先将operand2取出
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
                    textField2.setText(textField2.getText() + String.valueOf(doper3));


                } else if (oper != '/') {//整型 去掉 除数的情况
                    textField1.setText(String.valueOf(oper3));
                    textField2.setText(textField2.getText() + String.valueOf(oper3));
                } else {
                    textField1.setText(operand3);
                    textField2.setText(textField2.getText() + operand3);
                }
                textArea.append(textField2.getText());
                textArea.append("\r\n");
                temp = "=";
            }
            break;
        }
    }

    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}









package edu.city.software.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autor：张天治
 * @time:2019/4/23 下午 13:28
 * @desc：三角形等价类划分
 */
public class TriangleGUI extends JFrame implements ActionListener {
    private JPanel p;
    private JLabel lableA,lableB,lableC;
    private JTextField textFieldA,textFieldB,textFieldC;
    private JButton enter,cancel;
    private long intA,intB,intC;

    private TriangleGUI(){
        super("三角形等价类划分");
        init();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置大窗口尺寸
        this.setSize(420,350);
        //设置面板
        this.getContentPane().add(p);
        //设置布局
        p.setLayout(null);
        //设置出现窗口在屏幕最中间
        this.setLocationRelativeTo(null);
        //设置窗口不能再最大化或者最小化
        this.setResizable(false);
        //添加组件
        p.add(lableA);p.add(textFieldA);
        p.add(lableB);p.add(textFieldB);
        p.add(lableC);p.add(textFieldC);
        p.add(enter);p.add(cancel);
        this.setVisible(true);
    }

    private void init(){
        Font f1 = new Font("微软雅黑", Font.PLAIN, 18);
        Font f2 = new Font("微软雅黑", Font.PLAIN, 17);
        /*组件*/
        p = new JPanel();
        lableA = new JLabel("边长 a：", JLabel.CENTER);
        textFieldA = new JTextField(7);
        lableA.setBounds(35,40,140,40);
        lableA.setFont(f1);
        textFieldA.setBounds(175,41,165,40);

        lableB = new JLabel("边长 b：", JLabel.CENTER);
        textFieldB = new JTextField(7);
        lableB.setBounds(35,100,140,40);
        lableB.setFont(f1);
        textFieldB.setBounds(175,100,165,40);

        lableC = new JLabel("边长 c：", JLabel.CENTER);
        textFieldC = new JTextField(7);
        lableC.setBounds(35,160,140,40);
        lableC.setFont(f1);
        textFieldC.setBounds(175,160,165,40);

        enter = new JButton("测试");
        cancel = new JButton("清空");
        enter.setFont(f2);
        enter.setBounds(105,240,80,30);
        enter.setContentAreaFilled(false);
        cancel.setFont(f2);
        cancel.setBounds(225,240,80,30);
        cancel.setContentAreaFilled(false);
        enter.addActionListener(this);
        cancel.addActionListener(this);
    }

    //清空
    private void clean(){
        textFieldA.setText("");
        textFieldB.setText("");
        textFieldC.setText("");
    }

    //监听
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel) {
            clean();
        }else if(e.getSource()==enter){
            String strA = textFieldA.getText();
            String strB = textFieldB.getText();
            String strC = textFieldC.getText();
            showResult(strA, strB, strC);
        }
    }
    //正则
    private Pattern pattern = Pattern.compile("[0-9]{0,7}");
    //三边是否为数字
    private boolean isNumvber(String strA, String strB, String strC){
        if(pattern.matcher(strA).matches()&&pattern.matcher(strB).matches()&&pattern.matcher(strC).matches()){
            intA = Long.valueOf(strA);
            intB = Long.valueOf(strB);
            intC = Long.valueOf(strC);
            return true;
        }else{
            return false;
        }
    }

    /* check if Triangle is valid 是否是三角形*/
    private boolean isValidTriangle() {
        return this.intA + this.intB > this.intC && this.intA + this.intC > this.intB && this.intB + this.intC >= this.intA;
    }
    /* check if it's regular triangle 等边三角形*/
    private boolean isRegularTriangle() {
        return this.intA == this.intB && this.intB == this.intC;
    }

    /* check if it's isosceles triangle 等腰三角形*/
    private boolean isIsoscelesTriangle() {
        return this.intA == this.intB || this.intB == this.intC || this.intC == this.intA;
    }


    /* check if it's right triangle 直角三角形*/
    private boolean isRightTriangle() {
        return Math.pow(this.intA,2) + Math.pow(this.intB,2) == Math.pow(this.intC,2) || Math.pow(this.intA,2) + Math.pow(this.intC,2) == Math.pow(this.intB,2) && Math.pow(this.intB,2) + Math.pow(this.intC,2) == Math.pow(this.intA,2);
    }

    //结果
    private void showResult(String strA,String strB,String strC) {
        if(!"".equals(strA)||!"".equals(strB)||!"".equals(strC)){
            if(isNumvber(strA,strB,strC)){
                if(isValidTriangle()){
                    if(isRegularTriangle()){
                        JOptionPane.showMessageDialog(this,"<html><font color='black',size='4'>等边三角形！</html>");
                    }else if(isIsoscelesTriangle()){
                        JOptionPane.showMessageDialog(this,"<html><font color='black',size='4'>等腰三角形！</html>");
                    }else if(isRightTriangle()){
                        JOptionPane.showMessageDialog(this,"<html><font color='black',size='4'>直角三角形！</html>");
                    }else {
                        JOptionPane.showMessageDialog(this,"<html><font color='black',size='4'>一般三角形！</html>");
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"<html><font color='red',size='4'>不构成三角形！</html>");
                }
            }else{
                JOptionPane.showMessageDialog(this,"<html><font color='blue',size='4'>三角形各边应为 [1,7] 位正整数！</html>");
            }
        }else{
            //输入框为空
            JOptionPane.showMessageDialog(this,"<html><font color='red',size='4'>请完整输入三角形三边！</html>");
        }
    }

    public static void main(String[] args) {
        new TriangleGUI();
    }
}

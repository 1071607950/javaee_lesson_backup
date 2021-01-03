package edu.city.software.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @autor：张天治
 * @time:2019/4/29 下午 8:16
 * @desc：实验四、因果图之自动售货机软件测试用例
 */

public class VendingMachineGUI extends JFrame implements ActionListener {
    private JPanel p;
    private JLabel title;
    private JLabel tip;
    private JLabel drink;
    private JRadioButton coke,sprite,bohea;
    private JButton unitary, corners;
    private static double sum = 0;
    private boolean revoke = false;
    private VendingMachineGUI() {
        super("因果图之自动售货机软件测试用例");
        init();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置大窗口尺寸
        this.setSize(500, 300);
        //设置面板
        this.getContentPane().add(p);
        //设置布局
        p.setLayout(null);
        //设置出现窗口在屏幕最中间
        this.setLocationRelativeTo(null);
        //设置窗口不能再最大化或者最小化
        this.setResizable(false);
        //添加组件
        p.add(title);p.add(tip);
        p.add(drink);
        p.add(coke);p.add(sprite);p.add(bohea);
        p.add(unitary);p.add(corners);
        this.setVisible(true);
    }

    private void init() {

        Font f1 = new Font("微软雅黑", Font.PLAIN, 18);
        Font f2 = new Font("微软雅黑", Font.PLAIN, 20);
        Font f3 = new Font("微软雅黑", Font.PLAIN, 23);
        Font f4 = new Font("微软雅黑", Font.PLAIN, 14);
        /*组件*/
        p = new JPanel();

        title = new JLabel("自动售货机货币余额 " + sum + " 元", JLabel.CENTER);
        title.setBounds(100, 10, 300, 40);
        title.setFont(f3);
        tip = new JLabel("所有饮料的单价均为0.5元", JLabel.CENTER);
        tip.setBounds(100, 45, 300, 40);
        tip.setFont(f4);
        drink = new JLabel("请选择饮料：", JLabel.CENTER);
        drink.setBounds(65, 80, 140, 40);
        drink.setFont(f1);
        ButtonGroup buttonGroup = new ButtonGroup();

        coke = new JRadioButton(" 可乐");
        coke.setBounds(195,80,70,40);
        coke.setFont(f1);
        coke.setSelected(true);

        sprite = new JRadioButton(" 雪碧");
        sprite.setBounds(275,80,70,40);
        sprite.setFont(f1);

        bohea = new JRadioButton(" 红茶");
        bohea.setBounds(355,80,70,40);
        bohea.setFont(f1);
        buttonGroup.add(coke);
        buttonGroup.add(sprite);
        buttonGroup.add(bohea);
        unitary = new JButton("投入 1 元购买");
        corners = new JButton("投入 5 角购买");
        unitary.setFont(f2);
        unitary.setBounds(170, 140, 160, 30);
        unitary.setContentAreaFilled(false);
        corners.setFont(f2);
        corners.setBounds(170, 190, 160, 30);
        corners.setContentAreaFilled(false);
        unitary.addActionListener(this);
        corners.addActionListener(this);
    }
    /*判断单选按钮*/
    private String getDrink() {
        if(coke.isSelected()){
            return "可乐";
        } else if(sprite.isSelected()){
            return "雪碧";
        }else{
            return "红茶";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String drink = getDrink();
        if (e.getSource() == unitary) {
            if(!revoke){
                sum = sum + 1;
                if(sum % 1 == 0.5){
                    sum = sum - 0.5;
                    showMessageDialog(this, "<html><font color='blue',size='4' >"+drink+" 购买成功，投入 1 元，找零 0.5 元，欢迎再次使用！");
                }else{
                    showMessageDialog(this, "<html><font color='red',size='4' >自动售货机无法找零，请重新投入 1 元用于回退操作！");
                    revoke = true;
                    corners.setVisible(false);
                    unitary.setText("投入 1 元回退");
                    unitary.setBounds(170, 170, 160, 30);
                }
            }else{
                sum = sum - 1;
                showMessageDialog(this, "<html><font color='red',size='4' >回退 1 元成功！");
                corners.setVisible(true);
                unitary.setBounds(170, 140, 160, 30);
                unitary.setText("投入 1 元购买");
                revoke = false;
            }

        } else if (e.getSource() == corners) {
            sum = sum + 0.5;
            showMessageDialog(this, "<html><font color='blue',size='4' >"+drink+" 购买成功，投入 5 脚，无需找零，欢迎再次使用！");
        }
        title.setText("自动售货机货币余额 " + sum + " 元");
    }

    public static void main(String[] args) {
        new VendingMachineGUI();
    }
}



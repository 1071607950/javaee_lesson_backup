package edu.city.software.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @autor：张天治
 * @time:2019/4/29 下午 6:40
 * @desc：实验三、决策表分析
 */
public class BestArrangementGUI extends JFrame implements ActionListener {

    private JPanel p;
    /*姓名，年龄，性别，学历*/
    private JLabel name,age,gender,education;
    private JTextField tname,tage;
    private ButtonGroup bgender;
    private JRadioButton man,woman;
    private JButton enter,cancel;
    private JComboBox<String> ceducation;
    private String []educations={"小学文化","中学文化","大学文化"};
    private Pattern pattern = Pattern.compile("[0-9]{0,2}");
    private BestArrangementGUI(){
        super("决策表分析");
        init();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置大窗口尺寸
        this.setSize(420,400);
        //设置面板
        this.getContentPane().add(p);
        //设置布局
        p.setLayout(null);
        //设置出现窗口在屏幕最中间
        this.setLocationRelativeTo(null);
        //设置窗口不能再最大化或者最小化
        this.setResizable(false);
        //添加组件
        bgender.add(man);
        bgender.add(woman);
        p.add(name);p.add(tname);
        p.add(age);p.add(tage);
        p.add(gender);
        p.add(man);p.add(woman);
        p.add(education);p.add(ceducation);
        p.add(enter);p.add(cancel);
        this.setVisible(true);
    }

    private void init(){
        Font f1 = new Font("微软雅黑", Font.PLAIN, 18);
        Font f2 = new Font("微软雅黑", Font.PLAIN, 17);
        /*组件*/
        p = new JPanel();
        name = new JLabel("姓名：", JLabel.CENTER);
        tname = new JTextField(7);
        name.setBounds(35,40,140,40);
        name.setFont(f1);
        tname.setBounds(175,41,165,40);

        age = new JLabel("年龄：", JLabel.CENTER);
        tage = new JTextField(7);
        age.setBounds(35,100,140,40);
        age.setFont(f1);
        tage.setBounds(175,100,165,40);

        gender = new JLabel("性别：", JLabel.CENTER);
        gender.setBounds(35,160,140,40);
        gender.setFont(f1);
        bgender= new ButtonGroup();
        man = new JRadioButton(" 男");
        man.setBounds(175,160,70,40);
        man.setFont(f1);
        man.setSelected(true);
        woman = new JRadioButton(" 女");
        woman.setBounds(255,160,70,40);
        woman.setFont(f1);

        education = new JLabel("学历：", JLabel.CENTER);
        education.setBounds(35,220,140,40);
        education.setFont(f1);
        ceducation = new JComboBox<>(educations);
        ceducation.setFont(f2);
        ceducation.setBounds(175,222,165,35);

        enter = new JButton("测试");
        cancel = new JButton("清空");
        enter.setFont(f2);
        enter.setBounds(105,295,80,30);
        enter.setContentAreaFilled(false);
        cancel.setFont(f2);
        cancel.setBounds(225,295,80,30);
        cancel.setContentAreaFilled(false);
        enter.addActionListener(this);
        cancel.addActionListener(this);
    }
    /*清空*/
    private void clean() {
        tname.setText("");
        tage.setText("");
        man.setSelected(true);
        ceducation.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            clean();
        } else if (e.getSource() == enter) {
            String sname = tname.getText().trim();
            String sage = tage.getText().trim();
            String sgender = isGender();
            String seducation = (String) ceducation.getSelectedItem();
            if (!"".equals(sname) && !"".equals(sage)) {
                if(Integer.valueOf(sage) != 0 && isAge(sage)){
                    showMessageDialog(this, "<html><font color='blue',size='4'>"+ getResult(new Employee(sname,sage,sgender,seducation)));
                }else{
                    showMessageDialog(this, "<html><font color='blue',size='4'>年龄范围应是[1,99]之间的整数！</html>");
                }
            }else{
                showMessageDialog(this, "<html><font color='red',size='4'>请完整输入员工信息！</html>");
            }
        }
    }

    /*返回结果*/
    private String getResult(Employee employee) {
        int age = Integer.valueOf(employee.age);
        String work;
        if(age < 20){
            work = getEducationSmall(employee.education);
        }else if(age < 50){
            if("大学文化".equals(employee.education)){
                work = "技术员！";
            }else{
                work = getGenderMiddle(employee.gender);
            }
        }else {
            if("大学文化".equals(employee.education)){
                work = "技术员！";
            }else{
                work = "材料员！";
            }
        }
        System.out.println(employee+"所分配的工作是："+work);
        return employee.name+("男".equals(employee.gender) ?" 先生":" 女士")+"所分配的工作是："+work;
    }

    /*中等年龄根据性别的工作分配*/
    private String getGenderMiddle(String gender) {
        if("男".equals(gender)){
            return "钳工！";
        }else{
            return "车工！";
        }
    }

    /*小年龄的工作分配*/
    private String getEducationSmall(String education){
       if("小学文化".equals(education)){
           return "脱产学习！";
       }else if("中学文化".equals(education)){
           return "电工！";
       }else{
           return "年龄不符合大学要求！";
       }
    }

    /*判断单选按钮*/
    private String isGender() {
        if(man.isSelected()){
            return "男";
        } else{
            return "女";
        }
    }

    /*年龄规则*/
    private boolean isAge(String sage) {
        return pattern.matcher(sage).matches();
    }

    /*员工类*/
    static class Employee {
        private String name;
        private String age;
        private String education;
        private String gender;

        Employee(String name, String age, String gender, String education) {
            this.name = name;
            this.age = age;
            this.education = education;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", education=" + education +
                    ", gender=" + gender +
                    '}';
        }
    }
    public static void main(String[] args) {
        new BestArrangementGUI();
    }
}

package 学生成绩管理;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

//查询、更新教师和学生信息
public class Admin extends JFrame {
    JButton jb1,jb2 = null;
    JRadioButton jrb1,jrb2 = null;
    JLabel jl = null;
    JPanel jp = null;
    ButtonGroup bg = null;

    public Admin() {
        getContentPane().setLayout(null);

        jp = new JPanel();
        jp.setBounds(125, 184, 386, 190);
        getContentPane().add(jp);
        jp.setLayout(null);

        jl = new JLabel("操作对象");
        jl.setIcon(new ImageIcon(Admin.class.getResource("/images/操作对象.png")));
        jl.setBounds(29, 48, 100, 37);
        jp.add(jl);

        jrb1 = new JRadioButton("学生");//学生

        jrb1.setBounds(118, 48, 59, 37);
        jp.add(jrb1);

        jrb2 = new JRadioButton("教师");//教师
        jrb2.setBounds(206, 48, 59, 37);
        jp.add(jrb2);

        bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);

        jb1 = new JButton("确定");
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                if(jrb1.isSelected()){
                    Stu st = new Stu();
                }
                else if(jrb2.isSelected()){
                    Tea ta = new Tea();
                }else{
                    Cou co = new Cou();
                }
            }
        });
        jb1.setIcon(new ImageIcon(Admin.class.getResource("/images/确定.png")));
        jb1.setBounds(41, 109, 100, 42);
        jp.add(jb1);


        JButton jb2 = new JButton("退出");
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jb2.setIcon(new ImageIcon(Admin.class.getResource("/images/退出.png")));
        jb2.setBounds(267, 109, 100, 42);
        jp.add(jb2);

        JRadioButton radioButton = new JRadioButton("课程");
        radioButton.setBounds(294, 48, 100, 37);
        jp.add(radioButton);
        bg.add(radioButton);

        JButton button = new JButton("返回");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login l = new Login();
            }
        });
        button.setIcon(new ImageIcon(Admin.class.getResource("/images/返回.png")));
        button.setBounds(154, 109, 100, 42);
        jp.add(button);

        JLabel label = new JLabel("欢迎登录学生成绩管理系统！");
        label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 46));
        label.setBounds(14, 55, 604, 60);
        getContentPane().add(label);




        //给窗口设置标题
        this.setTitle("学生成绩管理系统-管理员");
        //设置窗体大小
        this.setSize(650,520);
        //设置窗体初始位置
        this.setLocation(200, 150);
        //设置当关闭窗口时，保证JVM也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示窗体
        this.setVisible(true);
        //窗体大小可变
        this.setResizable(true);
    }
}

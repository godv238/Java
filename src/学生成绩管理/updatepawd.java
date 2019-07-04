package 学生成绩管理;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class updatepawd extends JFrame {
    private JTextField textField;
    private JTextField textField_1;
    public updatepawd() {
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("学号：");
        lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        lblNewLabel.setBounds(218, 88, 100, 39);
        getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(306, 90, 151, 39);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel label = new JLabel("新密码：");
        label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        label.setBounds(218, 196, 100, 39);
        getContentPane().add(label);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(306, 198, 151, 39);
        getContentPane().add(textField_1);

        JButton button = new JButton("确定");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MysqlConn.ConnectSQL();
                if (textField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入学号!", "提示消息", JOptionPane.WARNING_MESSAGE);
                } else if (!JudgeNum.judge(textField.getText(), textField.getText().length())) {
                    JOptionPane.showMessageDialog(null, "学号仅由数字组成，您输入的学号形式有误!\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
                } else if (!MysqlConn.querystu(textField.getText())) {
                    JOptionPane.showMessageDialog(null, "您输入的学号有误或该学号不存在!\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
                } else if (!textField.getText().equals(MysqlConn.userword)) {
                    JOptionPane.showMessageDialog(null, "请输入正确学号!", "提示消息", JOptionPane.WARNING_MESSAGE);
                }else if (textField_1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请输入密码!", "提示消息", JOptionPane.WARNING_MESSAGE);
                } else {
                    MysqlConn.stuid = textField.getText();
                    String s = textField_1.getText();
                    MysqlConn.updatestupawd(MysqlConn.stuid,s);

                }
            }
        });
        button.setBounds(132, 308, 84, 39);
        getContentPane().add(button);

        JButton button_1 = new JButton("重置");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField_1.setText("");
            }
        });
        button_1.setBounds(222, 308, 84, 39);
        getContentPane().add(button_1);

        JButton button_2 = new JButton("返回");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Student t = new Student();
            }
        });
        button_2.setBounds(315, 308, 84, 39);
        getContentPane().add(button_2);

        JButton button_3 = new JButton("退出");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button_3.setBounds(408, 308, 84, 39);
        getContentPane().add(button_3);

        this.setTitle("学生成绩管理系统修改密码");
        //设置窗体大小
        this.setSize(650, 520);
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



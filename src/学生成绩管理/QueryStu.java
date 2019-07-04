package 学生成绩管理;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryStu extends JFrame{
    private JTable table;
    private JTable table_1;
    public QueryStu() {
        getContentPane().setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 34, 882, 226);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel label_1 = new JLabel("所有学生个人信息");
        label_1.setBounds(365, 15, 151, 24);
        panel_1.add(label_1);
        label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 52, 882, 152);
        panel_1.add(scrollPane);

        table = new JTable();
        table.setRowHeight(30);
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},


                },
                new String[] {
                        "学号","姓名","性别","出生年月","电话","学院","班级","家庭地址"
                }
        ));
        table.getColumnModel().getColumn(5).setPreferredWidth(100);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(156, 286, 642, 295);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 37, 642, 242);
        panel_2.add(scrollPane_1);

        table_1 = new JTable();
        table_1.setRowHeight(30);
        scrollPane_1.setViewportView(table_1);
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},

                },
                new String[] {
                        "姓名", "课程", "任教老师", "成绩", "绩点", "学分"
                }
        ));

        MysqlConn.ConnectSQL();
        MysqlConn.getdatastu();
        if(MysqlConn.counter == 0){
            JOptionPane.showMessageDialog(null, "学生信息还未导入!", "提示消息", JOptionPane.ERROR_MESSAGE);
        }
        for(int i = 0; i < MysqlConn.counter; i++){
            table.setValueAt(MysqlConn.stu_id[i], i, 0);
            table.setValueAt(MysqlConn.stu_name[i], i, 1);
            table.setValueAt(MysqlConn.stu_sex[i], i, 2);
            table.setValueAt(MysqlConn.stu_birth[i], i, 3);
            table.setValueAt(MysqlConn.stu_tel[i], i, 4);
            table.setValueAt(MysqlConn.stu_academy[i], i, 5);
            table.setValueAt(MysqlConn.stu_class[i], i, 6);
            table.setValueAt(MysqlConn.stu_add[i], i, 7);
        }

        MysqlConn.getdatagra();
        if(MysqlConn.counter == 0){
            JOptionPane.showMessageDialog(null, "学生成绩还未导入!", "提示消息", JOptionPane.ERROR_MESSAGE);
        }
        for(int i = 0; i < MysqlConn.counter; i++){
            table_1.setValueAt(MysqlConn.stu_name[i], i, 0);
            table_1.setValueAt(MysqlConn.c_name[i], i, 1);
            table_1.setValueAt(MysqlConn.ct_name[i], i, 2);
            table_1.setValueAt(MysqlConn.stu_grade[i], i, 3);
            table_1.setValueAt(MysqlConn.stu_point[i], i, 4);
            table_1.setValueAt(MysqlConn.credit[i], i, 5);
        }

        JLabel label_2 = new JLabel("所有学生成绩信息");
        label_2.setBounds(201, 0, 167, 34);
        panel_2.add(label_2);
        label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));

        JButton button = new JButton("返回");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Stu st = new Stu();
            }
        });
        button.setBounds(329, 603, 85, 37);
        getContentPane().add(button);

        JButton button_1 = new JButton("退出");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button_1.setBounds(520, 603, 85, 37);
        getContentPane().add(button_1);






        this.setTitle("学生成绩管理系统-管理员-查询学生信息");
        //设置窗体大小
        this.setSize(900,700);
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

package 学生成绩管理;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class QueryTea extends JFrame {
    private JTable table;
    public QueryTea() {
        getContentPane().setLayout(null);

        JLabel label = new JLabel("所有教师信息");
        label.setBounds(254, 88, 123, 42);
        label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(label);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(29, 164, 574, 150);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setRowHeight(30);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "教师号", "姓名", "出生年月", "职称", "所教课程"
                }
        ));
        scrollPane.setViewportView(table);

        MysqlConn.ConnectSQL();
        MysqlConn.getdatatea();
        if(MysqlConn.counter == 0){
            JOptionPane.showMessageDialog(null, "教师信息暂未导入!", "提示消息", JOptionPane.ERROR_MESSAGE);
        }
        for(int i = 0; i < MysqlConn.counter; i++){
            table.setValueAt(MysqlConn.tea_id[i], i, 0);
            table.setValueAt(MysqlConn.tea_name[i], i, 1);
            table.setValueAt(MysqlConn.tea_birth[i], i, 2);
            table.setValueAt(MysqlConn.tea_protitle[i], i, 3);
            table.setValueAt(MysqlConn.c_name[i], i, 4);
        }

        JButton button_1 = new JButton("返回");
        button_1.setBounds(207, 351, 79, 34);
        getContentPane().add(button_1);

        JButton button_2 = new JButton("退出");
        button_2.setBounds(340, 351, 79, 34);
        getContentPane().add(button_2);
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Tea te = new Tea();
            }
        });

        this.setTitle("学生成绩管理系统-管理员-查询教师信息");
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
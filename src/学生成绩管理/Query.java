package 学生成绩管理;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Choice;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Query extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    public Query(String s) {
        MysqlConn.ConnectSQL();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 520);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JRadioButton radioButton = new JRadioButton("\u5B66\u53F7");
        radioButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        JRadioButton rdbtnNewRadioButton = new JRadioButton("\u59D3\u540D");
        rdbtnNewRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JRadioButton radioButton_1 = new JRadioButton("\u73ED\u7EA7");
        radioButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        textField = new JTextField();

        textField.setColumns(14);

        JLabel label = new JLabel("\u67E5\u8BE2\u6761\u4EF6\uFF1A");

        label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 250, 568, 152);

        getContentPane().add(scrollPane);


        JTable table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},

                },
                new String[] {
                        "学号", "姓名", "成绩", "绩点"
                }
        ));
        scrollPane.setViewportView(table);
        table.setRowHeight(30);


        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton);
        bg.add(radioButton_1);
        bg.add(rdbtnNewRadioButton);
        JButton button = new JButton("\u67E5\u8BE2");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MysqlConn.ConnectSQL();

                if(textField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"请输入学号或姓名或班级!","提示消息",JOptionPane.WARNING_MESSAGE);
                }else if(!radioButton.isSelected() && !rdbtnNewRadioButton.isSelected() && !radioButton_1.isSelected()){
                    JOptionPane.showMessageDialog(null,"请选择学学号或姓名或班级!","提示消息",JOptionPane.WARNING_MESSAGE);
                }else if(radioButton.isSelected()){
                    if(!MysqlConn.querystu(textField.getText())){
                        JOptionPane.showMessageDialog(null,"您输入的学号有误!\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
                    }else{

                        MysqlConn.stuid = textField.getText();



                        //执行查询操作


                        //System.out.println(s);
                        MysqlConn.query_1(MysqlConn.stuid,s);

                        for(int i = 0; i < MysqlConn.counter; i++){
                            table.setValueAt(MysqlConn.stu_id[i], i, 0);
                            table.setValueAt(MysqlConn.stu_name[i], i, 1);
                            table.setValueAt(MysqlConn.stu_grade[i], i, 2);
                            table.setValueAt(MysqlConn.stu_point[i], i, 3);
                        }
                    }
                }else if(rdbtnNewRadioButton.isSelected()){
                    if(!MysqlConn.querycname(textField.getText())){
                        JOptionPane.showMessageDialog(null,"您输入的学生姓名有误!\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
                    }else{

                            MysqlConn.stuname = textField.getText();




                            MysqlConn.query_3(MysqlConn.stuname,s);
                        for(int i = 0; i < MysqlConn.counter; i++){
                            table.setValueAt(MysqlConn.stu_id[i], i, 0);
                            table.setValueAt(MysqlConn.stu_name[i], i, 1);
                            table.setValueAt(MysqlConn.stu_grade[i], i, 2);
                            table.setValueAt(MysqlConn.stu_point[i], i, 3);
                        }
                    }
                }else{
                    if(!MysqlConn.queryclass(textField.getText())){
                        JOptionPane.showMessageDialog(null,"您输入的班级有误!\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
                    }else{

                        MysqlConn.stuclass = textField.getText();




                        MysqlConn.query_2(MysqlConn.stuclass,s);




                        for(int i = 0; i < MysqlConn.counter; i++){
                            table.setValueAt(MysqlConn.stu_id[i], i, 0);
                            table.setValueAt(MysqlConn.stu_name[i], i, 1);
                            table.setValueAt(MysqlConn.stu_grade[i], i, 2);
                            table.setValueAt(MysqlConn.stu_point[i], i, 3);
                        }
                        }
                    }
                }

        });

        



        JButton button_1 = new JButton("\u8FD4\u56DE");
        button_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Teacher t = new Teacher();
            }
        });

        JButton button_2 = new JButton("\u9000\u51FA");
        button_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bg.add(button);
        bg.add(button_1);
        bg.add(button_2);



        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(117)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(button)
                                                .addGap(67)
                                                .addComponent(button_1)
                                                .addGap(80)
                                                .addComponent(button_2))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(label)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(textField)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(radioButton)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(rdbtnNewRadioButton)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(radioButton_1)))))
                                .addContainerGap(163, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(35)
                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(radioButton)
                                                        .addComponent(radioButton_1)
                                                        .addComponent(rdbtnNewRadioButton))
                                                .addGap(18))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap(43, Short.MAX_VALUE)
                                                .addComponent(label)
                                                .addGap(48)))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(button)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(button_1)
                                                .addComponent(button_2)))
                                .addGap(302))

        );
        contentPane.setLayout(gl_contentPane);
        this.setTitle("学生成绩管理系统-教师-查询");
        //设置窗体大小
        this.setSize(650,520);
        //设置窗体初始位置
        this.setLocation(200, 150);
        //设置当关闭窗口时，保证JVM也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示窗体
        this.setVisible(true);
        //窗体大小可变
        this.setResizable(false);
    }
    }

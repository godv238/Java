package 学生成绩管理;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    //定义登录界面的组件
    JButton jb1,jb2,jb3=null;
    JRadioButton jrb1,jrb2,jrb3=null;
    JPanel jp4=null;
    JTextField jtf=null;
    JLabel jlb1,jlb2,jlb3=null;
    JPasswordField jpf=null;
    ButtonGroup bg=null;


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Login ms=new Login();
    }
    //构造函数
    public Login()
    {


        bg=new ButtonGroup();
        jp4=new JPanel();
        jp4.setBounds(0, 0, 0, 0);
        getContentPane().setLayout(null);
        getContentPane().add(jp4);



        jlb1=new JLabel("账号：");
        jlb1.setIcon(new ImageIcon(Login.class.getResource("/images/用户名.png")));
        jlb1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        jlb1.setBounds(181, 92, 100, 37);
        getContentPane().add(jlb1);

        jtf=new JTextField(12);
        jtf.setBounds(280, 92, 133, 37);
        getContentPane().add(jtf);

        jlb2=new JLabel("密    码：");
        jlb2.setIcon(new ImageIcon(Login.class.getResource("/images/密码.png")));
        jlb2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        jlb2.setBounds(181, 161, 100, 37);
        getContentPane().add(jlb2);

        jpf = new JPasswordField(12);
        jpf.setBounds(280, 161, 133, 37);
        getContentPane().add(jpf);

        jlb3=new JLabel("权    限：");
        jlb3.setIcon(new ImageIcon(Login.class.getResource("/images/权限.png")));
        jlb3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        jlb3.setBounds(181, 227, 100, 37);
        getContentPane().add(jlb3);

        jrb1=new JRadioButton("管理员");
        //jrb1.setIcon(new ImageIcon(Login.class.getResource("/images/管理员.png")));
        jrb1.setBounds(265, 227, 73, 37);
        //jrb1.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(jrb1);
        bg.add(jrb1);

        jrb2=new JRadioButton("教师");
        //jrb2.setIcon(new ImageIcon(Login.class.getResource("/images/老师.png")));
        jrb2.setBounds(349, 227, 59, 37);
        //jrb2.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(jrb2);
        bg.add(jrb2);

        jrb3=new JRadioButton("学生",true);
        //jrb3.setIcon(new ImageIcon(Login.class.getResource("/images/学生.png")));
        jrb3.setBounds(421, 227, 59, 37);
        //jrb3.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(jrb3);
        bg.add(jrb3);

        //创建组件
        jb1=new JButton("登录");
        jb1.setIcon(new ImageIcon(Login.class.getResource("/images/登录.png")));
        jb1.setBounds(181, 311, 100, 40);
        getContentPane().add(jb1);
        jb2=new JButton("重置");
        jb2.setIcon(new ImageIcon(Login.class.getResource("/images/重置.png")));
        jb2.setBounds(265, 311, 100, 40);
        getContentPane().add(jb2);
        jb3=new JButton("退出");
        jb3.setIcon(new ImageIcon(Login.class.getResource("/images/退出.png")));
        jb3.setBounds(360, 311, 100, 40);
        getContentPane().add(jb3);
        jb3.addActionListener(this);
        jb2.addActionListener(this);
        //设置监听
        jb1.addActionListener(this);
        JLabel label = new JLabel("欢迎使用学生成绩管理系统");
        label.setIcon(new ImageIcon(Login.class.getResource("/images/java.png")));
        label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        label.setBounds(165, 30, 604, 60);
        getContentPane().add(label);
        //getContentPane().setBackground(Color.LIGHT_GRAY);


        //给窗口设置标题
        this.setTitle("学生成绩管理系统-登录");
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

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand()=="退出")
        {
            System.exit(0);
        }else if(e.getActionCommand()=="登录")
        {
            if(!jtf.getText().isEmpty() && !String.valueOf(jpf.getPassword()).isEmpty())
            {
                //当点击登录按钮时，首先与数据库建立连接
                MysqlConn.ConnectSQL();
                //如果选中管理员登录
                if(jrb1.isSelected())
                {
                    //判断是否存在该用户
                    if(MysqlConn.queryadm(jtf.getText()))
                    {
                        //调用登录方法
                        this.adminlogin();
                    }else{
                        JOptionPane.showMessageDialog(null, "不存在该用户", "提示消息", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else if(jrb2.isSelected())
                {
                    //判断是否存在该用户
                    if(MysqlConn.querytea(jtf.getText()))
                    {
                        MysqlConn.userword = jtf.getText();

                        //调用登录方法
                        this.tealogin();
                    }else{
                        JOptionPane.showMessageDialog(null, "不存在该用户", "提示消息", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else if(jrb3.isSelected())
                {
                    //判断是否存在该用户

                    if(MysqlConn.querystu(jtf.getText()))
                    {
                        MysqlConn.userword = jtf.getText();

                        //调用登录方法
                        this.stulogin();
                    }else{
                        JOptionPane.showMessageDialog(null, "不存在该用户", "提示消息", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }else if(jtf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"请输入账号","提示消息",JOptionPane.WARNING_MESSAGE);
                this.clear();
            }else if(String.valueOf(jpf.getPassword()).isEmpty())
            {
                JOptionPane.showMessageDialog(null,"请输入密码","提示消息",JOptionPane.WARNING_MESSAGE);
                this.clear();
            }
        }else if(e.getActionCommand()=="重置")
        {
            this.clear();
        }
    }

    //清空文本框和密码框
    public void clear()
    {
        jtf.setText("");
        jpf.setText("");
    }

    //管理员登录
    public void adminlogin(){
        if(MysqlConn.pawd.equals(String.valueOf(jpf.getPassword())))
        {
            JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            this.clear();
            //关闭当前界面
            dispose();
            //创建一个新界面
            Admin ad=new Admin();
        }else if(jtf.getText().isEmpty()&&String.valueOf(jpf.getPassword()).isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入账号和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入账号！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(String.valueOf(jpf.getPassword()).isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"账号或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            //清空输入框
            this.clear();
        }
    }

    //教师登录
    public void tealogin(){
        if(MysqlConn.pawd.equals(String.valueOf(jpf.getPassword())))
        {
            JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            this.clear();
            //关闭当前界面
            dispose();
            //创建一个新界面
            Teacher tea = new Teacher();
        }else if(jtf.getText().isEmpty()&&String.valueOf(jpf.getPassword()).isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入账号和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入账号！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(String.valueOf(jpf.getPassword()).isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"账号或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            //清空输入框
            this.clear();
        }
    }

    //学生登录
    public void stulogin(){
        if(MysqlConn.pawd.equals(String.valueOf(jpf.getPassword())))
        {
            JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            this.clear();
            //关闭当前界面
            dispose();
            //创建一个新界面
            Student stu = new Student();
        }else if(jtf.getText().isEmpty()&&String.valueOf(jpf.getPassword()).isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入账号和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入账号！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(String.valueOf(jpf.getPassword()).isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"账号或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            //清空输入框
            this.clear();
        }
    }
}

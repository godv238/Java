package 学生成绩管理;



import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cou extends JFrame {
    public Cou() {
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(152, 59, 329, 302);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("请选择您要进行的操作");
        label.setBounds(69, 5, 250, 41);
        panel.add(label);
        label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));

        JButton button = new JButton("查询课程信息");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                QueryCou qc = new QueryCou();
            }
        });
        button.setIcon(new ImageIcon(Cou.class.getResource("/images/查询.png")));
        button.setBounds(94, 59, 140, 47);
        panel.add(button);

        JButton button_1 = new JButton("添加课程信息");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                InsertCou ic = new InsertCou();
            }
        });
        button_1.setIcon(new ImageIcon(Cou.class.getResource("/images/添加.png")));
        button_1.setBounds(94, 119, 140, 47);
        panel.add(button_1);

        JButton button_2 = new JButton("修改课程信息");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                String s = null;
                InsertCou uc = new InsertCou(s);
            }
        });
        button_2.setIcon(new ImageIcon(Cou.class.getResource("/images/修 改.png")));
        button_2.setBounds(94, 182, 140, 47);
        panel.add(button_2);

        JButton button_3 = new JButton("删除课程信息");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Delete dc = new Delete();
            }
        });
        button_3.setIcon(new ImageIcon(Cou.class.getResource("/images/删除.png")));
        button_3.setBounds(94, 242, 140, 47);
        panel.add(button_3);

        JButton button_4 = new JButton("返回");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Admin ad = new Admin();
            }
        });
        button_4.setIcon(new ImageIcon(Cou.class.getResource("/images/返回.png")));
        button_4.setBounds(202, 389, 100, 41);
        getContentPane().add(button_4);

        JButton button_5 = new JButton("退出");
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button_5.setIcon(new ImageIcon(Cou.class.getResource("/images/退出.png")));
        button_5.setBounds(345, 389, 100, 41);
        getContentPane().add(button_5);

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


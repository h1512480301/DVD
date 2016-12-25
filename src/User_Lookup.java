import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Lookup extends JFrame implements ActionListener {

	// 定义组件
	JLabel jl1,jl2 = null;
	JTextField jtf = null;
	JButton jb1,jb2= null;
	JPanel jp1,jp2 = null;

public static void main(String[] args) {
		// TODO Auto-generated method stub
		User_Lookup t = new User_Lookup();
		}

	// 构造函数
	public User_Lookup() {
		// 创建组件		

		jl1 =new JLabel("请输入影碟编号：");	
	
		jl2=new JLabel("影碟信息表：");
		
		jtf = new JTextField(10);
		
		jb1 = new JButton("查询");
		jb2 = new JButton("返回");
	    jb1.addActionListener(this);
	    jb2.addActionListener(this);
	    
	    jp1 = new JPanel();
		jp2 = new JPanel();
		
		jp2.setLayout(new BorderLayout());
		
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));	
		jp2.add(jl2,BorderLayout.NORTH);

		this.add(jp1);
		this.add(jp2);
		
		this.setLayout(new GridLayout(6, 1));
		this.setTitle("影碟查找--用户");
		this.setSize(500, 300);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("查询")  &&!jtf.getText().isEmpty())
		{
			// 当点击查询按钮时，首先与数据库建立连接
			GetSQL.ConnectSQL();
		}else if(e.getActionCommand()=="返回"){
			dispose();
			User_Choice l=new User_Choice();
		}else{
			JOptionPane.showMessageDialog(null , "请输入要查询的编号","提示消息",JOptionPane.WARNING_MESSAGE);
		}

	}
}

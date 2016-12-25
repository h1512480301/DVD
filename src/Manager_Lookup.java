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

public class Manager_Lookup extends JFrame implements ActionListener {

	// 定义组件
	JLabel jl1,jl2,jl3,jl4 = null;
	JTextField jtf1,jtf2 = null;
	JButton jb1,jb2,jb3,jb4 = null;
	JPanel jp1,jp2,jp3,jp4,jp5,jp6 = null;

	DefaultTableModel model1,model2 = null;
	JTable table1,table2 = null;
	JScrollPane jsp1,jsp2 = null;

public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager_Lookup t = new Manager_Lookup();
		}

	// 构造函数
	public Manager_Lookup() {
		// 创建组件		
		jl1 = new JLabel("请输入用户会员号：");
		jl2=new JLabel("请输入影碟编号：");	
		
		jl3=new JLabel("用户信息表：");
		jl4=new JLabel("影碟信息表：");
		
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jb1 = new JButton("查询1");
		jb2 = new JButton("查询2");
		jb3 = new JButton("修改1");
		jb4 = new JButton("修改2");
		// 设置监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		// 设置表格1
		String[] colnames = { "姓名", "用户编号", "年龄", "性别","最新租借记录",  "创立时间" };
		model1 = new DefaultTableModel(colnames, 3);
		table1 = new JTable(model1);
		jsp1 = new JScrollPane(table1);
		//设置表格2
		String[] col = { "影片名", "影片编号", "类型", "地区","年份","价格"};
		model2 = new DefaultTableModel(col, 3);
		table2 = new JTable(model2);
		jsp2 = new JScrollPane(table2);
		

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp5.setLayout(new BorderLayout());
		jp6.setLayout(new BorderLayout());

		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jb1);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.setPreferredSize(new Dimension(20,20));
		
		jp3.add(jl2);
		jp3.add(jtf2);
		jp3.add(jb2);
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jp2.add(jb3);
		jp2.add(jsp1);
		jp4.add(jb4);
		jp4.add(jsp2);
		
		jp5.add(jl3,BorderLayout.SOUTH);
		jp6.add(jl4,BorderLayout.SOUTH);

		this.add(jp1);
		this.add(jp5);
		this.add(jp2);
		
		this.add(jp3);
		this.add(jp6);
		this.add(jp4);
		
		this.setLayout(new GridLayout(6, 1));
		this.setTitle("用户影碟管理--管理员");
		this.setSize(500, 700);
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("查询1")  &&!jtf1.getText().isEmpty()) {						
			// 当点击查询按钮1时，首先与数据库建立连接
			GetSQL.ConnectSQL();
			GetSQL.getdatastu(jtf1.getText());
			jtf1.setText("");
			System.out.println(GetSQL.record);
			System.out.println(GetSQL.sex);
			// 将数据填入表格	
		    table1.setValueAt(GetSQL.name, 0, 0);
			table1.setValueAt(GetSQL.num, 0, 1);
			table1.setValueAt(GetSQL.age, 0, 2);
			table1.setValueAt(GetSQL.sex, 0, 3);
			table1.setValueAt(GetSQL.record, 0, 4);
			table1.setValueAt(GetSQL.time, 0, 5);				
				
		}else if (e.getActionCommand().equals("查询2")&&!jtf2.getText().isEmpty())
		{
			// 当点击查询按钮2时，首先与数据库建立连接
			GetSQL.ConnectSQL();
			GetSQL.getdatatea(jtf2.getText());
			jtf2.setText("");
			// 将数据填入表格				
			table2.setValueAt(GetSQL.moviename, 0, 0);
			table2.setValueAt(GetSQL.movienum, 0, 1);
			table2.setValueAt(GetSQL.style, 0, 2);
			table2.setValueAt(GetSQL.region, 0, 3);
			table2.setValueAt(GetSQL.year, 0, 4);
			table2.setValueAt(GetSQL.price, 0, 5);
		}else
		{
			JOptionPane.showMessageDialog(null , "请输入要查询的编号","提示消息",JOptionPane.WARNING_MESSAGE);
		}

	}
}

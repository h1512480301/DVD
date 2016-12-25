import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Manager_movie extends JFrame implements ActionListener {

	// 定义组件
	JLabel jl1,jl2 = null;
	JTextField jtf = null;
	JButton jb1,jb2,jb3= null;
	JPanel jp1,jp2,jp3 = null;

	DefaultTableModel model= null;
	JTable table= null;
	JScrollPane jsp= null;

public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager_movie t = new Manager_movie();
		}

	// 构造函数
	public Manager_movie() {
		// 创建组件		
		jl1 = new JLabel("请输入影碟编号：");
	
		jl2=new JLabel("影碟信息表：");
		
		jtf = new JTextField(10);
		jb1 = new JButton("查询");
		jb2 = new JButton("修改");
		jb3 = new JButton("返回");
		// 设置监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		// 设置表格1
		String[] col = { "影片名", "影片编号", "类型", "地区","年份","价格"};
		model = new DefaultTableModel(col, 3);
		table = new JTable(model);
		jsp = new JScrollPane(table);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jp3.setLayout(new BorderLayout());


		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb3);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.setPreferredSize(new Dimension(20,20));
		
		jp2.add(jb2);
		jp2.add(jsp);
		
		jp3.add(jl2,BorderLayout.SOUTH);
		this.add(jp1);
		this.add(jp3);
		this.add(jp2);
		
		this.setLayout(new GridLayout(6, 1));
		this.setTitle("影碟管理--管理员");
		this.setSize(500, 700);
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("查询")&&!jtf.getText().isEmpty()){
			// 当点击查询按钮2时，首先与数据库建立连接
			GetSQL.ConnectSQL();
		}else if (e.getActionCommand().equals("修改")&&!jtf.getText().isEmpty()){
			GetSQL.ConnectSQL();
			GetSQL.getdatatea(jtf.getText());
			jtf.setText("");				
			table.setValueAt(GetSQL.moviename, 0, 0);
			table.setValueAt(GetSQL.movienum, 0, 1);
			table.setValueAt(GetSQL.style, 0, 2);
			table.setValueAt(GetSQL.region, 0, 3);
			table.setValueAt(GetSQL.year, 0, 4);
			table.setValueAt(GetSQL.price, 0, 5);
		}else if(e.getActionCommand()=="返回"){
			dispose();
			Manager_Choice l=new Manager_Choice();
		}else{
			JOptionPane.showMessageDialog(null , "请输入要查询的编号","提示消息",JOptionPane.WARNING_MESSAGE);
		}

	}
}

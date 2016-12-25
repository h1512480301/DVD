import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class User_Choice extends JFrame implements ActionListener{
	//定义组件
	JButton jb1,jb2=null;
	JPanel jp1,jp2=null;
	
	public User_Choice(){
		//创建组件
		jb1=new JButton("影片查询");
		jb2=new JButton("借阅影片");
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
		jp1=new JPanel();
		jp2=new JPanel();
		
		jp1.add(jb1);
		jp2.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		
		this.setLayout(new GridLayout(3,3,50,50));
		this.setTitle("用户可操作选项");
		this.setSize(300,250);
		this.setLocation(200, 200);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
}
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="影片查询"){
				dispose();
				User_Lookup l=new User_Lookup();
			}
			
		}
}
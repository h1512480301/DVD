import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Manager_Choice extends JFrame implements ActionListener{
	//定义组件
		JButton jb1,jb2=null;
		JPanel jp1,jp2=null;
		
		public Manager_Choice(){
			//创建组件
			jb1=new JButton("影片管理");
			jb2=new JButton("用户管理");
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			
			jp1=new JPanel();
			jp2=new JPanel();
			
			jp1.add(jb1);
			jp2.add(jb2);
			
			this.add(jp1);
			this.add(jp2);
			
			this.setLayout(new GridLayout(3,3,50,50));
			this.setTitle("管理员可操作选项");
			this.setSize(300,250);
			this.setLocation(200, 200);		
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
	}
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand()=="影片管理"){
					dispose();
					Manager_movie l=new Manager_movie();
				}	
				if(e.getActionCommand()=="用户管理"){
					dispose();
					Manager_user l=new Manager_user();
				}	
			}
}

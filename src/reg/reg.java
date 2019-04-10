package reg;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Reg {
	
	public static void main(String args[]) 
	{
		JFrame jf=new JFrame("Registration");
		
		JLabel jl=new JLabel("First Name ");
		JLabel jl2=new JLabel("Last Name ");
		JLabel jl7=new JLabel("Email id ");
		JLabel jl3=new JLabel("Password ");
		JLabel jl4=new JLabel("Country ");
		JLabel jl5=new JLabel("Male ");
		JLabel jl6=new JLabel("Female ");
		JTextField jt=new  JTextField();
		JTextField jt2=new  JTextField();
		JTextField jt3=new  JTextField();
		JPasswordField jp=new JPasswordField();
		ButtonGroup bg=new ButtonGroup();
		JRadioButton r1=new JRadioButton();    
		JRadioButton r2=new JRadioButton();   
		
		JButton jb=new JButton("submit");
	/*	jb.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				JOptionPane.showMessageDialog(jb, "submitted successfully "); 
			        }  
			    });
	*/
		String country[]={"Seclect country","India","Aus","U.S.A","England","Newzealand"};    
		JComboBox cb=new JComboBox(country);  
		
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//jf.setLocation(dim.width/2-jf.getSize().width/2, dim.height/2-jf.getSize().height/2);
		
		jt.setBounds(100, 50, 100, 25);
		jl.setBounds(20, 50, 100, 25);
		
		jt2.setBounds(100, 100, 100, 25);
		jl2.setBounds(20, 100, 100, 25);
		
		jt3.setBounds(100, 150, 100, 25);
		jl7.setBounds(20, 150, 100, 25);
		
		jp.setBounds(100, 200, 100, 25);
		jl3.setBounds(20, 200, 100, 25);
		
		cb.setBounds(100,250,100 ,25);
		jl4.setBounds(20, 250, 100, 25);
		
		r1.setBounds(100, 300, 100, 25);
		jl5.setBounds(20, 300, 100, 25);
		
		r2.setBounds(100, 350, 100, 25);
		jl6.setBounds(20, 350, 100, 25);
		
		jb.setBounds(200, 400, 100, 25);

		bg.add(r1);
		bg.add(r2);
		
		jf.add(jt);
		jf.add(jt2);
		jf.add(jt3);
		jf.add(jp);
		jf.add(jb);
		
		
		jb.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
			
				String v1=jt.getText();
				String v2=jt2.getText();
				String v3=jt3.getText();
				String  v4=new String(jp.getPassword());
				String v5=cb.getSelectedItem().toString();
				String gen=null;
				if(r1.isSelected()) {
					gen="male";
				}else if(r2.isSelected()) 
				{
					gen="female";
				}
				if(cb.getSelectedItem()==country[0]) {
					JOptionPane.showMessageDialog(null, "plz select your country ");
				}
				
				try 
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","mysql12");
				Statement stmt=con.createStatement();
				int rs=stmt.executeUpdate("insert into registration values('"+v1+"','"+v2+"','"+v3+"','"+v4+"','"+v5+"','"+gen+"')");
				
					if(rs>0) {
						JOptionPane.showMessageDialog(null,"successful");
						new Login();
					}
					
					con.close();
				}catch(Exception ee) 
				{
					System.out.println(ee);
				}
				
				
			}
		});
		
		jf.add(r1);
		jf.add(r2);
		jf.add(cb);
		jf.add(jl);
		jf.add(jl2);
		jf.add(jl3);
		jf.add(jl4);
		jf.add(jl5);
		jf.add(jl6);
		jf.add(jl7);
		jf.setSize(800,600);
		jf.setLayout(null);
		jf.setVisible(true);
		
	}
	
}

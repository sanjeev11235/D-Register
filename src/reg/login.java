package reg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	public static void main(String args[]) {
		
		JFrame jf=new JFrame("Login");
		
		JLabel jl=new JLabel("User Name ");
		JLabel jl2=new JLabel("Password ");
		
		JTextField jt=new  JTextField();
		JPasswordField jp=new JPasswordField();
		
		JButton jb2=new JButton("Login ");
		
		jl.setBounds(20, 100, 100, 25);
		jt.setBounds(100, 100, 100, 25);
		
		jl2.setBounds(20, 150, 100, 25);
		jp.setBounds(100, 150, 100, 25);
		
		jb2.setBounds(100, 250, 100, 25);
		
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s1=jt.getText();
				String s2=new String(jp.getPassword());
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","mysql12");
					PreparedStatement st=con.prepareStatement("select * from registration where firstName='"+s1+"'&& password='"+s2+"'");
					ResultSet rs=st.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"successful ");
					}
					else {
						JOptionPane.showMessageDialog(null,"invalid ");
					}
					con.close();
				}catch(Exception e1){
					System.out.println(e1);
				}
		
				
			}
		});
		
		
		jf.add(jl);
		jf.add(jl2);
		jf.add(jt);
		jf.add(jp);
		jf.add(jb2);
		
		jf.setSize(800, 600);
		jf.setLayout(null);
		jf.setVisible(true);
	}
}

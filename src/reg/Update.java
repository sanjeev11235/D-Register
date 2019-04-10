package reg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Update {

	public static void main(String args[]) {
		JFrame jf=new JFrame("Update");
		
		JLabel jl=new JLabel("firstName ");
		JLabel jl2=new JLabel("lastName ");
		JLabel jl3=new JLabel("password ");
		JLabel jl4=new JLabel("country ");
		JLabel jl5=new JLabel("gender ");
		JLabel jl6=new JLabel("Email id ");
		
		JTextField jt=new JTextField();
		JTextField jt2=new JTextField();
		JTextField jt3=new JTextField();
		JPasswordField jp= new JPasswordField();
		String country[]={"Select country","India","Aus","U.S.A","England","Newzealand"};   
		JComboBox jc=new JComboBox(country);
		
		JRadioButton jr=new JRadioButton("Male ");
		JRadioButton jr2=new JRadioButton("Female ");
		JButton jb= new JButton("Update ");
		
		jl6.setBounds(20, 50, 100, 25);
		jt3.setBounds(100, 50, 100, 25);
		
		jl.setBounds(20, 100, 100, 25);
		jt.setBounds(100, 100, 100, 25);
		
		jl2.setBounds(20, 150, 100, 25);
		jt2.setBounds(100, 150, 100, 25);
		
		jl3.setBounds(20, 200, 100, 25);
		jp.setBounds(100, 200, 100, 25);
		
		jl4.setBounds(20, 250, 100, 25);
		jc.setBounds(100, 250, 100, 25);
		
		jl5.setBounds(20, 300, 100, 25);
		jr.setBounds(100, 300, 100, 25);
		jr2.setBounds(100, 350, 100, 25);
		
		jb.setBounds(100, 400, 100, 25);
		jb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String v1=jt.getText();
				String v2=jt2.getText();
				String v3= new String(jp.getPassword());
				String v4=jc.getSelectedItem().toString();
				String v5=jt3.getText();
				String gen=null;
				if(jr.isSelected()) {
					gen="male";
				}else if(jr.isSelected()) {
					gen="female";
				}
				if(jc.getSelectedItem()==country[0]) {
					JOptionPane.showMessageDialog(null, "plz select country ");
				}
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","mysql12");
					PreparedStatement pst=con.prepareStatement("update registration set firstname=?,lastname=?,password=?,country=?,gender=? where email=?");
					pst.setString(1, v1);
					pst.setString(2, v2);
					pst.setString(3, v3);
					pst.setString(4, v4);
					pst.setString(5, gen);
					pst.setString(6, v5);
					
					int k=pst.executeUpdate();
					
							if(k>0) {
								JOptionPane.showMessageDialog(null,"successful ");
							}
							else {
								JOptionPane.showMessageDialog(null,"invalid ");
							}
					con.close();
				}catch(Exception e2) {
					System.out.println(e2);
				}
			}
			
		} );
		
		jf.add(jl);
		jf.add(jl2);
		jf.add(jl3);
		jf.add(jl4);
		jf.add(jl5);
		jf.add(jl6);
		jf.add(jt);
		jf.add(jt2);
		jf.add(jt3);
		jf.add(jp);
		jf.add(jc);
		jf.add(jr);
		jf.add(jr2);
		jf.add(jb);
		jf.setSize(800, 600);
		jf.setLayout(null);
		jf.setVisible(true);
		
	}
}

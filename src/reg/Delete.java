package reg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

public class Delete {

	public static void main(String args[]) {
		JFrame jf=new JFrame("Delete");
		
		JLabel jl=new JLabel("Delete Record from dataBase ");
		JLabel jl2=new JLabel("Email id");
		JTextField jt=new JTextField();
		JButton jb=new JButton("Delete");
		
		jl.setBounds(350, 50, 200, 25);
		
		jl2.setBounds(20, 100, 100, 25);
		jt.setBounds(100, 100, 100, 25);
		
		jb.setBounds(150, 150, 100, 25);
		jb.addActionListener(new ActionListener() {

	
			public void actionPerformed(ActionEvent e) {
		
				String v1=jt.getText();
				if(v1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "plz enter your mail id ");
				}
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg", "root","mysql12");
					PreparedStatement pst=con.prepareStatement("delete from registration where email=?");
					pst.setString(1, v1);
					int rs=pst.executeUpdate();
					if(rs>0) {
						JOptionPane.showMessageDialog(null, "record deleted");
					}
					else {
						JOptionPane.showMessageDialog(null, "invalid mail");
					}
					con.close();
				}catch(Exception e1) {
					System.out.print(e1);
				}
			}});
		jf.add(jl);
		jf.add(jl2);
		jf.add(jt);
		jf.add(jb);
		jf.setSize(800, 600);
		jf.setLayout(null);
		jf.setVisible(true);
		
	}
}

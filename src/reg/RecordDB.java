package reg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RecordDB {

	public static void main(String args[]) {
		
		JFrame jf=new JFrame("DB Record");
		
		JLabel jl=new JLabel("DB Record");
		JTextField jt=new JTextField();
		JButton jb=new JButton("Show Record");
		
		jl.setBounds(20, 100, 100, 25);
		jt.setBounds(100, 100, 150, 25);
		
		JTable jt2=new JTable(0,6);
		
		jt2.setBounds(100, 200, 500, 300);
		jb.setBounds(100, 150, 150, 25);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String v1=jt.getText();
				System.out.println(v1);
				try {
					String firstName=null;
					String lastName=null;
					String email=null;
					int password=0;
					String country=null;
					String gender=null;
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg", "root","mysql12");
					PreparedStatement pst=con.prepareStatement("select * from registration where email=?");
					pst.setString(1, v1);
					ResultSet rs=pst.executeQuery();
					DefaultTableModel model=(DefaultTableModel)jt2.getModel();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "successful");
						firstName=rs.getString("firstName");
						lastName=rs.getString("lastName");
						email=rs.getString("email");
						password=rs.getInt("password");
						country=rs.getString("country");
						gender=rs.getString("gender");
						model.addRow(new Object [] {firstName,lastName,email,password,country,gender});
						
					}
					else{
						JOptionPane.showMessageDialog(null, "invalid");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.print(e1);
				}
			}
			
		});
		
		jf.add(jl);
		jf.add(jb);
		jf.add(jt);
		jf.add(jt2);
		jf.setSize(800, 600);
		jf.setLayout(null);
		jf.setVisible(true);
	}
}

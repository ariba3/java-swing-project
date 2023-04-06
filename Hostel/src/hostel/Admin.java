
package hostel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;

public class Admin {
    JFrame a;
    JPanel p1, p2;
    
    JFrame r, f;
    JPanel pr; 
    JButton br,bback, bUpdateChoose, bDeleteChoose, bViewChoose, bSearchChoose;
    JLabel lc,lr,ln,lp,lm,le,la,lun,lum, lue, lua;
    JTextField tn,tm,te,ta,tun,tum, tue, tua; 
    String name,username,password,mobile,email,address, updatename,updatemobile,updateemail,updateaddress;
    JPasswordField tp;
    
    DefaultTableModel defaultTableModel;
    JTable table;
    
    JFrame c;
    JRadioButton rb1, rb2, rb3, rb4;
    JButton bchoose;
    ButtonGroup bg; JLabel lchoose;
      
    ResultSet rs;
    
    ImageIcon i;
    JLabel l;
    
    String nameRegex = "^[a-z A-Z]+$";	
    String mobileRegex = "^(\\+88)?01[3-9]\\d{8}";
    String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
    
    void adminLogin(Connection con, Statement st)
    {
         
        a = new JFrame();
        a.setSize(500,310);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setLayout(null);
        a.setLocationRelativeTo(null);
        
        
        i = new ImageIcon(this.getClass().getResource("adminLogin.jpg"));
        l = new JLabel(i);
        l.setSize(500,310);
        a.add(l);
        
        
        Font font = new Font("Arial",Font.BOLD,30);
        
       
        p1 = new JPanel();
        p1.setBackground(Color.decode("#87CEEB"));
        p1.setBounds(5,5,472,60);
        l.add(p1);
       
       JLabel l1 = new JLabel("Admin Log In Form");
       //l1.setForeground(Color.white);
       l1.setFont(font);
       l1.setBounds(90,10,50,80);
       p1.add(l1);
        
       p2 = new JPanel();
       p2.setBackground(Color.decode("#87CEEB"));
       p2.setBounds(5,70,472,187);
       p2.setLayout(null);
       l.add(p2);
       Font font1 = new Font("Arial",Font.BOLD,16);
       
       JLabel u = new JLabel("User name :");
       u.setBounds(100,5,100,25);
       u.setFont(font1);
       p2.add(u);
       JTextField utxt = new JTextField();
       utxt.setBounds(200, 5, 200, 25);
       p2.add(utxt);
       
       JLabel pass = new JLabel("Password :");
       pass.setBounds(110,42,200,25);
       pass.setFont(font1);
       p2.add(pass);
       JPasswordField ptxt = new JPasswordField();
       ptxt.setBounds(200,46,200,25);
       p2.add(ptxt);
       
//       JButton rbtn = new JButton("Register");
//       rbtn.setBounds(300,100,100,30);
//       rbtn.setBackground(Color.green);
//       rbtn.setFont(font1);
//       p2.add(rbtn);
       

       JButton lbtn = new JButton("Login");
       lbtn.setBounds(310,110,90,30);
       lbtn.setBackground( Color.decode("#87CEEB"));
       lbtn.setFont(font1);
       
       p2.add(lbtn);
//       rbtn.addActionListener(new ActionListener () {
//       	@Override
//       	public void actionPerformed(ActionEvent e) {
//       		//dispose();
//       		//new Register().registration(con, st);
//       	}
//       
//        });
        lbtn.addActionListener(new ActionListener() {
       	@Override
       	public void actionPerformed(ActionEvent e) {
       		String aname = utxt.getText();
                String apass = new String(ptxt.getPassword());
                
                if(((aname.equals("ariba") && apass.equals("ariba325"))) || (aname.equals("trina") && apass.equals("trina316"))){
                    a.dispose();
                    JOptionPane.showMessageDialog(null,"log in Successfuly");
                    new Admin().choose(con, st);

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"log in not Successfuly");
                }
       		
       	    } 
       });
        
        bback = new JButton("Back");
        bback.setBounds(80, 110, 90, 30);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setFont(bback.getFont().deriveFont(15f));
        p2.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Hostel().startPage(con, st);
                a.dispose();
            }
            
        });
       		
//       		String userRegex = "^[a-zA-Z]+$";
//       	    String passRegex = " (?=.\\d)(?=.[A-Z])(?=.[a-z])(?=.[@#$%&*()]).{6,20}";
//       	    
//       	 if(!Pattern.matches(userRegex, username))
//         {
//             JOptionPane.showConfirmDialog(null,"only char in allowed");
//         }
//         
//         if(!Pattern.matches(passRegex, password))
//         {
//        	 JOptionPane.showConfirmDialog(null,"1 digit,1 lower,1 upper,1 special char and length 6-20");
//         }
 
  //      }); 
        a.setVisible(true);  
            
    }
    
    
    void choose(Connection con, Statement st)
    {
        f = new JFrame("Choose");
        
        i = new ImageIcon(this.getClass().getResource("choose.jpg"));
        l = new JLabel(i);
        l.setSize(500,500);
        f.add(l);
        
        Font font = new Font("Arial",Font.BOLD,32);
        
        lc = new JLabel("Choose any option?");
        lc.setBounds(100, 30, 350, 40);
        lc.setForeground(Color.white);
        //lr.setFont(lr.getFont().deriveFont(45f));
        lc.setFont(font);
        l.add(lc);
        
        
        
        bUpdateChoose = new JButton("Update");
        bUpdateChoose.setBounds(180, 120, 140, 45);
        bUpdateChoose.setBackground(Color.decode("#87CEEB"));
        bUpdateChoose.setForeground(Color.white);
        bUpdateChoose.setFont(bUpdateChoose.getFont().deriveFont(20f));
        f.add(bUpdateChoose);
        bUpdateChoose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().beforeUpdate(con, st);
                f.dispose();
                
            }
        });
        
        
        bDeleteChoose = new JButton("Delete");
        bDeleteChoose.setBounds(180, 180, 140, 45);
        bDeleteChoose.setBackground(Color.decode("#87CEEB"));
        bDeleteChoose.setForeground(Color.white);
        bDeleteChoose.setFont(bDeleteChoose.getFont().deriveFont(20f));
        f.add(bDeleteChoose);
        bDeleteChoose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().delete(con, st);
                f.dispose();
            }
        });
        
        bSearchChoose = new JButton("Search");
        bSearchChoose.setBounds(180, 240, 140, 45);
        bSearchChoose.setBackground(Color.decode("#87CEEB"));
        bSearchChoose.setForeground(Color.white);
        bSearchChoose.setFont(bSearchChoose.getFont().deriveFont(20f));
        f.add(bSearchChoose);
        bSearchChoose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new Admin().searchMenu(con, st);
                    f.dispose();
                } catch (SQLException ex) {
                    
                }
                
            }
        });
        
        bViewChoose = new JButton("View");
        bViewChoose.setBounds(180, 300, 140, 45);
        bViewChoose.setBackground(Color.decode("#87CEEB"));
        bViewChoose.setForeground(Color.white);
        bViewChoose.setFont(bViewChoose.getFont().deriveFont(20f));
        f.add(bViewChoose);
        bViewChoose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    new Admin().view(con, st);
                    f.dispose();
                } catch (SQLException ex) {
                    
                }
                
            }
        });
        
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,500);
        f.setLayout(null);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.WHITE);
        
    }
    
    void beforeUpdate(Connection con, Statement st)
    {
        c = new JFrame();
        
        i = new ImageIcon(this.getClass().getResource("beforeUpdate.jpg"));
        l = new JLabel(i);
        l.setSize(400,400);
        c.add(l);
        
        lchoose = new JLabel("What do you want Update?");
        lchoose.setBounds(90, 30, 280, 60);
        lchoose.setForeground(Color.white);
        lchoose.setFont(lchoose.getFont().deriveFont(18f));
        
        
        rb1 = new JRadioButton("1) Name");
        rb1.setBounds(120, 100, 150, 40);
        rb1.setBackground(Color.decode("#87CEEB"));
        rb1.setForeground(Color.white);
        rb1.setFont(rb1.getFont().deriveFont(17f));
        
        rb2 = new JRadioButton("2) Mobile");
        rb2.setBounds(120, 140, 150, 40);
        rb2.setBackground(Color.decode("#87CEEB"));
        rb2.setForeground(Color.white);
        rb2.setFont(rb2.getFont().deriveFont(17f));
        
        rb3 = new JRadioButton("3) E-mail");
        rb3.setBounds(120, 180, 150, 40);
        rb3.setBackground(Color.decode("#87CEEB"));
        rb3.setForeground(Color.white);
        rb3.setFont(rb3.getFont().deriveFont(17f));
        
        rb4 = new JRadioButton("4) Address");
        rb4.setBounds(120, 220, 150, 40);
        rb4.setBackground(Color.decode("#87CEEB"));
        rb4.setForeground(Color.white);
        rb4.setFont(rb4.getFont().deriveFont(17f));
        
        bg = new ButtonGroup();
        bg.add(rb1);bg.add(rb2);bg.add(rb3);bg.add(rb4);
        
        bchoose = new JButton("Click");
        bchoose.setBounds(230, 300, 80, 30);
        bchoose.setFont(bchoose.getFont().deriveFont(15f));
        bchoose.setForeground(Color.white);
        bchoose.setBackground(Color.decode("#87CEEB"));
        l.add(lchoose);l.add(rb1); l.add(rb2); l.add(rb3); l.add(rb4); l.add(bchoose);
        
        bchoose.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e) {
                
                if(rb1.isSelected()){
                    new Admin().updateName(con, st);
                    c.dispose();
                }
                if(rb2.isSelected()){
                    new Admin().updateMobile(con, st);
                    c.dispose();
                }
                if(rb3.isSelected())
                {
                    new Admin().updateEmail(con, st);
                    c.dispose();
                }
                if(rb4.isSelected())
                {
                    new Admin().updateAddress(con, st);
                    c.dispose();
                    
                }
            }
        });
        
        
        bback = new JButton("Back");
        bback.setBounds(45, 300, 80, 30);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setForeground(Color.white);
        bback.setFont(bback.getFont().deriveFont(15f));
        c.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().choose(con, st);
                c.dispose();
            }
            
        });
        
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setSize(400,400);
        c.setLayout(null);
        c.setResizable(false);
        c.setLocationRelativeTo(null);
        c.setVisible(true);
    }
    
    
    void updateName(Connection con, Statement st)
    {
        r = new JFrame("Update Name");
        
        i = new ImageIcon(this.getClass().getResource("update.jpg"));
	l = new JLabel(i);
	l.setSize(700,460);
	r.add(l);

        Font font = new Font("Arial",Font.BOLD,17);
        
        pr = new JPanel();
        pr.setBounds(45, 40, 599, 80);
        pr.setBackground(Color.decode("#87CEEB"));
        l.add(pr);
        
        lr = new JLabel("Update Name");
        //lClub.setBounds(50, 37, 460, 70);
        lr.setFont(lr.getFont().deriveFont(45f));
        lr.setForeground(Color.WHITE);
        //lr.setFont(font);
        pr.add(lr);
        
        ln = new JLabel("User name");
        ln.setBounds(45, 150, 150, 50);
        ln.setFont(ln.getFont().deriveFont(20f));
        ln.setForeground(Color.WHITE);
        //ln.setFont(font);
        l.add(ln);
        
        tn = new JTextField();
        tn.setBounds(200, 150, 447, 40);
        tn.setFont(font);
        r.add(tn);
        
        
        lun = new JLabel("Updated name");
        lun.setBounds(45, 240, 150, 50);
        lun.setFont(lun.getFont().deriveFont(20f));
        lun.setForeground(Color.WHITE);
        l.add(lun);
        
        tun = new JTextField();
        tun.setBounds(200, 240, 446, 40);
        tun.setFont(font);
        r.add(tun);
                 
        br = new JButton("Submit");
        br.setBounds(547, 340, 100, 40);
        br.setBackground(Color.decode("#87CEEB"));
        br.setForeground(Color.WHITE);
        br.setFont(br.getFont().deriveFont(18f));
        r.add(br);
        br.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               username = tn.getText();
               updatename = tun.getText();
               
                if(username.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Form is blank");
                    
                }else
                {
                   if(!Pattern.matches(nameRegex, updatename))
                    {
                        JOptionPane.showMessageDialog(null,"Only char is allowed");
                    }else{
                       try {
                           String Query = "Update register set name = '"+updatename+"' where username = '"+username+"'";
                           
                            st.executeUpdate(Query);
                            
                            st.close();
                            con.close();
                            r.dispose();
                            JOptionPane.showMessageDialog(null,"Updated Successfuly");
                       
                   }catch (SQLException ex){
                       
                   }
                  }
                   
                 }

                }  
               
            
        });
        
        
        bback = new JButton("Back");
        bback.setBounds(45, 340, 100, 40);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setForeground(Color.WHITE);
        bback.setFont(bback.getFont().deriveFont(18f));
        r.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().beforeUpdate(con, st);
                r.dispose();
            }
            
        });
        
        
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700,460);
        r.setLayout(null);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }
    
    void updateMobile(Connection con, Statement st)
    {
        r = new JFrame("Update Mobile");
        
        i = new ImageIcon(this.getClass().getResource("update.jpg"));
	l = new JLabel(i);
	l.setSize(700,460);
	r.add(l);
        
        Font font = new Font("Arial",Font.BOLD,17);

        
        pr = new JPanel();
        pr.setBounds(45, 40, 599, 80);
        pr.setBackground(Color.decode("#87CEEB"));
        l.add(pr);
        
        lr = new JLabel("Update Mobile");
        //lClub.setBounds(50, 37, 460, 70);
        lr.setFont(lr.getFont().deriveFont(45f));
        lr.setForeground(Color.WHITE);
        //lr.setFont(font);
        pr.add(lr);
        
        ln = new JLabel("User name");
        ln.setBounds(45, 150, 150, 50);
        ln.setFont(ln.getFont().deriveFont(20f));
        ln.setForeground(Color.WHITE);
        //ln.setFont(font);
        l.add(ln);
        
        tn = new JTextField();
        tn.setBounds(200, 150, 447, 40);
        tn.setFont(font);
        r.add(tn);
        
        
        lum = new JLabel("Updated Mobile");
        lum.setBounds(45, 240, 150, 50);
        lum.setFont(lum.getFont().deriveFont(20f));
        lum.setForeground(Color.WHITE);
        l.add(lum);
        
        tum = new JTextField();
        tum.setBounds(200, 240, 446, 40);
        tum.setFont(font);
        r.add(tum);
                 
        br = new JButton("Submit");
        br.setBounds(547, 340, 100, 40);
        br.setBackground(Color.decode("#87CEEB"));
        br.setFont(br.getFont().deriveFont(18f));
        br.setForeground(Color.WHITE);
        r.add(br);
        br.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               username = tn.getText();
               updatemobile = tum.getText();
               
                if(username.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Form is blank");
                    
                }else
                {
                   if(!Pattern.matches(mobileRegex, updatemobile))
                    {
                        JOptionPane.showMessageDialog(null,"Only char is allowed");
                    }
                    else
                    {
                       try {
                           String Query = "Update register set mobile = '"+updatemobile+"' where username = '"+username+"'";
                           
                            st.executeUpdate(Query);
                            
                            st.close();
                            con.close();
                            r.dispose();
                            JOptionPane.showMessageDialog(null,"Updated Successfuly");
                       
                    } catch (SQLException ex) {
                       
                   }
                   } 
                   
                 }

                }  
               
            
        });
        
        
        bback = new JButton("Back");
        bback.setBounds(45, 340, 100, 40);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setFont(bback.getFont().deriveFont(18f));
        bback.setForeground(Color.WHITE);
        r.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().beforeUpdate(con, st);
                r.dispose();
            }
            
        });
        
        
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700,460);
        r.setLayout(null);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }
    
    
    void updateEmail(Connection con, Statement st)
    {
        r = new JFrame("Update Email");
        
        i = new ImageIcon(this.getClass().getResource("update.jpg"));
	l = new JLabel(i);
	l.setSize(700,460);
	r.add(l);
        
        Font font = new Font("Arial",Font.BOLD,17);

        
        pr = new JPanel();
        pr.setBounds(45, 40, 599, 80);
        pr.setBackground(Color.decode("#87CEEB"));
        l.add(pr);
        
        lr = new JLabel("Update Email");
        //lClub.setBounds(50, 37, 460, 70);
        lr.setFont(lr.getFont().deriveFont(45f));
        lr.setForeground(Color.WHITE);
        //lr.setFont(font);
        pr.add(lr);
        
        ln = new JLabel("User name");
        ln.setBounds(45, 150, 150, 50);
        ln.setFont(ln.getFont().deriveFont(20f));
        ln.setForeground(Color.WHITE);
        //ln.setFont(font);
        l.add(ln);
        
        tn = new JTextField();
        tn.setBounds(200, 150, 447, 40);
        tn.setFont(font);
        r.add(tn);
        
        
        lue = new JLabel("Updated Email");
        lue.setBounds(45, 240, 150, 50);
        lue.setFont(lue.getFont().deriveFont(20f));
        lue.setForeground(Color.WHITE);
        l.add(lue);
        
        tue = new JTextField();
        tue.setBounds(200, 240, 446, 40);
        tue.setFont(font);
        r.add(tue);
                 
        br = new JButton("Submit");
        br.setBounds(547, 340, 100, 40);
        br.setBackground(Color.decode("#87CEEB"));
        br.setForeground(Color.WHITE);
        br.setFont(br.getFont().deriveFont(18f));
        r.add(br);
        br.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               username = tn.getText();
               updateemail = tue.getText();
               
                if(username.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Form is blank");
                    
                }else
                {
                    if(!Pattern.matches(emailRegex, updateemail))
                    {
                        JOptionPane.showMessageDialog(null,"Only char is allowed");
                    }
                    else
                    {
                       try {
                           String Query = "Update register set email = '"+updateemail+"' where username = '"+username+"'";
                           
                            st.executeUpdate(Query);
                            
                            st.close();
                            con.close();
                            r.dispose();
                            JOptionPane.showMessageDialog(null,"Updated Successfuly");
                       
                   } catch (SQLException ex) {
                       
                   } 
                    
                   }
                    
                   
                 }

                }  
               
            
        });
        
        
        bback = new JButton("Back");
        bback.setBounds(45, 340, 100, 40);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setForeground(Color.WHITE);
        bback.setFont(bback.getFont().deriveFont(18f));
        r.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().beforeUpdate(con, st);
                r.dispose();
            }
            
        });
        
        
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700,460);
        r.setLayout(null);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }
    
    
    void updateAddress(Connection con, Statement st)
    {
        r = new JFrame("Update Address");
        
        i = new ImageIcon(this.getClass().getResource("update.jpg"));
	l = new JLabel(i);
	l.setSize(700,460);
	r.add(l);
        
        Font font = new Font("Arial",Font.BOLD,17);

        
        pr = new JPanel();
        pr.setBounds(45, 40, 599, 80);
        pr.setBackground(Color.decode("#87CEEB"));
        l.add(pr);
        
        lr = new JLabel("Update Address");
        //lClub.setBounds(50, 37, 460, 70);
        lr.setFont(lr.getFont().deriveFont(45f));
        lr.setForeground(Color.WHITE);
        //lr.setFont(font);
        pr.add(lr);
        
        ln = new JLabel("User name");
        ln.setBounds(45, 150, 150, 50);
        ln.setFont(ln.getFont().deriveFont(20f));
        ln.setForeground(Color.WHITE);
        //ln.setFont(font);
        l.add(ln);
        
        tn = new JTextField();
        tn.setBounds(200, 150, 447, 40);
        tn.setFont(font);
        r.add(tn);
        
        
        lua = new JLabel("Updated Address");
        lua.setBounds(45, 240, 180, 50);
        lua.setFont(lua.getFont().deriveFont(18f));
        lua.setForeground(Color.WHITE);
        l.add(lua);
        
        tua = new JTextField();
        tua.setBounds(200, 240, 446, 40);
        tua.setFont(font);
        r.add(tua);
                 
        br = new JButton("Submit");
        br.setBounds(547, 340, 100, 40);
        br.setBackground(Color.decode("#87CEEB"));
        br.setForeground(Color.WHITE);
        br.setFont(br.getFont().deriveFont(18f));
        r.add(br);
        br.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               username = tn.getText();
               updateaddress = tua.getText();
               
                if(username.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Form is blank");
                    
                }else
                {
                    if(updateaddress.equals(""))
                    {
                    JOptionPane.showMessageDialog(null,"In-Valid address");                
                    }
                    else
                    {
                        try {
                           String Query = "Update register set address = '"+updateaddress+"' where username = '"+username+"'";
                           
                            st.executeUpdate(Query);
                            
                            st.close();
                            con.close();
                            r.dispose();
                            JOptionPane.showMessageDialog(null,"Updated Successfuly");
                       
                   } catch (SQLException ex) {
                       
                   }
                        
                   }
                   
                 }

                }  
               
            
        });
        
        
        bback = new JButton("Back");
        bback.setBounds(45, 340, 100, 40);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setForeground(Color.WHITE);
        bback.setFont(bback.getFont().deriveFont(18f));
        r.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().beforeUpdate(con, st);
                r.dispose();
            }
            
        });
        
        
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700,460);
        r.setLayout(null);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }
    
    
    
    
    void delete(Connection con, Statement st)
    {
        r = new JFrame("Delete Information");
        
        i = new ImageIcon(this.getClass().getResource("searchMenu.jpg"));
	l = new JLabel(i);
	l.setSize(700,380);
	r.add(l);
        
        Font font = new Font("Arial",Font.BOLD,17);

        
        pr = new JPanel();
        pr.setBounds(45, 40, 599, 80);
        pr.setBackground(Color.decode("#87CEEB"));
        l.add(pr);
        
        lr = new JLabel("Delete Information");
        //lClub.setBounds(50, 37, 460, 70);
        lr.setFont(lr.getFont().deriveFont(45f));
        lr.setForeground(Color.white);
        //lr.setFont(font);
        pr.add(lr);
        
        ln = new JLabel("User name");
        ln.setBounds(45, 150, 150, 50);
        ln.setFont(ln.getFont().deriveFont(20f));
        ln.setForeground(Color.white);
        //ln.setFont(font);
        l.add(ln);
        
        tn = new JTextField();
        tn.setBounds(200, 150, 447, 40);
        tn.setFont(font);
        r.add(tn);
        
                 
        br = new JButton("Submit");
        br.setBounds(547, 240, 100, 40);
        br.setBackground(Color.decode("#87CEEB"));
        br.setForeground(Color.white);
        br.setFont(br.getFont().deriveFont(18f));
        r.add(br);
        br.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               username = tn.getText();
               
                if(username.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Form is blank");
                    
                }else
                {
                       try {
                           String Query = "Delete from register where username = '"+username+"'";
                           
                            st.executeUpdate(Query);
                            
                            st.close();
                            con.close();
                            r.dispose();
                            JOptionPane.showMessageDialog(null,"Delete Successfuly");
                       
                   }catch (SQLException ex){
                       
                   }
                  }
                   

                }  
               
            
        });
        
        
        bback = new JButton("Back");
        bback.setBounds(45, 240, 100, 40);
        bback.setBackground(Color.decode("#87CEEB"));
        bback.setForeground(Color.white);
        bback.setFont(bback.getFont().deriveFont(18f));
        r.add(bback);
        bback.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Admin().choose(con, st);
                r.dispose();
            }
            
        });
        
        
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700,380);
        r.setLayout(null);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }
    
    void searchMenu(Connection con, Statement st) throws SQLException
    {
        r = new JFrame("Search Menu");
        
        i = new ImageIcon(this.getClass().getResource("searchMenu.jpg"));
	l = new JLabel(i);
	l.setSize(700,380);
	r.add(l);
        
        Font font = new Font("Arial",Font.BOLD,17);

        
        pr = new JPanel();
        pr.setBounds(45, 40, 599, 80);
        pr.setBackground(Color.decode("#87CEEB"));
        l.add(pr);
        
        lr = new JLabel("Search Menu");
        //lClub.setBounds(50, 37, 460, 70);
        lr.setFont(lr.getFont().deriveFont(40f));
        lr.setForeground(Color.white);
        //lr.setFont(font);
        pr.add(lr);
        
        ln = new JLabel("User name");
        ln.setBounds(45, 150, 150, 50);
        ln.setForeground(Color.white);
        ln.setFont(ln.getFont().deriveFont(20f));
        //ln.setFont(font);
        l.add(ln);
        
        tn = new JTextField();
        tn.setBounds(200, 150, 447, 40);
        tn.setFont(font);
        r.add(tn);
        
                 
        br = new JButton("Submit");
        br.setBounds(547, 240, 100, 40);
        br.setBackground(Color.decode("#87CEEB"));
        br.setForeground(Color.WHITE);
        br.setFont(br.getFont().deriveFont(18f));
        r.add(br);
        br.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               username = tn.getText();
               
                if(username.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Form is blank");
                    
                }else
                {
                    r.dispose();
                    r = new JFrame("Information");

            
                    defaultTableModel = new DefaultTableModel();       /*new String[]{"Username", "Name", "Mobile", "E-mail", "Address"},0*/
                    table = new JTable(defaultTableModel);
                    table.setPreferredScrollableViewportSize(new Dimension(600,600));
                    table.setBackground(Color.decode("#87CEEB"));
                    table.setFillsViewportHeight(true);  
                    r.add(new JScrollPane(table));
                    defaultTableModel.addColumn("Username");
                    defaultTableModel.addColumn("Name");
                    defaultTableModel.addColumn("Mobile");
                    defaultTableModel.addColumn("E-mail");
                    defaultTableModel.addColumn("Address");

                    String query = "Select username,name,mobile,email,address from register where username = '"+username+"'";

                   try {
                       rs = st.executeQuery(query);
                       while(rs.next())
                       {
                            String uname = rs.getString("username");
                            String fname = rs.getString("name");
                            String umobile = rs.getString("mobile");
                            String uemail = rs.getString("email");
                            String uaddress = rs.getString("address");

                            defaultTableModel.addRow(new Object[]{uname,fname,umobile,uemail,uaddress});
                            table.setModel(defaultTableModel);
                       }
                   } catch (SQLException ex) {
                       
                   }
                    


                    r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    r.setSize(700,700);
                    r.setLayout(new FlowLayout());
                    r.setResizable(false);
                    r.setLocationRelativeTo(null);
                    r.setVisible(true);
                    r.getContentPane().setBackground(Color.decode("#87CEEB"));
                       
                }
                   

            }
               
            
        });  
        
//        bback = new JButton("Back");
//        bback.setBounds(45, 240, 100, 40);
//        bback.setBackground(Color.GREEN);
//        bback.setFont(bback.getFont().deriveFont(15f));
//        r.add(bback);
//        bback.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                new Admin().choose(con, st);
//                r.dispose();
//            }
//            
//        });
        
        
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700,380);
        r.setLayout(null);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);
        
    }
    
    
    void view(Connection con, Statement st) throws SQLException
    {
        r = new JFrame("Information");
            
        defaultTableModel = new DefaultTableModel();       /*new String[]{"Username", "Name", "Mobile", "E-mail", "Address"},0*/
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(600,600));
        table.setFillsViewportHeight(true);
        table.setBackground(Color.decode("#87CEEB"));
        r.add(new JScrollPane(table));
        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Mobile");
        defaultTableModel.addColumn("E-mail");
        defaultTableModel.addColumn("Address");
        
        String query = "Select username,name,mobile,email,address from register";
        
        rs = st.executeQuery(query);
        while(rs.next())
        {
            String uname = rs.getString("username");
            String fname = rs.getString("name");
            String umobile = rs.getString("mobile");
            String uemail = rs.getString("email");
            String uaddress = rs.getString("address");
            
            defaultTableModel.addRow(new Object[]{uname,fname,umobile,uemail,uaddress});
            table.setModel(defaultTableModel);
        }
        
        
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(700,700);
        r.setLayout(new FlowLayout());
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);
        r.getContentPane().setBackground(Color.decode("#87CEEB"));
    }
    
    
    
    
}

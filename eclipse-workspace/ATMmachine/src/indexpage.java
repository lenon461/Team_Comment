import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class indexpage extends JFrame{
	BankAccount curaccount = null;
	
	public indexpage() {
		setTitle("ATM");
		setSize(400,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel currentuserinfo = new JPanel();
		JPanel currentuseownerinfo = new JPanel();
		JPanel currentusebalanceinfo = new JPanel();

		
		JLabel curuserowner_menu= new JLabel();
		curuserowner_menu.setText("현재 계좌 주인 : ");
		JLabel curuserowner= new JLabel();
		
		JLabel curuserbalance_menu= new JLabel();
		curuserbalance_menu.setText("현재 계좌 잔고 : ");
		JLabel curuserbalance= new JLabel();

		

		
		currentuseownerinfo.add(curuserowner_menu);
		currentuseownerinfo.add(curuserowner);
		
		currentusebalanceinfo.add(curuserbalance_menu);
		currentusebalanceinfo.add(curuserbalance);
		
		
		currentuserinfo.add(currentuseownerinfo);
		currentuserinfo.add(currentusebalanceinfo);

		add(currentuserinfo);
		
		JPanel accountjpn = new JPanel();
		accountjpn.setLayout(new GridLayout(3,1));
		accountjpn.setPreferredSize(new Dimension(100,300));
		JButton depositbutton = new JButton("입금");
		JButton withdrawbutton = new JButton("출금");
		JButton transferbutton = new JButton("이체");
		 
	    
		accountjpn.add(depositbutton);
		accountjpn.add(withdrawbutton);
		accountjpn.add(transferbutton);
		this.add(accountjpn,BorderLayout.EAST);
		
		JPanel userjpn = new JPanel();
		userjpn.setLayout(new GridLayout(3,1));
		userjpn.setPreferredSize(new Dimension(100,300));
		JButton newaccountbutton = new JButton("계좌생성");
		JButton changeaccountbutton = new JButton("계좌변경");
		JButton deleteaccountrbutton = new JButton("계좌해지");
		 
	    
		userjpn.add(newaccountbutton);
		userjpn.add(changeaccountbutton);
		userjpn.add(deleteaccountrbutton);
		this.add(userjpn,BorderLayout.WEST);
		
		
		ActionListener newaccount = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = "LJS";
				BankAccount account = new BankAccount(0, name, 642202, 1234);
				curuserowner.setText(name);
				
				curuserbalance.setText("0");
				curaccount = account;
				
				//System.out.print("@");
				
			}
		};
		newaccountbutton.addActionListener(newaccount);
		
		
		ActionListener deposit = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int curbalance = curaccount.getBalance();
				curaccount.deposit(100);
				
				String s = Integer.toString(curbalance);
				curuserbalance.setText(s);

				System.out.println("c : " + curbalance);
				
			}
		};
		depositbutton.addActionListener(deposit);
		
		


		
		
		
		setVisible(true);
		
		
		
	}

}

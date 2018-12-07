
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class Loginmanager extends JFrame implements ActionListener {
    private static final String Orientation = null;
	private static Object getContentPane;
    private Image screenImage;
    private Image Graphics;

	public Loginmanager() {  
		
    	Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        this.setLocation((screenSize.width / 3)+100, (screenSize.height / 2)-100);

        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("HY Bank");
        
        
       
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JLabel hello = new JLabel("한양은행에 오신 것을 환영합니다.");
        panel1.add(hello);
        
        JButton Loginbutton = new JButton("로그인");
        JButton Userbutton = new JButton(" 회 원 가 입 ");
        JTextField IDfield = new JTextField(10);
        JTextField PWfield = new JTextField(10);
        
        panel2.add(IDfield);
        panel2.add(PWfield);
        panel3.add(Loginbutton);
        panel2.setLayout(new GridLayout(2,1));
        panel4.add(Userbutton,BorderLayout.SOUTH);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

        this.add(panel4,BorderLayout.EAST);
        this.setLayout(new FlowLayout());
        setResizable(false);
        setVisible(true);    
        Userbutton.addActionListener(new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
					final JFrame UserMakeFrame= new JFrame("가입창");
					UserMakeFrame.setLocation((screenSize.width / 3)-150, (screenSize.height / 2)-200);
			        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        JPanel hellopanel = new JPanel();
			        JPanel IDPWpanel = new JPanel();
			        JPanel buttonpanel = new JPanel();
			        
			        JLabel hello = new JLabel("회원님이 사용하실 정보를 입력해주세요");
			        
			        
			        JLabel Namein = new JLabel("  닉네임 입력: ");
			        JLabel IDin = new JLabel("  아이디 입력: ");
			        JLabel PWin = new JLabel("  비밀번호 입력: ");
			        JButton Yesbutton = new JButton("확인");
			        final JTextField NameMake = new JTextField(12);
			        final JTextField IDMake = new JTextField(12);
			        final JTextField PWMake = new JTextField(12);
			        
			        hellopanel.add(hello);
			        IDPWpanel.add(Namein);
			        IDPWpanel.add(NameMake);
			        IDPWpanel.add(IDin);
			        IDPWpanel.add(IDMake);
			        IDPWpanel.add(PWin);
			        IDPWpanel.add(PWMake);
			        
			        buttonpanel.add(Yesbutton);
			        IDPWpanel.setLayout(new GridLayout(3,1));
			        buttonpanel.add(Yesbutton,BorderLayout.SOUTH);
			        UserMakeFrame.add(hellopanel);
			        UserMakeFrame.add(IDPWpanel);
			        UserMakeFrame.add(buttonpanel);
			        
			        UserMakeFrame.setLayout(new FlowLayout());
			        setResizable(false);
			        UserMakeFrame.setVisible(true);
			        UserMakeFrame.setSize(300, 200);
			        
			        Yesbutton.addActionListener(new ActionListener() {
			        	@Override
			        	public void actionPerformed(ActionEvent e) {
			        		String IDregist = IDMake.getText();
			        		IDfield.setText(IDregist);
			        		UserMakeFrame.dispose();
			        	}
			        });
			        
        	}
        	
        });

        
        ActionListener newAccount = new ActionListener() {
        	
			public void actionPerformed(ActionEvent e) {
				final JFrame ManagerFrame= new JFrame("가입창");
				ManagerFrame.setLocation((screenSize.width / 3)-150, (screenSize.height / 2)-200);

		        
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setTitle("HY Bank");
		        
		        
		       
		        JPanel panel11 = new JPanel();
		        JPanel panel21 = new JPanel();
		        
		        JPanel panel31 = new JPanel();
		        
		        JLabel hello = new JLabel("한양은행에 방문해주셔서 감사합니다.");
		        panel11.add(hello);
		        JButton button1 = new JButton("신규계좌");
		        JButton button2 = new JButton("계좌관리");
		        JButton button3 = new JButton("탈퇴");
		        JButton button4 = new JButton("거래내역");
		        JButton button5 = new JButton("계좌이체");
		        JButton button6 = new JButton("잔액조회");
		        JButton button7 = new JButton("입금");
		        JButton button8 = new JButton("출금");
		        panel31.setLayout(new GridLayout(5,1));      // 그리드 레이아웃 = 표 생성 (5바이, 1)
		        panel21.setLayout(new GridLayout(3,1));
		        panel21.add(button1);
		        panel31.add(button3);
		        panel21.add(button2);
		        panel31.add(button5);
		        panel21.add(button4);
		        panel11.add(panel21);
		        panel11.add(panel31);
		        panel31.add(button6);
		        panel31.add(button7);
		        panel31.add(button8);
		        ManagerFrame.add(panel11);
		        ManagerFrame.add(panel21,BorderLayout.WEST);  //표를 WEST로
		        ManagerFrame.add(panel31,BorderLayout.EAST);  	//표를 EAST로 
		        
		        ManagerFrame.setVisible(true);
		        ManagerFrame.setSize(600, 400);
		        
		        
				}			
		};
		Loginbutton.addActionListener(newAccount);
		
		 
		 
		 
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
 
public class Manager {
    public static void main(String[] args) {
//        Loginmanager f = new Loginmanager();
        outputstream Os1 = new outputstream();
        Os1.outputsave();
        Os1.outputread();
        
    }
}

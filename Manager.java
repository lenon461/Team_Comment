
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
        JLabel hello = new JLabel("�Ѿ����࿡ ���� ���� ȯ���մϴ�.");
        panel1.add(hello);
        
        JButton Loginbutton = new JButton("�α���");
        JButton Userbutton = new JButton(" ȸ �� �� �� ");
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
					final JFrame UserMakeFrame= new JFrame("����â");
					UserMakeFrame.setLocation((screenSize.width / 3)-150, (screenSize.height / 2)-200);
			        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        JPanel hellopanel = new JPanel();
			        JPanel IDPWpanel = new JPanel();
			        JPanel buttonpanel = new JPanel();
			        
			        JLabel hello = new JLabel("ȸ������ ����Ͻ� ������ �Է����ּ���");
			        
			        
			        JLabel Namein = new JLabel("  �г��� �Է�: ");
			        JLabel IDin = new JLabel("  ���̵� �Է�: ");
			        JLabel PWin = new JLabel("  ��й�ȣ �Է�: ");
			        JButton Yesbutton = new JButton("Ȯ��");
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
				final JFrame ManagerFrame= new JFrame("����â");
				ManagerFrame.setLocation((screenSize.width / 3)-150, (screenSize.height / 2)-200);

		        
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setTitle("HY Bank");
		        
		        
		       
		        JPanel panel11 = new JPanel();
		        JPanel panel21 = new JPanel();
		        
		        JPanel panel31 = new JPanel();
		        
		        JLabel hello = new JLabel("�Ѿ����࿡ �湮���ּż� �����մϴ�.");
		        panel11.add(hello);
		        JButton button1 = new JButton("�ű԰���");
		        JButton button2 = new JButton("���°���");
		        JButton button3 = new JButton("Ż��");
		        JButton button4 = new JButton("�ŷ�����");
		        JButton button5 = new JButton("������ü");
		        JButton button6 = new JButton("�ܾ���ȸ");
		        JButton button7 = new JButton("�Ա�");
		        JButton button8 = new JButton("���");
		        panel31.setLayout(new GridLayout(5,1));      // �׸��� ���̾ƿ� = ǥ ���� (5����, 1)
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
		        ManagerFrame.add(panel21,BorderLayout.WEST);  //ǥ�� WEST��
		        ManagerFrame.add(panel31,BorderLayout.EAST);  	//ǥ�� EAST�� 
		        
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


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class Loginmanager extends JFrame implements ActionListener {
	private static final String Orientation = null;
	private static Object getContentPane;
	private Image screenImage;
	private Image Graphics;
	Account curaccount;
	ArrayList<Account> Al = new ArrayList<Account>();

	public Loginmanager() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.setLocation((screenSize.width / 3) + 100, (screenSize.height / 2) - 100);

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
		panel2.setLayout(new GridLayout(2, 1));
		panel4.add(Userbutton, BorderLayout.SOUTH);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);

		this.add(panel4, BorderLayout.EAST);
		this.setLayout(new FlowLayout());
		setResizable(false);
		setVisible(true);

		Userbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFrame UserMakeFrame = new JFrame("가입창");
				UserMakeFrame.setLocation((screenSize.width / 3) - 150, (screenSize.height / 2) - 200);
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
				IDPWpanel.setLayout(new GridLayout(3, 1));
				buttonpanel.add(Yesbutton, BorderLayout.SOUTH);
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
						String Nameregist = NameMake.getText();
						String IDregist = IDMake.getText();
						String PWregist = PWMake.getText();
						outputstream os1 = new outputstream();
						os1.outputsave(Nameregist, IDregist, PWregist);
						IDfield.setText(IDregist);
						PWfield.setText(PWregist);
						UserMakeFrame.dispose();

					}
				});

			}

		});

		Loginbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String IDID = IDfield.getText();
				String PWPW = PWfield.getText();
				if (IDID.equals(PWPW)) {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 검토해주십시오");
				}

				else {

					final JFrame ManagerFrame = new JFrame("가입창");
					ManagerFrame.setLocation((screenSize.width / 3) - 150, (screenSize.height / 2) - 200);

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
					JButton timebutton = new JButton("1년 후");
					panel31.setLayout(new GridLayout(5, 1)); // 그리드 레이아웃 = 표 생성 (5바이, 1)
					panel21.setLayout(new GridLayout(4, 1));
					panel21.add(button1);
					panel21.add(button4);
					panel21.add(button2);
					panel21.add(timebutton);
					panel31.add(button3);
					panel31.add(button5);
					panel11.add(panel21);
					panel11.add(panel31);
					panel31.add(button6);
					panel31.add(button7);
					panel31.add(button8);
					ManagerFrame.add(panel11);
					ManagerFrame.add(panel21, BorderLayout.WEST); // 표를 WEST로
					ManagerFrame.add(panel31, BorderLayout.EAST); // 표를 EAST로

					ManagerFrame.setVisible(true);
					ManagerFrame.setSize(600, 400);
					JPanel newSign = new JPanel();
					JLabel statuslabel = new JLabel();
					newSign.add(statuslabel);
					ManagerFrame.add(newSign);

					newSign.setVisible(true);

					ActionListener makeAccount = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {

							Account account = new Account(0);
							curaccount = account;

							Al.add(account);
							Al.add(account);

						}

					};

					button1.addActionListener(makeAccount);
					ActionListener depositaction = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							final JFrame MoneyFrame = new JFrame("입금창");
							MoneyFrame.setLocation((screenSize.width / 3) - 150, (screenSize.height / 2) - 200);
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							JPanel depositpanel = new JPanel();
							JPanel buttonpanel2 = new JPanel();

							JLabel MoneyLabel = new JLabel("입금할 금액을 입력해주세요");
							JButton Moneyconfirm = new JButton("확인");
							final JTextField Moneyin = new JTextField(12);
							
							depositpanel.add(MoneyLabel);
							depositpanel.add(Moneyin);
							depositpanel.setLayout(new GridLayout(3, 1));
							
							buttonpanel2.add(Moneyconfirm, BorderLayout.SOUTH);
							
							MoneyFrame.add(depositpanel);
							MoneyFrame.add(buttonpanel2);
							MoneyFrame.setLayout(new FlowLayout());
							
							setResizable(false);
							
							MoneyFrame.setVisible(true);
							MoneyFrame.setSize(200, 200);
							
							Moneyconfirm.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									String Moneydeposi1t = Moneyin.getText();
									int Moneydeposit = Integer.parseInt(Moneydeposi1t);
									
									curaccount.deposit(Moneydeposit);
									statuslabel.setText(String.valueOf(curaccount.getBalance()));

									MoneyFrame.dispose();
									
								}
							});
						}

					};

					button7.addActionListener(depositaction);
					button8.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							final JFrame WithdrawFrame = new JFrame("출금창");
							WithdrawFrame.setLocation((screenSize.width / 3) - 150, (screenSize.height / 2) - 200);
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							JPanel withdrawpanel = new JPanel();
							JPanel withdrawbuttonpanel = new JPanel();

							JLabel withdrawLabel = new JLabel("출금할 금액을 입력해주세요");
							JButton withdrawconfirm = new JButton("확인");
							final JTextField WMoneyin = new JTextField(12);
							
							withdrawpanel.add(withdrawbuttonpanel);
							withdrawpanel.add(WMoneyin);
							withdrawpanel.setLayout(new GridLayout(3, 1));
							
							withdrawpanel.add(withdrawconfirm, BorderLayout.SOUTH);
							WithdrawFrame.add(withdrawLabel);
						
							WithdrawFrame.add(withdrawpanel);
							WithdrawFrame.add(withdrawbuttonpanel);
							WithdrawFrame.setLayout(new FlowLayout());
							
							setResizable(false);
							
							WithdrawFrame.setVisible(true);
							WithdrawFrame.setSize(200, 200);
							
							withdrawconfirm.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									String Moneydeposi1t = WMoneyin.getText();
									int Moneydeposit = Integer.parseInt(Moneydeposi1t);
									
									curaccount.withdraw(Moneydeposit);
									
									statuslabel.setText(String.valueOf(curaccount.getBalance())+"원");
									WithdrawFrame.dispose();
									
								}
							});
						}

					});
					button6.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String Checking = String.valueOf(curaccount.getBalance());
							JLabel checklabel = new JLabel(Checking);
							checklabel.setVisible(true);
							statuslabel.setText(String.valueOf(curaccount.getBalance())+"원");

						}
					});
					timebutton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							curaccount.addInterest();
							statuslabel.setText(String.valueOf(curaccount.getBalance())+"원");
						}
					});
					
				}

			};

		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}

public class Manager {
	public static void main(String[] args) {

		Loginmanager f = new Loginmanager();
//        outputstream Os1 = new outputstream();
//     
//		Os1.outputsave("정종문","a123","b123");
//		
//		Os1.outputread();
//		Os1.outputsave("C","C","C");
//		Os1.outputread();

	}
}

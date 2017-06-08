package edu.kmi.primejavaC.JWC.View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.sun.glass.events.WindowEvent;

import edu.kmi.primejavaC.JWC.Controller.Event.IdCheckEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SignUp_Form extends JFrame{
	private JTextField txtId;
	private JPasswordField txtPwd;
	private JPasswordField txtPwd_chk;
	private Boolean Id_chk;
	private Boolean Pw_chk;
	/**
	 * Create the application.
	 */
	public SignUp_Form() {
		setTitle("SignUpPage");
		initialize();
		Id_chk = false;
		Pw_chk = false;
		
		//------------------컴포넌트 구성-------------------------------
		JPanel signup_panel = new JPanel();
		getContentPane().add(signup_panel, BorderLayout.CENTER);
		signup_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please fill out the details below!");
		lblNewLabel.setBounds(96, 49, 332, 31);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signup_panel.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		lblId.setBounds(134, 128, 47, 24);
		signup_panel.add(lblId);
		
		JLabel lblPwd = new JLabel("PASSWORD");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		lblPwd.setBounds(77, 164, 104, 24);
		signup_panel.add(lblPwd);
		
		JLabel lblChk = new JLabel("PASSWORD_CHECK");
		lblChk.setHorizontalAlignment(SwingConstants.CENTER);
		lblChk.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		lblChk.setBounds(27, 200, 154, 24);
		signup_panel.add(lblChk);
		
		txtId = new JTextField();
		txtId.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		txtId.setBounds(195, 128, 159, 24);
		signup_panel.add(txtId);
		txtId.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		txtPwd.setBounds(195, 164, 159, 24);
		signup_panel.add(txtPwd);
		
		txtPwd_chk = new JPasswordField();
		txtPwd_chk.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		txtPwd_chk.setBounds(195, 202, 159, 24);
		signup_panel.add(txtPwd_chk);
		
		JButton txtChk = new JButton("ID Check");
		txtChk.setBounds(379, 129, 105, 27);
		signup_panel.add(txtChk);
		
		JTextArea txtPwdChk = new JTextArea();
		txtPwdChk.setLineWrap(true);
		txtPwdChk.setRows(3);
		txtPwdChk.setFont(new Font("굴림", Font.PLAIN, 15));
		txtPwdChk.setBackground(UIManager.getColor("Label.background"));
		txtPwdChk.setEditable(false);
		txtPwdChk.setForeground(new Color(255, 0, 0));
		txtPwdChk.setText("Please enter your password.");
		txtPwdChk.setBounds(368, 167, 127, 60);
		signup_panel.add(txtPwdChk);
		
		JButton btnSignUp = new JButton("SignUp");
		btnSignUp.setEnabled(false);
		btnSignUp.setBounds(219, 256, 105, 27);
		signup_panel.add(btnSignUp);
		//-------------컴포넌트 구성 end----------------------
		
		//-------------이벤트 등록------------------------
			//id 중복체크
		IdCheckEvent id_chk = new IdCheckEvent(this);
		txtChk.addActionListener(id_chk);
			
			//id textBox 입력 시, id 중복 체크 리스너의 id 필드 초기화하는 이벤트
		txtId.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				id_chk.setId(txtId.getText());
			}
		});
		
			//입력된 비밀번호가 같은지 확인하는 이벤트
		txtPwd.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				String pwd = new String(txtPwd.getPassword(), 0, txtPwd.getPassword().length);
				String pwd_2 = new String(txtPwd_chk.getPassword(), 0, txtPwd_chk.getPassword().length);
				
				if(pwd.length() == 0 && pwd_2.length() == 0){
					txtPwdChk.setForeground(new Color(255, 0, 0));
					txtPwdChk.setText("Please enter your password.");
					Pw_chk = false;
				}
				else if(!(pwd.equals(pwd_2))){
					txtPwdChk.setForeground(new Color(255, 0, 0));
					txtPwdChk.setText("Passwords do not match.");
					Pw_chk = false;
				}
				else{
					txtPwdChk.setForeground(new Color(0, 0, 255));
					txtPwdChk.setText("Password available.");
					Pw_chk = true;
				}
			}
		});
		
			//입력된 비밀번호가 같은지 확인하는 이벤트
		txtPwd_chk.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				String pwd = new String(txtPwd.getPassword(), 0, txtPwd.getPassword().length);
				String pwd_2 = new String(txtPwd_chk.getPassword(), 0, txtPwd_chk.getPassword().length);
				
				if(pwd.length() == 0 && pwd_2.length() == 0){
					txtPwdChk.setForeground(new Color(255, 0, 0));
					txtPwdChk.setText("Please enter your password.");
					Pw_chk = false;
				}
				else if(!(pwd.equals(pwd_2))){
					txtPwdChk.setForeground(new Color(255, 0, 0));
					txtPwdChk.setText("Passwords do not match.");
					Pw_chk = false;
				}
				else{
					txtPwdChk.setForeground(new Color(0, 0, 255));
					txtPwdChk.setText("Password available.");
					Pw_chk = true;
				}
			}
		});
			
			//회원 가입 버튼
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//--------------이벤트 등록 end----------------------
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();	//현재 모니터의 크기를 구하는 객체
		
		setSize(538, 353);
		Dimension frameSize = super.getSize();	//현재 프레임의 크기를 구함
		
		//모니터의 크기에 상관없이 프레임이 항상 화면의 중앙에 오도록 함
		setLocation((screen.width - frameSize.width) / 2, (screen.height - frameSize.height) / 2);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

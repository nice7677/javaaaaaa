package edu.kmi.primejavaC.JWC.View.Form;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import edu.kmi.primejavaC.JWC.Controller.FrontController;
import edu.kmi.primejavaC.JWC.Controller.DAO.MemberDao;
import edu.kmi.primejavaC.JWC.Controller.Event.LoginEvent;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_Form extends Parent_Form{
	private JTextField txtId;
	private JPasswordField txtPw;

	/**
	 * Create the application.
	 */
	public Login_Form(FrontController control) {
		super(1024, 768, control);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login");
		
		//------------컴포넌트 구성------------------
		getContentPane().setLayout(null);
		
		txtId = new JTextField();
		txtId.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		txtId.setBounds(400, 412, 197, 43);
		getContentPane().add(txtId);
		txtId.setColumns(20);
		
		txtPw = new JPasswordField();
		txtPw.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		txtPw.setBounds(400, 482, 197, 43);
		getContentPane().add(txtPw);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnLogin.setBounds(650, 412, 112, 113);
		getContentPane().add(btnLogin);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(242, 409, 112, 43);
		getContentPane().add(lblId);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblPassword.setBounds(242, 482, 112, 43);
		getContentPane().add(lblPassword);
		
		JLabel lblPlease = new JLabel("Please sign in your account");
		lblPlease.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		lblPlease.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlease.setBounds(210, 162, 572, 155);
		getContentPane().add(lblPlease);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnSignUp.setBounds(808, 639, 125, 43);
		getContentPane().add(btnSignUp);
		//--------------컴포넌트 구성 end--------------------------------
		
		//-------------------이벤트 등록--------------------------------
		btnLogin.addActionListener(new LoginEvent(txtId.getText(), txtPw.getPassword()));
		
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp_Form sign_up = new SignUp_Form(getControl());
			}
		});
		
		//-------------------이벤트 등록 end-----------------------------
		
	}
}

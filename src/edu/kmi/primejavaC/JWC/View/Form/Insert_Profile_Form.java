package edu.kmi.primejavaC.JWC.View.Form;

import java.awt.EventQueue;

import javax.swing.JFrame;

import edu.kmi.primejavaC.JWC.Controller.FrontController;
import edu.kmi.primejavaC.JWC.Controller.Event.ProfileInsertEvent;
import edu.kmi.primejavaC.JWC.Model.Member;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class Insert_Profile_Form extends Parent_Form {
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtPhone;
	private JTextField txtCharacter;
	private JTextArea txtIntroduce;
	JRadioButton rdoMale;
	JRadioButton rdoFemale;
	
	Member account;

	/**
	 * Create the frame.
	 */
	public Insert_Profile_Form(FrontController control, Member account) {
		super(550, 800, control);
		setTitle("InsertProfilePage");
		
		this.account = account;
		
		//------------컴포넌트 구성------------------------
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel insert_profile_panel = new JPanel();
		getContentPane().add(insert_profile_panel, BorderLayout.CENTER);
		insert_profile_panel.setLayout(null);
		
		JLabel lblPleaseFillOut = new JLabel("Please fill out the profile below!");
		lblPleaseFillOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseFillOut.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblPleaseFillOut.setBounds(103, 54, 332, 31);
		insert_profile_panel.add(lblPleaseFillOut);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(105, 112, 72, 31);
		insert_profile_panel.add(lblNewLabel);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblAge.setBounds(105, 168, 72, 31);
		insert_profile_panel.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblGender.setBounds(105, 224, 72, 31);
		insert_profile_panel.add(lblGender);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegion.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblRegion.setBounds(105, 282, 72, 31);
		insert_profile_panel.add(lblRegion);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblPhone.setBounds(105, 347, 72, 31);
		insert_profile_panel.add(lblPhone);
		
		JLabel lblIntroduce = new JLabel("Introduce");
		lblIntroduce.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIntroduce.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblIntroduce.setBounds(105, 604, 72, 31);
		insert_profile_panel.add(lblIntroduce);
		
		JLabel lblBloodtype = new JLabel("BloodType");
		lblBloodtype.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBloodtype.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblBloodtype.setBounds(90, 408, 87, 31);
		insert_profile_panel.add(lblBloodtype);
		
		JLabel lblCharacter = new JLabel("Character");
		lblCharacter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCharacter.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblCharacter.setBounds(90, 474, 87, 31);
		insert_profile_panel.add(lblCharacter);
		
		JLabel lblIdealbloodtype = new JLabel("Ideal_BloodType");
		lblIdealbloodtype.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdealbloodtype.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblIdealbloodtype.setBounds(56, 542, 121, 31);
		insert_profile_panel.add(lblIdealbloodtype);
		
		txtName = new JTextField();
		txtName.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtName.setBounds(285, 112, 116, 31);
		insert_profile_panel.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setBounds(285, 168, 116, 31);
		insert_profile_panel.add(txtAge);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtPhone.setColumns(20);
		txtPhone.setBounds(268, 350, 145, 31);
		insert_profile_panel.add(txtPhone);
		
		ButtonGroup group = new ButtonGroup();
		rdoMale = new JRadioButton("Male");
		rdoMale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		rdoMale.setBounds(268, 226, 72, 27);
		insert_profile_panel.add(rdoMale);
		
		rdoFemale = new JRadioButton("Female");
		rdoFemale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		rdoFemale.setBounds(346, 226, 89, 27);
		insert_profile_panel.add(rdoFemale);
		
		group.add(rdoMale);
		group.add(rdoFemale);
		
		JComboBox cboRegion = new JComboBox();
		cboRegion.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		cboRegion.setMaximumRowCount(7);
		cboRegion.setModel(new DefaultComboBoxModel(new String[] {"서울", "경기도", "강원도", "충청도", "경상도", "전라도", "제주도"}));
		cboRegion.setSelectedIndex(0);
		cboRegion.setBounds(268, 284, 145, 31);
		insert_profile_panel.add(cboRegion);
		account.setRegion(cboRegion.getSelectedItem().toString());
		
		JComboBox cboBloodType = new JComboBox();
		cboBloodType.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "O", "AB"}));
		cboBloodType.setSelectedIndex(0);
		cboBloodType.setMaximumRowCount(4);
		cboBloodType.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		cboBloodType.setBounds(268, 408, 145, 31);
		insert_profile_panel.add(cboBloodType);
		account.setBloodT(cboBloodType.getSelectedItem().toString());
		
		JComboBox cboIdeal_BloodType = new JComboBox();
		cboIdeal_BloodType.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "O", "AB"}));
		cboIdeal_BloodType.setSelectedIndex(0);
		cboIdeal_BloodType.setMaximumRowCount(4);
		cboIdeal_BloodType.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		cboIdeal_BloodType.setBounds(268, 547, 145, 31);
		insert_profile_panel.add(cboIdeal_BloodType);
		account.setMyTypeB(cboIdeal_BloodType.getSelectedItem().toString());
		
		txtIntroduce = new JTextArea();
		txtIntroduce.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtIntroduce.setBounds(222, 610, 248, 70);
		insert_profile_panel.add(txtIntroduce);
		
		txtCharacter = new JTextField();
		txtCharacter.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtCharacter.setBounds(285, 479, 116, 31);
		insert_profile_panel.add(txtCharacter);
		txtCharacter.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnInsert.setBounds(213, 703, 105, 27);
		insert_profile_panel.add(btnInsert);
		//------------------컴포넌트 구성 End-----------------------------
		
		//------------------이벤트 등록=--------------------------------
		rdoMale.addItemListener(new RadioListener());
		rdoFemale.addItemListener(new RadioListener());
		
			//지역 선택 콤보박스 이벤트
		cboRegion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox ch = (JComboBox) e.getSource();
				account.setRegion(ch.getSelectedItem().toString());
			}
		});
		
			//자신의 혈액형 선택 콤보박스 이벤트
		cboBloodType.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox ch = (JComboBox) e.getSource();
				account.setRegion(ch.getSelectedItem().toString());
			}
		});
			//상대방 혈액형 선택 콤보박스 이벤트
		cboIdeal_BloodType.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox ch = (JComboBox) e.getSource();
				account.setRegion(ch.getSelectedItem().toString());
			}
		});
		
			//입력 버튼 이벤트
		btnInsert.addActionListener(new ProfileInsertEvent(this));
		
	}
	
	// 프로필을 모두 입력했는지 확인하는 함수
	public boolean insert_Check(){
		if(txtName.getText().length() == 0 || txtAge.getText().length() == 0 ||
				txtPhone.getText().length() == 0 || txtIntroduce.getText().length() == 0 ||
				txtCharacter.getText().length() == 0){
			return false;
		}
		else
			return true;
	}
	
	// 입력한 프로필을 Bean에 담아 리턴하는 함수
	public Member insert_Profile(){
		account.setName(txtName.getText());
		account.setAge(Integer.parseInt(txtAge.getText()));
		account.setPhone(Integer.parseInt(txtPhone.getText()));
		account.setIntro(txtIntroduce.getText());
		account.setMyType(txtCharacter.getText());
		
		return account;
	}
	
	//성별 라디오 버튼 아이템 리스너 클래스
	class RadioListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(rdoMale.isSelected()){
				account.setGender("남자");
			}
			else if(rdoFemale.isSelected()){
				account.setGender("여자");
			}
		}
		
	}
}

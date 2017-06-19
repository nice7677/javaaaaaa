package edu.kmi.primejavaC.JWC.View.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import edu.kmi.primejavaC.JWC.Controller.FrontController;
import edu.kmi.primejavaC.JWC.Controller.Event.SearchEvent;
import edu.kmi.primejavaC.JWC.Model.Member;
import javafx.scene.layout.Border;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;

public class Main_Form extends Parent_Form {
	/**
	 * Create the frame.
	 */
	JPanel panData;
	DefaultTableModel model;
	JTable table;
	final String colName[] = {"아이디", "이름", "나이", "성격", "지역", "소개"};
	private JTextField txtAge_1;
	private JTextField txtAge_2;
	
	public Main_Form(FrontController control, Member info) {
		super(1024, 768, control);
		setInfo(info);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Find your ideal-type!!");
		
		//----------------------컴포넌트 구성-----------------------
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);
		
		JMenuItem miSignout = new JMenuItem("LogOut");
		mnAccount.add(miSignout);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("EditProfile");
		mntmNewMenuItem.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		mnAccount.add(mntmNewMenuItem);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panData = new JPanel();
		panData.setBounds(52, 145, 886, 524);
		panel.add(panData);
		panData.setLayout(new BorderLayout(0, 0));
		
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		JScrollPane scrollPane = new JScrollPane(table);
		panData.add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblGreeting = new JLabel();
		lblGreeting.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreeting.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		lblGreeting.setBounds(709, 30, 229, 43);
		panel.add(lblGreeting);
		lblGreeting.setText(info.getName() + " 님 환영합니다!");
		
		JLabel lblNewLabel = new JLabel("Partner's Infomation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 97, 229, 36);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Message");
		btnNewButton.setBounds(52, 58, 105, 27);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel(" 나이 ");
		lblNewLabel_3.setBounds(595, 108, 44, 22);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		
		txtAge_1 = new JTextField();
		txtAge_1.setBounds(665, 104, 66, 31);
		panel.add(txtAge_1);
		txtAge_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtAge_1.setColumns(10);
		
		txtAge_2 = new JTextField();
		txtAge_2.setBounds(777, 104, 66, 31);
		panel.add(txtAge_2);
		txtAge_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		txtAge_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" ~ ");
		lblNewLabel_2.setBounds(742, 108, 23, 22);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		
		JButton btnSearch = new JButton("검 색");
		btnSearch.setBounds(857, 105, 81, 29);
		panel.add(btnSearch);
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		
			//검색기능
		btnSearch.addActionListener(new SearchEvent(this));
		//---------------------------컴포넌트 구성 End ----------------------------------
		
		//---------------------------이벤트 등록---------------------------------------
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Insert_Profile_Form insert_form = new Insert_Profile_Form(getControl(), info, Insert_Profile_Form.EDIT_MODE);
			}
		});
		
			//로그아웃 기능
		miSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login_Form login = new Login_Form(getControl());
			}
		});
		//----------------------------이벤트 등록 End ------------------------------------
		
		//자신에게 맞는 이성을 랜덤으로 JTable에 출력
		try {
			ArrayList<Member> list = partner_Information();	//자신의 이상형 데이터 가져오는 함수
			make_Component(list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//자신의 이상형 데이터 가져오는 함수
	public ArrayList<Member> partner_Information() throws SQLException{
		String gender;
		ArrayList<Member> list;
		if(getInfo().getGender().equals("남자"))
			gender = "여자";
		else
			gender = "남자";
		
		getControl().open();
		list = getControl().typelist(gender, getInfo().getMyTypeB(), getInfo().getRegion());
		getControl().close();
		
		return list;
	}
	
	public void make_Component(ArrayList<Member> list){
		for(int i = 0; i < list.size(); i++){
			if(list.size() == 0){
				JOptionPane.showMessageDialog(null, "조건에 만족하는 상대방이 없습니다.");
				return;
			}
			String[] row = {list.get(i).getId(), list.get(i).getName(), list.get(i).getAge().toString(), 
					list.get(i).getMyType(), list.get(i).getRegion(), list.get(i).getIntro()};
			
			model.addRow(row);
		}
	}
	
	public int[] getAgeCheck(){
		int age[] = new int[2];
		try{
			age[0] = Integer.parseInt(txtAge_1.getText());
		}catch (NumberFormatException e) {
			age[0] = 0;
		}
		
		try{
			age[1] = Integer.parseInt(txtAge_2.getText());
		}catch (NumberFormatException e){
			age[1] = 10000;
		}
		
		return age;
	}
}
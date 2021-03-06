package edu.kmi.primejavaC.JWC.Controller;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.*;

import edu.kmi.primejavaC.JWC.Model.Member;
import edu.kmi.primejavaC.JWC.View.Form.Insert_Profile_Form;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by JINU on 2017. 6. 8..
 */
public class FrontController {

    private Statement st = null;
    private ResultSet rs = null;
    private Connection con = null;
    private Member mb;
    private static final String URL = "jdbc:mysql://localhost:3306/primejavajwc?useUnicode=true&characterEncoding=utf8";
    private static final String ID = "root";
    private static final String PW = "bitnami";

    public FrontController(){
        mb = new Member();
    }
    
    public void open(){
    	try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, ID, PW);
            st = con.createStatement();
            System.out.println("연결");
        }catch (ClassNotFoundException e){
        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void dataInfo(){
        final String MEMBER_INFO = "SELECT * FROM memberinfo";
        try {
            if (st.execute(MEMBER_INFO)) {
                rs = st.getResultSet();
            }
                while (rs.next()) {
                    mb.setPid(rs.getInt("pid"));
                    mb.setId(rs.getString("id"));
                    mb.setPw(rs.getString("pw"));
                    mb.setName(rs.getString("name"));
                    mb.setGender(rs.getString("gender"));
                    mb.setRegion(rs.getString("region"));
                    mb.setPhone(rs.getInt("phone"));
                    mb.setIntro(rs.getString("intro"));
                    mb.setBloodT(rs.getString("bloodT"));
                    mb.setMyType(rs.getString("myType"));
                    mb.setMyTypeB(rs.getString("myTypeB"));
                    mb.setProfilecheck(rs.getInt("profilecheck"));
                    System.out.println(mb);
                }
        } catch (SQLException test) {
            System.out.println("양혜림때리고싶다");
        }
    }

    public void dataDelete(String id) {
        final String MEMBER_DELETE = "DELETE FROM memberinfo WHERE id = '" + id + "'";
        try {
           int deleteCheck = st.executeUpdate(MEMBER_DELETE);
           if (deleteCheck == 0){
               System.out.println("없는 값입니다.");
           }
           else {
               System.out.println("삭제 완료");
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

        //id 중복확인
    public boolean idCheck(String id) throws SQLException{
        PreparedStatement pstmt;
        int cnt = 0;
        String SQL1 = "SELECT * FROM memberinfo WHERE id='"+ id +"'";
        pstmt = con.prepareStatement(SQL1);
        rs = pstmt.executeQuery();
        while(rs.next()){
            cnt++;
        }
        if(cnt > 0){
            System.out.println("중복");
            return false;
        }else{
            System.out.println("안중복");
            //dataInsert(id,pw); // 여기
            return true;
        }
    }

    public int dataInsert(String id, String pw){
    	int insertCheck = 0;
        final String MEMBER_INSERT = "INSERT INTO memberinfo (id,pw) VALUES ('" + id+ "','"+ pw +"')";
        try {
            insertCheck = st.executeUpdate(MEMBER_INSERT);

            return insertCheck;
        } catch (SQLException e) {
            e.printStackTrace();
            return insertCheck;
        }
    }

    public void dataProfile(String id, String name, Integer age, String gender, String region, Integer phone, String intro, String bloodT, String myType, String myTypeB){
        final String MEMBER_PROFILE = "UPDATE memberinfo SET name = '" + name +  "' , age = " + age + ", gender = '" + gender + "' , region = '" + region + "', phone = " + phone+ ", intro ='" + intro + "', bloodT ='" + bloodT + "', myType = '" + myType + "', myTypeB = '" + myTypeB + "', profilecheck = 1 WHERE id = '" + id + "'";

        try {
            int profileCheck = st.executeUpdate(MEMBER_PROFILE);
            if (profileCheck == 0){
                System.out.println("입력이 안 됐어요");
            }else{
                System.out.println("잘 됐어요");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Member checkUser(String id, String pw) throws SQLException{
    	Member info = new Member();
    	int cnt = 0;
    	FrontController control = new FrontController();
    	final String MEMBER_LOGIN = "SELECT * FROM memberinfo WHERE id = '" + id + "' AND pw = '" + pw + "'";
    	PreparedStatement pstmt;
        pstmt = con.prepareStatement(MEMBER_LOGIN);
        rs = pstmt.executeQuery();
        while(rs.next()){
        	cnt++;
        	info.setPid(rs.getInt("pid"));
        	info.setId(rs.getString("id"));
        	info.setPw(rs.getString("pw"));
        	info.setName(rs.getString("name"));
        	info.setAge(rs.getInt("age"));
        	info.setGender(rs.getString("gender"));
        	info.setRegion(rs.getString("region"));
        	info.setPhone(rs.getInt("phone"));
        	info.setIntro(rs.getString("intro"));
        	info.setBloodT(rs.getString("bloodT"));
        	info.setMyType(rs.getString("myType"));
        	info.setMyTypeB(rs.getString("myTypeB"));
        	info.setProfilecheck(rs.getInt("profilecheck"));
        }
        if(cnt == 0){
        	return null;
        }
        else{
        	return info;
        }
    }
    
    public Map typelist(String gender, String blood, String region) throws SQLException{
    	
		Map<Integer, Member> list = new HashMap<Integer, Member>();
    	final String TYPE_LIST = "select * from memberinfo WHERE gender = '" + gender +"' AND bloodT = '" + blood +"' AND region = '" + region +"' order by rand() limit 5";
    	PreparedStatement pstmt;
        pstmt = con.prepareStatement(TYPE_LIST);
        rs = pstmt.executeQuery();
        int count = 0;
        while(rs.next()){
        	Member info = new Member();
        	info.setPid(rs.getInt("pid"));
        	info.setName(rs.getString("name"));
        	info.setAge(rs.getInt("age"));
        	info.setGender(rs.getString("gender"));
        	info.setRegion(rs.getString("region"));
        	info.setIntro(rs.getString("intro"));
        	list.put(count, info);
        	count++;
        }
        for (int i = 0; i < 5; i++){
        	System.out.println(list.get(i));
        }
    	return list;
    }
    
    public Member delete(String id, String pw) throws SQLException{
    	Member info = new Member();
    	final String USER_CHECK = "SELECT * FROM memberinfo WHERE id = '" + id + "'";
    	final String USER_DELETE = "DELETE FROM memberinfo WHERE id = '" + id +"' AND pw = '" + pw + "'";
    	int count = 0;
    	PreparedStatement pstmt;
    	pstmt = con.prepareStatement(USER_CHECK);
        rs = pstmt.executeQuery();
        while(rs.next()){
            count++;
            info.setPw(rs.getString("pw"));
        }
    	if ( count == 1){	
    		if ( info.getPw().equals(pw)){
    			st.execute(USER_DELETE);
        		System.out.println("아이디삭제");
    		}else{
    			System.out.println("비밀번호 확인");
    		}
    	}else{
    		System.out.println("아이디업슴");
    	}
    	return info;
    }
    
    public void close(){
    	try {
			con.close();
			st = null;
			rs = null;
			System.out.println("연결 종료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}




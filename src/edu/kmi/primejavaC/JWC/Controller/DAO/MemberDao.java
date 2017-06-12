package edu.kmi.primejavaC.JWC.Controller.DAO;

import javax.swing.*;

import edu.kmi.primejavaC.JWC.Model.Member;

import java.sql.*;

/**
 * Created by JINU on 2017. 6. 8..
 */
public class MemberDao {

    private Statement st = null;
    private ResultSet rs = null;
    private Connection con = null;
    private Member mb = new Member();
    private static final String URL = "jdbc:mysql://localhost:3306/primejavajwc?useUnicode=true&characterEncoding=utf8";
    private static final String ID = "root";
    private static final String PW = "bitnami";

    public MemberDao(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, ID, PW);
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
            st = con.createStatement();
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
            st = con.createStatement();
           int deleteCheck = st.executeUpdate(MEMBER_DELETE);
           if (deleteCheck == 0){
               System.out.println("없는 값입니다.");
           }else {
               System.out.println("삭제 완료");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

        //중복확인하고 입력으로
    public void idCheck(String id, String pw) throws SQLException{
        PreparedStatement pstmt;
        ResultSet rs = null;
        int cnt = 0;
        String SQL1 = "SELECT * FROM memberinfo WHERE id='"+ id +"'";
        pstmt = con.prepareStatement(SQL1);
        rs = pstmt.executeQuery();
        while(rs.next()){
            cnt++;
        }
        if(cnt > 0){
            System.out.println("중복");
        }else{
            System.out.println("안중복");
            //dataInsert(id,pw); // 여기
        }
    }

    public void dataInsert(String id, String pw){
        final String MEMBER_INSERT = "INSERT INTO memberinfo (id,pw) VALUES ('" + id+ "','"+ pw +"')";
        try {
            st = con.createStatement();
            int insertCheck = st.executeUpdate(MEMBER_INSERT);
            if (insertCheck == 0) {
                //idCheck(id);
                System.out.println("재대로 입력하라");
            }else {
                System.out.println(id + "계정 등록완료");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dataProfile(String id, String name, Integer age, String gender, String region, Integer phone, String intro, String bloodT, String myType, String myTypeB){
        final String MEMBER_PROFILE = "UPDATE memberinfo SET name = '" + name +  "' , age = " + age + ", gender = '" + gender + "' , region = '" + region + "', phone = " + phone+ ", intro ='" + intro + "', bloodT ='" + bloodT + "', myType = '" + myType + "', myTypeB = '" + myTypeB + "', profilecheck = 1 WHERE id = '" + id + "'";

        try {
            st = con.createStatement();
            int profileCheck = st.executeUpdate(MEMBER_PROFILE);
            if (profileCheck == 0){
                System.out.println("입력이안됬어요");
            }else{
                System.out.println("잘됬어요");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }




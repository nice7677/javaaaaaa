package edu.kmi.primejavaC.JWC.Model;

import java.sql.*;

/**
 * Created by JINU on 2017. 6. 8..
 */
public class Member {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private Integer pid;
    private String id;
    private String pw;
    private String name;
    private String gender;
    private String region;
    private Integer phone;
    private String intro;
    private String bloodT;
    private String myType;
    private String myTypeB;
    private Integer profilecheck;

    @Override
    public String toString() {
        return "MemberDataAccess{" +
                "pid=" + pid +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", region='" + region + '\'' +
                ", phone=" + phone +
                ", intro='" + intro + '\'' +
                ", bloodT='" + bloodT + '\'' +
                ", myType='" + myType + '\'' +
                ", myTypeB='" + myTypeB + '\'' +
                ", profilecheck=" + profilecheck +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getBloodT() {
        return bloodT;
    }

    public void setBloodT(String bloodT) {
        this.bloodT = bloodT;
    }

    public String getMyType() {
        return myType;
    }

    public void setMyType(String myType) {
        this.myType = myType;
    }

    public String getMyTypeB() {
        return myTypeB;
    }

    public void setMyTypeB(String myTypeB) {
        this.myTypeB = myTypeB;
    }

    public Integer getProfilecheck() {
        return profilecheck;
    }

    public void setProfilecheck(Integer profilecheck) {
        this.profilecheck = profilecheck;
    }

    public Member(){

    }

    public Member(String id, String pw, String name, String gender, String region, Integer phone, String intro, String bloodT, String myType, String myTypeB) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.region = region;
        this.phone = phone;
        this.intro = intro;
        this.bloodT = bloodT;
        this.myType = myType;
        this.myTypeB = myTypeB;
    }

    public Member(String intro, String myType, String myTypeB) {
        this.intro = intro;
        this.myType = myType;
        this.myTypeB = myTypeB;
    }


}

package edu.kmi.primejavaC.JWC.Model;

import java.sql.SQLException;

import edu.kmi.primejavaC.JWC.Controller.FrontController;

/**
 * Created by JINU on 2017. 6. 8..
 */
public class DB_Test {
    public static void main(String[] args) throws SQLException {
        FrontController dao = new FrontController();
        //dao.idCheck("tes2t", "testtest");
        dao.open();
        dao.delete("test23", "123");
        //dao.checkUser("test", "test");
        //dao.typelist("남자", "B", "서울");
        dao.close();
        //dao.dataDelete("test");
        //dao.dataProfile("test", "진우짱", 25, "여자", "서울", 1088387684,"안녕하세요반가워요","B","죽어","AB");
    }
}

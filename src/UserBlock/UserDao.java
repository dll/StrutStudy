package UserBlock;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Richard on 2017/6/16.
 */
public class UserDao implements BaseDAO {
    private String url = "jdbc:mysql://localhost:3306/struts";
    private String user = "root";
    private String password = "root";


    @Override
    public boolean insert(User Add) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String sql = "insert into userinfo(usrname,password)Values(?,?)";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, Add.getUsername());
        pst.setString(2, Add.getPassword());
        int i = pst.executeUpdate();
        if (i >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection select() throws Exception {
        ArrayList al = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        String sql = "select * from userinfo";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            User Get = new User();
            Get.setUsername(rs.getString("username"));
            Get.getInfomation().setEmail(rs.getString("email"));
            Get.getInfomation().setNickname(rs.getString("nickname"));
            Get.getInfomation().setPhone(rs.getString("phone"));
            al.add(Get);
        }
        return al;
    }

    @Override
    public boolean delete(User Add) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String sql = "delete from userinfo where username=?";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, Add.getUsername());
        int i = pst.executeUpdate();
        if (i >= 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public ArrayList up_select(User Add) throws Exception {
        ArrayList al = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        String sql = "select * from userinfo where username=?";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, Add.getUsername());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            User Get = new User();
            Get.setUsername(rs.getString("username"));
            Get.getInfomation().setEmail(rs.getString("email"));
            Get.getInfomation().setNickname(rs.getString("nickname"));
            Get.getInfomation().setPhone(rs.getString("phone"));
            al.add(Get);
        }
        return al;
    }

    @Override
    public boolean update(User Add) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String sql = "update userinfo set password=?,email=?,nickname=?,phone=? where username=?";
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, Add.getUsername());
        int i = pst.executeUpdate();
        if (i >= 1) {
            return true;
        } else {
            return false;

        }
    }
}

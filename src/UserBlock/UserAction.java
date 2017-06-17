package UserBlock;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.logging.LogManager;

/**
 * Created by Richard on 2017/6/16.
 */
public class UserAction extends ActionSupport {
    private  User user;
    private String INDEX="index";
    private String LOGIN="login";
    private  String REG="register";
    private UserDao userlist;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAction(){
        user.setUsername(username);
        user.setPassword(password);
    }



    public String login(){
        try{
            ArrayList logusr=userlist.up_select(user);
            if(logusr.size()>=1){
                User log= (User) logusr.get(0);
                if(password.equals(log.getPassword())){
                    UserManagment.login(log);
                    return INDEX;
                }else{
                    addActionMessage("您输入的用户名或密码错误");
                    return LOGIN;
                }
            }else{
                addActionMessage("该用户不存在，正在跳转到注册页面");
                return REG;
            }
        }catch (Exception e){
            addActionError(e.getMessage());
        }

        return LOGIN;
    }
}

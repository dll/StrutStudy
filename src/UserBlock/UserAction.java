package UserBlock;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.LogManager;

/**
 * Created by Richard on 2017/6/16.
 * 继承ActionSupport实现一个Action
 * 登陆界面通过loginuser.action调用login()方法来处理数据
 *          login()方法中通过ActionContext调用Session对象，存入输入错误的数据
 *          通过addActionMessage()方法向页面输出相关信息
 * 注册页面通过reguser.action调用reg()方法来处理数据
 */
public class UserAction extends ActionSupport {
    private String INDEX="index";
    private String LOGIN="login";
    private  String REG="register";
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


    public String login(){
        try{
            if(username.equals("rekent")){
                if(password.equals("root")){
                    /*登陆成功*/
                    return INDEX;
                }else{
                    ActionContext applicton=ActionContext.getContext();
                    Map session=applicton.getSession();
                    int count;
                    if(session.get("count")==null){
                        count=0;
                    }else{
                        count= (int) session.get("count");
                    }
                    if(count>=3){
                        addActionMessage("错误次数过多");
                        count=0;
                        session.put("count",count);
                        return LOGIN;
                    }else{
                        count++;
                        addActionMessage("您输入的用户名或密码错误"+count);
                        session.put("count",count);
                        return LOGIN;
                    }

                }
            }else{
                addActionMessage("该用户不存在，已经跳转到注册页面");
                return REG;
            }
        }catch (Exception e){
            addActionError(e.getMessage());
        }

        return LOGIN;
    }


    public String reg(){
        try{
            if(username.equals("rekent"))
            {
                addActionMessage("该用户已经存在");
                return REG;
            }
            else{
                return INDEX;
            }
        }catch (Exception e){
                addActionError(e.getMessage());
        }
        return REG;
    }
}

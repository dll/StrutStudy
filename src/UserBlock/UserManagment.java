package UserBlock;

import com.opensymphony.xwork2.ActionContext;
import javafx.application.Application;
import org.apache.struts2.views.util.ContextUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;

/**
 * Created by Richard on 2017/6/16.
 */
public class UserManagment {
    static class UserListener implements HttpSessionBindingListener{
        User user;

        public User getCurrentUser(){
            return user;
        }

        @Override
        public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
            HttpSession session=httpSessionBindingEvent.getSession();
            ServletContext application=session.getServletContext();
            ArrayList online= (ArrayList) application.getAttribute("online");
            if(online==null){
                online=new ArrayList();
            }
            online.add(this.user);
            application.setAttribute("online",online);
        }

        @Override
        public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
            HttpSession session=httpSessionBindingEvent.getSession();
            ServletContext appliaction=session.getServletContext();
            ArrayList online= (ArrayList) appliaction.getAttribute("online");
            online.remove(user);
        }
    }

    private static HttpSession currentSession(){
        return (HttpSession) ActionContext.getContext().getSession();
    }

    public static void login(User user){
        HttpSession session=currentSession();
        UserListener listener=new UserListener();
        listener.user=user;
        session.setAttribute("LOGIN_FLAG",listener);
    }

    public static  void loginout(){
        HttpSession session=currentSession();
        if(session==null){
            return;
        }
        session.removeAttribute("LOGIN_FLAG");
        session.invalidate();
    }

    public static  ArrayList onlineList(){
        HttpSession session=currentSession();
        ServletContext application=session.getServletContext();
        ArrayList list= (ArrayList) application.getAttribute("online");
        return list;
    }

    public static int online_num(){
        HttpSession session=currentSession();
        ServletContext application=session.getServletContext();
        ArrayList list= (ArrayList) application.getAttribute("online");
        return list.size();
    }





}

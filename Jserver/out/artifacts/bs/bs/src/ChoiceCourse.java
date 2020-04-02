
import Dao.CourseChoice;
import Dao.UserDao;
import Dao.UserSelect;
import com.alibaba.fastjson.JSON;
import model.Course;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChoiceCourse",urlPatterns = "/ChoiceCourse")
public class ChoiceCourse extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("登录p");
        //request.setCharacterEncoding("UTF-8");
        System.out.println("登录p2");
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonStr = null;
        StringBuilder result = new StringBuilder();
        try {
            while ((jsonStr = reader.readLine()) != null) {
                result.append(jsonStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();// 关闭输入流
        System.out.println(result.toString()+"55546");
        System.out.println("登录p3");
        Course courses = JSON.parseObject(result.toString(), Course.class);
        response.setContentType("application/josn;charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        try {
            List<User> users = CourseChoice.ChoiceCourse(courses.getCid());
            if(!users.isEmpty())
            {
                System.out.println("open1");
                PrintWriter out=null;
                out=response.getWriter();
                out.write(JSON.toJSONString(users));
                out.close();
                System.out.println("end1");
            }
            else
            {
                System.out.println("open2");
                PrintWriter out=null;
                out=response.getWriter();
                out.write(JSON.toJSONString(users));
                out.close();
                System.out.println("end2");
            }
            doGet(request, response);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("登录g");
    }
}

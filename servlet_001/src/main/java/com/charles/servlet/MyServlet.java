package com.charles.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chales.tang
 * @title MyServlet
 * @discription
 * @date 2020/8/2 9:01 上午
 */
@WebServlet("/")
public class MyServlet extends HttpServlet {

    private int count = 0;

    public MyServlet(){
        System.out.println("MyServlet 无参构造函数被执行...");
    }

    /** Servlet 为单例, 线程不安全
     * @Discription
     * @param req
     * @param resp
     * @Return void
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        resp.getWriter().write("This is my servlet,count = " + count);
        // 发送多次请求 count在累计，说明count是共享的，所以为单例
    }
}

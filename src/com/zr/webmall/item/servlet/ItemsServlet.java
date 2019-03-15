package com.zr.webmall.item.servlet;

import com.zr.webmall.item.dao.ItemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: LiGX
 * @Date: 2019/3/15
 */
@WebServlet("/ItemsServlet")
public class ItemsServlet extends HttpServlet {
    private ItemDao dao = new ItemDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("add".equals(method)){
            add(request,response);
        }else if("delete".equals(method)){
            delete(request,response);
        }else if("query".equals(method)){
            query(request,response);
        }else if("update".equals(method)){
            update(request,response);
        }else if("queryOne".equals(method)){
            queryOne(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void add(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String price = req.getParameter("price");
        String number = req.getParameter("number");
        String picture = req.getParameter("picture");
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("city",city);
        map.put("price",price);
        map.put("number",number);
        map.put("picture",picture);
        int i = dao.add(map);
        resp.sendRedirect(req.getContextPath()+"/ItemsServlet?method=query");
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String id = req.getParameter("id");
        dao.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath()+"/ItemsServlet?method=query");
    }


    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> all = dao.findAll();
        req.setAttribute("all",all);
        req.getRequestDispatcher("/query.jsp").forward(req,resp);
    }

    private void queryOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Map<String, Object> map = dao.queryOne(Integer.parseInt(id));
        req.setAttribute("map",map);
        req.getRequestDispatcher("/queryOne.jsp").forward(req,resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String price = req.getParameter("price");
        String number = req.getParameter("number");
        String picture = req.getParameter("picture");
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("city",city);
        map.put("price",price);
        map.put("number",number);
        map.put("picture",picture);
        int i = dao.update(map);
        resp.sendRedirect(req.getContextPath()+"/ItemsServlet?method=query");
    }

}

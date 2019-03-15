package com.zr.webmall.item.servlet;

import com.zr.webmall.framework.PageBean;
import com.zr.webmall.item.dao.ItemsDao;
import com.zr.webmall.item.entity.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-03-15 上午 10:21
 */
@WebServlet( "/ItemssServlet")
public class ItemssServlet extends HttpServlet {
    private  ItemsDao dao =new ItemsDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("add".equals(method)){
            add(request,response);
        }else if("delete".equals(method)){
            delete(request,response);
        }else if("query".equals(method)){
            page(request, response);
        }else if("update".equals(method)){
            update(request,response);
        }else if("queryOne".equals(method)){
            queryOne(request,response);
        }
    }

    private void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageIndex=1;
        int pageCount=10;
        if (request.getParameter("pageIndex")!=null){
            pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
        }
        PageBean<Items> pageBean = dao.queryPageBean(pageIndex,pageCount);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/query.jsp").forward(request,response);
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
        Items items=new Items(Integer.parseInt(id),name,city,Integer.parseInt(price),Integer.parseInt(number),picture);
        dao.add(items);
        resp.sendRedirect(req.getContextPath()+"/ItemssServlet?method=query");
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String id = req.getParameter("id");
        dao.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath()+"/ItemssServlet?method=query");
    }
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Items> all = dao.findAll();
        req.setAttribute("all",all);
        req.getRequestDispatcher("/query.jsp").forward(req,resp);
    }
    private void queryOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Items items = dao.queryOne(Integer.parseInt(id));
        req.setAttribute("items",items);
        req.getRequestDispatcher("/queryOne.jsp").forward(req,resp);
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String price = req.getParameter("price");
        String number = req.getParameter("number");
        String picture = req.getParameter("picture");
        Items items=new Items(Integer.parseInt(id),name,city,Integer.parseInt(price),Integer.parseInt(number),picture);
        dao.update(items);
        resp.sendRedirect(req.getContextPath()+"/ItemssServlet?method=query");
    }
}

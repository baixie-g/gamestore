package com.ccxg.web;

import com.ccxg.bean.Game;
import com.ccxg.bean.Page;
import com.ccxg.service.GameService;
import com.ccxg.service.impl.GameServiceImpl;
import com.ccxg.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ccxg
 * @create 2024-08-26 15:38
 */
public class ClientGameServlet extends BaseServlet {

    private GameService gameService = new GameServiceImpl();


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2、调用GameService.page(pageNo,pageSize)方法：返回page对象
        Page<Game> page = gameService.page(pageNo,pageSize);
        page.setUrl("client/gameServlet?action=page");
        //3、保存Page对象到request域中
        req.setAttribute("page",page);
        //4、请求转发到page/manager/game_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByNameOrAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNo和pageSize、nameorauthor
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
       String nameOrAuthor = req.getParameter("nameorauthor");

        //2、调用GameService.page(pageNo,pageSize)方法：返回page对象
        Page<Game> page = gameService.pageByNameOrAuthor(pageNo,pageSize,nameOrAuthor);

        StringBuilder sb = new StringBuilder("client/gameServlet?action=pageByNameOrAuthor");
        if(req.getParameter("nameorauthor")!=null) {
            sb.append("&nameorauthor=").append(req.getParameter("nameorauthor"));
        }
        page.setUrl(sb.toString());
        //3、保存Page对象到request域中
        req.setAttribute("page",page);
        //4、请求转发到page/manager/game_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNo和pageSize、min、max
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        //2、调用GameService.page(pageNo,pageSize)方法：返回page对象
        Page<Game> page = gameService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder sb = new StringBuilder("client/gameServlet?action=pageByPrice");
        if(req.getParameter("min")!=null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //3、保存Page对象到request域中
        req.setAttribute("page",page);
        //4、请求转发到page/manager/game_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
       //这里直接写死为50
        //2、调用GameService.page(pageNo,pageSize)方法：返回page对象
        Page<Game> page = gameService.pageOrder();
        page.setUrl("client/gameServlet?action=pageOrder");
        //3、保存Page对象到request域中
        req.setAttribute("page",page);
        //4、请求转发到page/manager/game_manager.jsp页面
        req.getRequestDispatcher("/pages/client/top.jsp").forward(req,resp);
    }
}

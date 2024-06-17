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
import java.util.List;

/**
 * @author ccxg
 * @create 2024-08-24 15:25
 */
public class GameServlet extends BaseServlet {

    private GameService gameService = new GameServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        Game game = (Game) WebUtils.copyParamToBean(req.getParameterMap(),new Game());
        gameService.addGame(game);
        //req.getRequestDispatcher("/manager/gameServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/manager/gameServlet?action=page&pageNo="+pageNo);
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id");
       int i = Integer.parseInt(id);
       gameService.deleteGameById(i);
       resp.sendRedirect(req.getContextPath() + "/manager/gameServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Game game = (Game) WebUtils.copyParamToBean(req.getParameterMap(),new Game());
        gameService.updateGame(game);
        resp.sendRedirect(req.getContextPath() + "/manager/gameServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getGame(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        Game game = gameService.queryGameById(i);
        req.setAttribute("game", game);
        req.getRequestDispatcher("/pages/manager/Game_edit.jsp").forward(req,resp);
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、通过GameService查询数据
        List<Game> games = gameService.queryGames();
        //2、将数据保存在request域中
        req.setAttribute("games", games);
        //3、请求转发到pages/manager/game_manager.jsp
        req.getRequestDispatcher("/pages/manager/game_manager.jsp").forward(req,resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2、调用GameService.page(pageNo,pageSize)方法：返回page对象
        Page<Game> page = gameService.page(pageNo,pageSize);
        page.setUrl("manager/gameServlet?action=page");

        //3、保存Page对象到request域中
        req.setAttribute("page",page);
        //4、请求转发到page/manager/game_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/game_manager.jsp").forward(req,resp);
    }
}

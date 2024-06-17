package com.ccxg.service.impl;

import com.ccxg.bean.Game;
import com.ccxg.bean.Page;
import com.ccxg.dao.GameDao;
import com.ccxg.dao.impl.GameDaoImpl;
import com.ccxg.service.GameService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ccxg
 * @create 2024-08-24 14:50
 */
public class GameServiceImpl implements GameService {


    private GameDao gameDao = new GameDaoImpl();

    @Override
    public void addGame(Game game) {
        gameDao.addGame(game);
    }

    @Override
    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    @Override
    public void deleteGameById(Integer id) {
        gameDao.deleteGameById(id);
    }

    @Override
    public Game queryGameById(Integer id) {
        return gameDao.queryGameById(id);
    }

    @Override
    public List<Game> queryGames() {
        return gameDao.queryGames();
    }

    @Override
    public Page<Game> page(int pageNo, int pageSize) {
        Page<Game> page = new Page<Game>();

        //设置每页记录数
        page.setPageSize(pageSize);

        //设置总记录数
        Integer pageTotalCount = gameDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize >0) {
            pageTotal+=1;
        }
        //设置当前页
        if(pageNo>pageTotal) {
            pageNo = pageTotal;
        }
        if(pageNo<1) {
            pageNo = 1;
        }
        page.setPageNo(pageNo);
        //设置总页码
        page.setPageTotal(pageTotal);


        int begin = (page.getPageNo() -1)*pageSize;
        List<Game> items = gameDao.queryForPageItems(begin,pageSize);
        page.setItems(items);

         return page;
    }

    @Override
    public Page<Game> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Game> page = new Page<Game>();

        //设置每页记录数
        page.setPageSize(pageSize);

        //设置总记录数
        Integer pageTotalCount = gameDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize >0) {
            pageTotal+=1;
        }
        //设置当前页
        if(pageNo>pageTotal) {
            pageNo = pageTotal;
        }
        if(pageNo<1) {
            pageNo = 1;
        }
        page.setPageNo(pageNo);
        //设置总页码
        page.setPageTotal(pageTotal);


        int begin = (page.getPageNo() -1)*pageSize;
        List<Game> items = gameDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Game> pageByNameOrAuthor(int pageNo, int pageSize, String nameorauthor) {
        Page<Game> page = new Page<Game>();

        //设置每页记录数
        page.setPageSize(pageSize);

        //设置总记录数
        Integer pageTotalCount = gameDao.queryForPageTotalCountByNameOrAuthor(nameorauthor);
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize >0) {
            pageTotal+=1;
        }
        //设置当前页
        if(pageNo>pageTotal) {
            pageNo = pageTotal;
        }
        if(pageNo<1) {
            pageNo = 1;
        }
        page.setPageNo(pageNo);
        //设置总页码
        page.setPageTotal(pageTotal);


        int begin = (page.getPageNo() -1)*pageSize;
        List<Game> items = gameDao.queryForPageItemsByNameOrAuthor(begin,pageSize,nameorauthor);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Game> pageOrder() {
        Page<Game> page = new Page<Game>();
        List<Game> items = gameDao.queryForPageItemsOrder();
        page.setItems(items);

        return page;
    }

    @Override
    public Integer queryTotalGames() {
        return gameDao.queryGamenums();
    }

    @Override
    public BigDecimal queryTotalMoney() {
        return gameDao.queryTotalMoney();
    }


}

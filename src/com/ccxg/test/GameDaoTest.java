package com.ccxg.test;

import com.ccxg.bean.Game;
import com.ccxg.dao.GameDao;
import com.ccxg.dao.impl.GameDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author ccxg
 * @create 2024-08-24 11:01
 */
public class GameDaoTest {
    GameDao gameDao = new GameDaoImpl();

    @Test
    public void addGame() {
        //`name`,`author`,`classification`,`price`,`sales`,`stock`,`img_path`
        //Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String classification, String imgPath)
        gameDao.addGame(new Game(null,"舌的中国","yjjj",new BigDecimal("5"),100,23,"",""));
    }

    @Test
    public void deleteGame() {
        gameDao.deleteGameById(3);
    }

    @Test
    public void queryById() {
        System.out.println(gameDao.queryGameById(64));
    }

    @Test
    public void update() {
        gameDao.updateGame(new Game(35,"舌尖的中国","ccxg",new BigDecimal("5"),100,23,"文学",""));
    }

    @Test
    public void queryList() {
        System.out.println(gameDao.queryGames());
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(gameDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(gameDao.queryForPageItems(1,4));
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(gameDao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        System.out.println(gameDao.queryForPageItemsByPrice(1,4,10,50));
    }

    @Test
    public void queryGamenums() {
        System.out.println(gameDao.queryGamenums());
    }
}

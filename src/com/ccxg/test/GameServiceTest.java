package com.ccxg.test;

import com.ccxg.bean.Game;
import com.ccxg.dao.GameDao;
import com.ccxg.dao.impl.GameDaoImpl;
import com.ccxg.service.GameService;
import com.ccxg.service.impl.GameServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author ccxg
 * @create 2024-08-24 14:57
 */
public class GameServiceTest {

    private GameDao gameDao = new GameDaoImpl();
    private GameService gameService = new GameServiceImpl();
    @Test
    public void addGame() {
        gameDao.addGame(new Game(null,"舌尖上的中国","ccxg",new BigDecimal("5"),100,23,"文学",""));
    }

    @Test
    public void updateGame() {
        gameDao.updateGame(new Game(null,"舌尖上的中国","ccxg",new BigDecimal("5"),100,23,"文学",""));
    }

    @Test
    public void deleteGameById() {
        System.out.println(gameDao.deleteGameById(25));
    }

    @Test
    public void queryGameById() {
        System.out.println(gameDao.queryGameById(23));
    }

    @Test
    public void queryGames() {
        System.out.println(gameDao.queryGames());
    }

    @Test
    public void page() {
        System.out.println(gameDao.queryForPageTotalCount());
    }

    @Test
    public void queryTotalMoney() {
        System.out.println(gameDao.queryTotalMoney());
    }
}

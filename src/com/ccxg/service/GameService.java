package com.ccxg.service;

import com.ccxg.bean.Game;
import com.ccxg.bean.Page;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ccxg
 * @create 2024-08-24 14:40
 */
public interface GameService {

    public void addGame(Game game);

    public void updateGame(Game game);

    public void deleteGameById(Integer id);

    public Game queryGameById(Integer id);

    public List<Game> queryGames();

    Page<Game> page(int pageNo, int pageSize);

    Page<Game> pageByPrice(int pageNo, int pageSize, int min, int max);

    Page<Game> pageByNameOrAuthor(int pageNo, int pageSize, String nameOrAuthor);

    Page<Game> pageOrder();

    public Integer queryTotalGames();

    BigDecimal queryTotalMoney();
}

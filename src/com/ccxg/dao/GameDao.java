package com.ccxg.dao;

import com.ccxg.bean.Game;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ccxg
 * @create 2024-08-23 21:08
 */
public interface GameDao {

    public int addGame(Game game);

    public int deleteGameById(Integer id);

    public int updateGame(Game game);

    public Game queryGameById(Integer id);

    public List<Game> queryGames();

    Integer queryForPageTotalCount();

    List<Game> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Game> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);

    Integer queryForPageTotalCountByNameOrAuthor(String nameorauthor);

    List<Game> queryForPageItemsByNameOrAuthor(int begin, int pageSize, String nameorauthor);

    List<Game> queryForPageItemsOrder();

    BigDecimal queryTotalMoney();

    public Integer queryGamenums();
}

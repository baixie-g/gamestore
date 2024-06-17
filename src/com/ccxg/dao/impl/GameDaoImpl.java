package com.ccxg.dao.impl;

import com.ccxg.bean.Game;
import com.ccxg.dao.GameDao;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ccxg
 * @create 2024-08-23 21:38
 */
public class GameDaoImpl extends BaseDao implements GameDao {

    @Override
    public int addGame(Game game) {
        String sql = "insert into t_game(`name`,`author`,`classification`,`price`,`sales`,`stock`,`imgpath`) values(?,?,?,?,?,?,?)";
        return update(sql, game.getName(), game.getAuthor(), game.getClassification(), game.getPrice(), game.getSales(), game.getStock(), game.getImgPath());
    }

    @Override
    public int deleteGameById(Integer id) {
        String sql = "delete from t_game where id=?";
        return update(sql,id);
    }

    @Override
    public int updateGame(Game game) {
        String sql = "update t_game set `name`=?,`author`=?,`classification`=?,`price`=?,`sales`=?,`stock`=?,`imgpath`=? where id=?";
        return update(sql, game.getName(), game.getAuthor(), game.getClassification(), game.getPrice(), game.getSales(), game.getStock(), game.getImgPath(), game.getId());
    }

    @Override
    public Game queryGameById(Integer id) {
        String sql = "select * from t_game where id = ?";
        return queryForOne(Game.class,sql,id);
    }

    @Override
    public List<Game> queryGames() {
        String sql = "select * from t_game";
        return queryForList(Game.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_game";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Game> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from t_game limit ?,?";
        return queryForList(Game.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_game where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Game> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select * from t_game where price between ? and ? limit ?,?";
        return queryForList(Game.class,sql,min,max,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByNameOrAuthor(String nameorauthor) {
        nameorauthor = "%" + nameorauthor + "%";
        String sql = "select count(*) from t_game where name like ? or author like ?";
        Number count = (Number) queryForSingleValue(sql,nameorauthor,nameorauthor);
        return count.intValue();
    }

    @Override
    public List<Game> queryForPageItemsByNameOrAuthor(int begin, int pageSize, String nameorauthor) {
        nameorauthor = "%" + nameorauthor + "%";
        String sql = "select * from t_game where name like ? or author like ? limit ?,?";
        return queryForList(Game.class,sql,nameorauthor,nameorauthor,begin,pageSize);
    }

    @Override
    public List<Game> queryForPageItemsOrder() {
        String sql = "SELECT * FROM t_game ORDER BY `sales` DESC LIMIT 1,50";
        return queryForList(Game.class,sql);
    }

    @Override
    public BigDecimal queryTotalMoney() {
        String sql = "SELECT SUM(price*sales) from t_game";
        return (BigDecimal) queryForSingleValue(sql);
    }

    @Override
    public Integer queryGamenums() {
        String sql = "SELECT SUM(sales) FROM t_game";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }


}

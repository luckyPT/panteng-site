package com.site.panteng.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.site.panteng.entity.Article;

@Repository
public class ArticleDao {
	private static Logger logger = Logger.getLogger(ArticleDao.class);
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public int addArticle(Article article){
		try {
			String sql = "insert into article(fileName,title,summary,nickName,pubTime,tags) " +
					"values("+article.getFileName()+","+article.getTitle()+","+article.getSummary()+","
					+article.getNickName()+","+article.getPubTime()+","+article.getTags()+")";
			return jdbcTemplate.update(sql);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("{增加文章异常}",e);
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void main(String[] arges) {
		Article article = new Article(1,"12","12","12","121","1212","21");
		new ArticleDao().addArticle(article);
	}
}

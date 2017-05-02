package com.site.panteng.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.common.base.Strings;
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
	
	public List<Article> getArticles(String userName,int pageNum,int listCount){
		String sql = "";
		if(Strings.isNullOrEmpty(userName)){
			sql="select * from article limit "+(pageNum-1)*listCount + ", "+ listCount;
		}else {
			sql="select * from article where nickName = '" + userName+ "' " + (pageNum-1)*listCount + ", "+ listCount;
		}
		
		List articles =  jdbcTemplate.queryForList(sql);
		Iterator iterator = articles.iterator();
		while (iterator.hasNext()) {
			Map articleMap = (Map)iterator.next();
			Article article = new Article();
			article.setTitle((String)articleMap.get("title"));
			article.setSummary((String)articleMap.get("summary"));
		}
		return articles;
		
	}
	public static void main(String[] arges) {
		Article article = new Article(1,"12","12","12","121","1212","21");
		new ArticleDao().addArticle(article);
	}
}

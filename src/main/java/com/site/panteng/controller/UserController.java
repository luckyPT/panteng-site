package com.site.panteng.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.site.panteng.dao.ArticleDao;
import com.site.panteng.entity.Article;
import com.site.panteng.entity.Constants;
import com.site.panteng.util.FileUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	ArticleDao articleDao;
	
	@RequestMapping("{userName}/addArticle")
	public void addArticle(HttpServletRequest req, HttpServletResponse resp, String content1,@PathVariable String userName){
		String article_html = Constants.ARTICLE_TEMPLATE;
        String realPath = req.getSession().getServletContext().getRealPath("/");

        String filePath = realPath + "attached/html/"+userName+"/";
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = format.format(new Date()) + UUID.randomUUID().toString();
        article_html = article_html.replace("##文章详细内容##", content1);
        article_html = article_html.replaceAll("<img ", "<img style=\"max-width:100%;\"");
        try {
            FileUtil.createFile(filePath, fileName + ".html", article_html, "utf-8");
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println(
                    "添加新文章成功！<br><a target=\"blank\" href=\""
                            + "/attached/html/" + userName + "/" + fileName + ".html\">点击查看</a>");
            Article article = new Article(1,"12","12","12","121","1212","21");
            int a = articleDao.addArticle(article);
            System.out.println("增加文章成功？" + a);
        } catch (Exception ex) {
            logger.error("{}", ex);
        }
	}
}

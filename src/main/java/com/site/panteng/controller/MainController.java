package com.site.panteng.controller;

import com.google.common.base.Strings;
import com.site.panteng.dao.ArticleDao;
import com.site.panteng.dao.UserDao;
import com.site.panteng.entity.Article;
import com.site.panteng.entity.Constants;
import com.site.panteng.entity.User;
import com.site.panteng.util.FileUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by panteng on 2017/4/8.
 */
@SpringBootApplication
@Controller
@EnableAutoConfiguration
@ComponentScan("com.site.*")
public class MainController {
    private static Logger logger = Logger.getLogger(MainController.class);
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    @Autowired
    UserDao userDao;
    @Autowired
    ArticleDao articleDao;

    @RequestMapping("/")
    @ResponseBody
    ModelAndView home() {
        try {
            User user = userDao.getUserByNickName("panteng");
            ModelAndView mv = new ModelAndView("index");
            return mv;
        } catch (Exception e) {
            logger.error("ERROR:", e);
        }
        return null;
    }

    @RequestMapping("/editor/{*}")
    @ResponseBody
    ModelAndView editor() {
        try {
            String uri = request.getRequestURI().replaceFirst("/", "");
            ModelAndView mv = new ModelAndView(uri);
            return mv;
        } catch (Exception e) {
            logger.error("ERROR:", e);
        }
        return null;
    }

    public static void main(String[] arges) {
        SpringApplication.run(MainController.class, arges);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(HttpServletRequest req, HttpServletResponse resp, String title, String content1, String tags) {
        String article_html = Constants.ARTICLE_TEMPLATE;
        String realPath = req.getSession().getServletContext().getRealPath("/");

        String filePath = realPath + "attached/html/";
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = format.format(new Date()) + UUID.randomUUID().toString();
        article_html = article_html.replace("##文章详细内容##", content1);
        article_html = article_html.replaceAll("<img ", "<img style=\"max-width:100%;\"");
        try {
            //存储到数据库中
            Article article = new Article(1, fileName, title, content1.substring(0, content1.length() > 100 ? 100 : content1.length()),
                    "panteng", "2017", "java;spring");
            articleDao.addArticle(article);
            FileUtil.createFile(filePath, fileName + ".html", article_html, "utf-8");
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println(
                    "添加新文章成功！<br><a target=\"blank\" href=\""
                            + "attached/html/" + fileName + ".html\">点击查看</a>");
        } catch (Exception ex) {
            logger.error("{}", ex);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("passWord");
        if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(pwd)) {
            resp.getWriter().println("{\"loginSuccess\":\"false\",\"errorMsg\":\"用户名或密码为空\"}");
            return;
        }
        User user = userDao.getUserByNickName(userName);
        if (user == null) {
            resp.getWriter().println("{\"loginSuccess\":\"false\",\"errorMsg\":\"用户名不存在\"}");
            return;
        }

        if (!pwd.equals(user.getPwd())) {
            resp.getWriter().println("{\"loginSuccess\":\"false\",\"errorMsg\":\"密码不正确\"}");
            return;
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("userName", userName);
            session.setAttribute(userName, userName + userName);
            session.setMaxInactiveInterval(60);
            resp.getWriter().println("{\"loginSuccess\":\"true\"}");
            return;
        }
    }

    @RequestMapping(value = "/articleList")
    @ResponseBody
    public List<Article> articleList(int pageNum) {
        return articleDao.getArticles("", pageNum, 10);
    }
}

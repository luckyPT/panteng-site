package com.site.panteng.entity;

public class Constants {
	public static String ARTICLE_TEMPLATE = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + "    <title>##网页标题##</title>\n"
            + "    <!-- 新 Bootstrap 核心 CSS 文件 -->\n"
            + "    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css\">\n"
            + "    <!-- 可选的Bootstrap主题文件（一般不用引入） -->\n"
            + "    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css\">\n"
            + "    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->\n"
            + "    <script src=\"http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js\"></script>\n"
            + "    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->\n"
            + "    <script src=\"http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n" + "</head>\n" + "<body>\n"
            + "<div class=\"container-fluid\">\n" + "    <div class=\"row\">\n"
            + "        <div class=\"col-xs-12 col-sm-12 col-md-8 col-md-offset-2\" style=\"background-color: #F6F6F6\">\n"
            + "            <h3 align=\"center\">##文章标题##</h3>\n" + "\n" + "            <div class=\"row\">\n"
            + "                <div class=\"col-xs-3\" style=\"color: #999\">##文章来源##</div>\n"
            + "                <div class=\"col-xs-3\" style=\"color: #999\">##时间##</div>\n" + "            </div>\n"
            + "            <div class=\"row\">\n" + "                <div class=\"col-xs-12\">\n"
            + "                    <div class=\"panel panel-default\">\n"
            + "                        <div class=\"panel-heading center\">\n"
            + "                            <span style=\"color: #3c3c3c\">内容提要</span>\n" + "                        </div>\n"
            + "                        <div class=\"panel-body\" id=\"panelBody\" style=\"background-color: #EEEEF0\">\n"
            + "                            ##内容提要详细内容##\n" + "                        </div>\n" + "                    </div>\n"
            + "                </div>\n" + "\n" + "                <div class=\"col-xs-12\">\n"
            + "                    <div class=\"col-xs-12\">\n" + "                        ##文章详细内容##\n"
            + "                    </div>\n" + "                </div>\n" + "            </div>\n" + "\n" + "        </div>\n"
            + "    </div>\n" + "</div>\n" + "</body>\n" + "</html>";
}

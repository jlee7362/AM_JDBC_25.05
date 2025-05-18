package koreaIT.service;

import koreaIT.Article;
import koreaIT.dao.ArticleDao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ArticleService {
    private Connection conn = null;
    private ArticleDao articleDao = null;

    public ArticleService(Connection conn) {
        this.conn = conn;
        this.articleDao = new ArticleDao(conn);
    }

    public Map<String, Object> getArticleById(int id) {

        return articleDao.getArticleById(id);

    }

    public void doDelete(int id) {
        articleDao.doDelete(id);
    }

    public void doModify(String newTitle, String newBody, int id) {
        articleDao.doModify(newTitle, newBody, id);
    }

    public int doWrite(String title, String body) {
       return articleDao.doWrite(title, body);
    }

    public List<Map<String, Object>> showList() {
        return articleDao.showList();
    }

    public List<Article> getArticleList() {
        return articleDao.getArticleList();
    }
}

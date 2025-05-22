package koreaIT.service;

import koreaIT.dto.Article;
import koreaIT.container.Container;
import koreaIT.dao.ArticleDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleService {
    private ArticleDao articleDao = null;


    public List<Article> getArticles(int page, String searchKeyword) {
        List<Article> articleList = new ArrayList<>();

        List<Map<String, Object>> articleListMap = articleDao.getArticles(page, searchKeyword);

        for (Map<String, Object> articleMap : articleListMap) {
            Article article = new Article(articleMap);
            articleList.add(article);
        }

        return articleList;
    }

    public ArticleService() {
        this.articleDao= Container.articleDao;
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


}

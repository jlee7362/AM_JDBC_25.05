package koreaIT.controller;

import koreaIT.service.ArticleService;

import java.sql.Connection;
import java.util.Map;

public class ArticleController {
    private ArticleService articleService;
    private Connection conn;


    public ArticleController(Connection conn) {
        this.conn = conn;
        this.articleService = new ArticleService(conn);
    }

    public void doDelete(String cmd) {
        int id = -1;
        //parsing 시작
        try {
            id = Integer.parseInt(cmd.split(" ")[2]);
        } catch (Exception e) {
            System.out.println("정수를 입력하세요.");
            return;
        }
        //parsing 끝

//        //글 유무체크 시작
        Map<String, Object> articleMap = articleService.getArticleById(id);

        if (articleMap.isEmpty()) {
            System.out.printf("%d번 글은 없습니다.\n", id);
            return;
        }
        //글 유무체크 끝

        articleService.doDelete(id);
        System.out.printf("%d번 게시글이 삭제되었습니다.\n", id);

    }
}

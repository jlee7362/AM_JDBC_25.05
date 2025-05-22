package koreaIT.controller;

import koreaIT.dto.Article;
import koreaIT.container.Container;
import koreaIT.service.ArticleService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArticleController {
    private ArticleService articleService;
    private Scanner sc;

    public ArticleController() {
        this.articleService = Container.articleService;
        this.sc = Container.sc;
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
        if(!Container.session.isLogined()){
            System.out.println("로그인 후 이용하세요.");
            return;
        }
//        //글 유무체크 시작
        Map<String, Object> articleMap = articleService.getArticleById(id);

        Article article = new Article(articleMap);
        if (articleMap.isEmpty()) {
            System.out.printf("%d번 글은 없습니다.\n", id);
            return;
        }
        if (article.getMemberId() != Container.session.loginedMemberId){ //article 의 id로 가져온 게시글 데이터 중 memberId vs. Container.session.loginedMemberId
            System.out.println("게시글을 삭제 할 권한이 없습니다.");
            return;
        }
        //글 유무체크 끝

        articleService.doDelete(id);
        System.out.printf("%d번 게시글이 삭제되었습니다.\n", id);

    }

    public void showDetail(String cmd) {

        int id = 0;
        //parsing 시작
        try {
            id = Integer.parseInt(cmd.split(" ")[2]);
        } catch (Exception e) {
            System.out.println("정수를 입력하세요.\n");
            return;
        }
        //parsing 끝

        //글 유무체크 시작
        Map<String, Object> articleMap = articleService.getArticleById(id);
        if (articleMap.isEmpty()) {
            System.out.printf("%d번 글은 없습니다.\n", id);
            return;
        }
        //글 유무체크 끝
        System.out.println("==상세보기==");

        Article article = new Article(articleMap);

        System.out.println("번호 : " + article.getId());
        System.out.println("등록날짜 : " + article.getRegDate());
        System.out.println("수정날짜 : " + article.getUpdateDate());
//        System.out.println("작성자번호 : " + article.getMemberId());
        System.out.println("작성자 : " + article.getName());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
    }

    public void doModify(String cmd) {

        int id = 0;
        //parsing 시작
        try {
            id = Integer.parseInt(cmd.split(" ")[2]);
        } catch (Exception e) {
            System.out.println("정수 입력하세요.\n");
        }
        //parsing 끝
        if(!Container.session.isLogined()){
            System.out.println("로그인 후 이용하세요.");
            return;
        }

        //수정할 글 유무체크 시작
        Map<String, Object> articleMap = articleService.getArticleById(id);
        Article article = new Article(articleMap);

        if (articleMap.isEmpty()) {
            System.out.printf("%d번 글은 없습니다.\n", id);
            return;
        }
        //수정할 글 유무체크 끝
        // article 의 id로 가져온 게시글 데이터 중 memberId vs. Container.session.loginedMemberId
        if (article.getMemberId() != Container.session.loginedMemberId){
            System.out.println("수정권한이 없습니다.");
            return;
        }

        System.out.println("==글 수정==");
        System.out.print("새 제목: ");
        String newTitle = sc.nextLine().trim();
        System.out.print("새 내용: ");
        String newBody = sc.nextLine().trim();

        //DB 업데이트
        articleService.doModify(newTitle, newBody, id);

        System.out.printf("%d번 게시글이 업데이트 되었습니다.\n", id);
    }

    public void doWrite() {

        if(!Container.session.isLogined()){
            System.out.println("로그인 후 이용하세요.");
            return;
        }

        System.out.print("제목 : ");
        String title = sc.nextLine().trim();
        System.out.print("내용 : ");
        String body = sc.nextLine().trim();

        //DB insert 시작
        int id = articleService.doWrite(title, body);


        //DB insert 끝
        System.out.printf("%d번 게시글이 등록되었습니다.\n", id);

    }

    public void showList(String cmd) {

        int page = 0;
        //parsing 시작
        try {
            page = Integer.parseInt(cmd.split(" ")[2]);
        } catch (Exception e) {
            System.out.println("정수 입력하세요.\n");
        }

        List<Article> articleList = articleService.getArticles(page);

        if (articleList.isEmpty()) {
            System.out.println("게시글이 없습니다.\n");
            return;
        }
        System.out.println("번호   /   제목   /   작성자");
        System.out.println("=".repeat(30));

        for (Article article : articleList) {
            System.out.printf("%d         %s        %s\n", article.getId(), article.getTitle(), article.getName());
        }

    }

}


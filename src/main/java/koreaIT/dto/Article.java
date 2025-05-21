package koreaIT.dto;

import java.util.Map;

public class Article {
    private int id;
    private String regDate;
    private String updateDate;
    private String title;
    private String body;

    private String name;
    private int memberId;

    public Article(Map<String, Object> articleMap) {

        this.id = (int)articleMap.get("id");
        this.regDate = (String) articleMap.get("regDate");
        this.updateDate = (String)articleMap.get("updateDate");
        this.title = (String)articleMap.get("title");
        this.body = (String)articleMap.get("body");

        this.memberId = (int) articleMap.get("memberId");
        this.name = (String) articleMap.get("name");
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", regDate='" + regDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", name='" + name + '\'' +
                ", memberId=" + memberId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

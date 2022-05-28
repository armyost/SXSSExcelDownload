package com.example.demo;

// Entity 객체 정의
public class DemoEntity {
    private String postId;
    private String title;
    private String contents;

    public DemoEntity(){}

    public DemoEntity(String postId, String title, String contents) {
        this.postId = postId;
        this.title = title;
        this.contents = contents;
    }

    // 해당 객체의 postId 조회
    public String getPostId() {
        return postId;
    }

    // 해당 객체에 postId 저장
    public void setPostId(String postId) {
        this.postId = postId;
    }

    // 해당 객체의 Title  조회
    public String getTitle() {
        return title;
    }

    // 해당 객체에 Titel 저장
    public void setTitle(String title) {
        this.title = title;
    }

    // 해당 객체의 contents 조회
    public String getContents() {
        return contents;
    }

    // 해당 객체에 contents 저장
    public void setContents(String contents) {
        this.contents = contents;
    }
}

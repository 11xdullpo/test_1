package com.company.test_1.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 모든 필든의 Getter 메소드 자동생성
@NoArgsConstructor // 기본생성자 자동추가 -> public Posts(){} 와 같은 효과
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts {
    @Id // 테이블의 PK를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // PK생성규칙 GenerationType.IDENTITY : 자동증가
    private Long id;
    @Column(length = 500, nullable = false) // 기본값이면 굳이 @Column을 선언 할 필요는 없지만 기본형식을 변경하려면 추가해야함.
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;
    
    @Builder // 해당 클래스의 빌더패턴 클래스생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String p_title, String p_content, String p_author){
        this.title = p_title;
        this.content = p_content;
        this.author = p_author;
    }

}
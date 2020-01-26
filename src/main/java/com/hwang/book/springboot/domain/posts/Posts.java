package com.hwang.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 추가 public Post(){}와 같은 효과
@Entity
// @Entity : 테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
// ex) SalesManager.java -> sales_manager table
public class Posts {
    @Id //해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙을 나타냄
    private Long id;

    /* @Column
    * 테이블의 칼럼을 나타냄. 굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이됨.
    * 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용.
    * */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당클래사의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함 
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }


}

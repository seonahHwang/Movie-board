package com.hwang.book.springboot.domain.posts;

import com.hwang.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 추가 public Post(){}와 같은 효과
@Entity
/* @Entity : 테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
    ex) SalesManager.java -> sales_manager table
   Entity class에는 절대 setter를 생성하지 않음. 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지
   코드상으로 명확하게 구분할 수가 없어, 차후에 기능 변경시 복잡해짐
 */
public class Posts extends BaseTimeEntity {
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

    private String movie_title;

    @Builder
    public Posts(String title, String content, String author, String movie_title){
        this.title = title;
        this.content = content;
        this.author = author;
        this.movie_title = movie_title;
    }

    public void update(String title,String content, String movie_title){
        this.title = title;
        this.content = content;
        this.movie_title = movie_title;
    }

}

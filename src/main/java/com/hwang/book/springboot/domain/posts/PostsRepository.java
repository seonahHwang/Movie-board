package com.hwang.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /*JpaRepository<Entity 클래스, PK 타입> 을 상속하면 기본적인 CRUD 메소드가 자동생성
    * @Repository를 추가하지 않아도 됨. 주의할 점은 Entity class와 Entity Repository는 함께 위치해야함
    * Entity class는 기본 Repository없이는 제대로 역할을 할 수 X */

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

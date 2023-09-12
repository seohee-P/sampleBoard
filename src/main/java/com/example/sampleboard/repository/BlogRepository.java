package com.example.sampleboard.repository;

import com.example.sampleboard.domain.blog.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
    // 구현체가 필요없다 JpaRepository가 자동으로 다해준다.
    /*
    기본 제공을 Jpa가 제공하기 떄문에 따로 메소드를 선언할 필요가 없다
    하지만 필요한 기능이 있다면 메소드를 추가하면 된다.
     */
}

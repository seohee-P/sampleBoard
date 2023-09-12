package com.example.sampleboard.domain.blog;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter // 자바에서 갯터 셋터를 자동화해주는 롬복 에노테이션
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자의 인수가 아무것도 없는것을 대체, 보안성레벨 지정
@EntityListeners(AuditingEntityListener.class)
@Entity // 자바에서 데이터베이스 테이블형식을 사용하는 에노테이션
public class Article {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)// 데이터베이스에서 기본 값을 지정하는 에노테이션, GenerationType.IDENTITY DB에서 인크리즈
    @Column(name = "id", updatable = false) // 컬럼 이름 지정. 업테이트 불허
    private  Long id;

    @Column(name = "tilte", nullable = false) // 컬럼 이름 지정, 널 불허
    private  String title;
    @Column(name = "content",nullable = false) // 컬럼 이름 지정, 널 불허
    private  String content;
    @CreatedDate // 로그 관리를 위해 에노테이션을 사용
    @Column(name = "created_at") // 자바 영역에서 카멜표기법, 데이터 베이스에서는 언더바가 관례
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }


    // update 하는 기능을 명시한다.
    public void update(String title,  String content){
        this.title = title;
        this.content = content;
    }
}

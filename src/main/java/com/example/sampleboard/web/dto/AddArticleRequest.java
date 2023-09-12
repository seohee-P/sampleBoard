package com.example.sampleboard.web.dto;

import com.example.sampleboard.domain.blog.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Getter  //Setter를 사용하지 않는 이유 꼭 변경이 필요한 데이터만 사용한다.
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() { //데이터 베이스 형ㅅ힉으로 변화를 일으킴, 데이터가 의도적으로 변화되는것을 방지
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}

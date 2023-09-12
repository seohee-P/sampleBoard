package com.example.sampleboard.web;

import com.example.sampleboard.domain.blog.Article;
import com.example.sampleboard.service.BlogService;
import com.example.sampleboard.web.dto.ArticleListViewResponse;
import com.example.sampleboard.web.dto.ArticleViewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .collect(Collectors.toList());
        model.addAttribute("articles",articles);
        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article",new ArticleListViewResponse(article));
        return "article";
    }

    @GetMapping("/new-article") // 신규 글 작성과 특정 글 수정을 동시에 처리하게 해주는 메소드.
    /*
    @RequestParam(required = false)
     */
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null){
            //신규 등록
            model.addAttribute("article", new ArticleViewResponse());
        }else {
            //
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return  "newArticle";
    }
}

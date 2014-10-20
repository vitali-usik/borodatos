package com.borodatos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.borodatos.model.ComicsArticle;
import com.borodatos.service.ArticleService;

/**
 * @author Vitali Usik
 * 
 */
@Controller
public class ComicsSectionController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/comics/{link}")
    public String comicsPage(@PathVariable("link") String link, Map<String, Object> map) {

        ComicsArticle comicsArticle = articleService.retrieveComics(link);
        map.put("comics", comicsArticle);

        return "comics_page";
    }

    @RequestMapping("/admin/edit/{link}")
    public String editComics(@PathVariable("link") String link, Map<String, Object> map) {

        ComicsArticle comicsArticle = articleService.retrieveComics(link);
        map.put("comics", comicsArticle);

        return "comics_edit";
    }

    @RequestMapping("/comics/save")
    public String saveComics(@ModelAttribute("comics") ComicsArticle comics, BindingResult result) {
        articleService.saveComics(comics);

        return "redirect:/admin/edit/" + comics.getLink();
    }

    @RequestMapping("/admin/add")
    public String addComicsArticle(@ModelAttribute("comics") ComicsArticle comics, BindingResult result) {

        return "comics_edit";
    }

    @RequestMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {

        articleService.removeComics(id);

        return "redirect:/";
    }
}

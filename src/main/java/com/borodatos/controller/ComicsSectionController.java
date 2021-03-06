package com.borodatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.borodatos.service.ArticleService;
import com.borodatos.service.ImageService;

/**
 * @author Vitali Usik
 * 
 */
@Controller
public class ComicsSectionController {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private ImageService imageService;

//    @RequestMapping("/comics/save")
//    public String saveComics(@ModelAttribute("comics") ComicsArticle comics, BindingResult result) {
//        articleService.saveComics(comics);
//
//        return "redirect:/admin/edit/" + comics.getLink();
//    }

//    @RequestMapping("/admin/add")
//    public String addComicsArticle(@ModelAttribute("comics") ComicsArticle comics, BindingResult result, Map<String, Object> map) {
//
//        map.put("images", new ImageList());
//        map.put("listImages", imageService.listImages());
//        
//        return "comics_edit";
//    }

    @RequestMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {

        articleService.removeComics(id);

        return "redirect:/";
    }
}

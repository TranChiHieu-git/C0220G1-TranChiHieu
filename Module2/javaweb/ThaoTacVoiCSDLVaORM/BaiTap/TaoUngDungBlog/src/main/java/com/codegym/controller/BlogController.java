package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @PostMapping("/created")
    public ModelAndView created(@RequestParam("title") String title,
                                @RequestParam("content") String content) {
        blogService.create(new Blog(title, content));
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", blogService.showTille());
        return modelAndView;
    }

    @GetMapping("/content/{id}")
    public ModelAndView showContent(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("content");
        modelAndView.addObject("content", blogService.showBlog(Long.parseLong(id)));
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateContent(@PathVariable String id) {
        Blog blog = blogService.showBlog(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/updated")
    public ModelAndView updatedContent(@ModelAttribute("blog") Blog blog) {
        blogService.update(blog);
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteContent(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("content", blogService.showBlog(Long.parseLong(id)));
        return modelAndView;
    }

    @PostMapping("/deleted")
    public ModelAndView deletedContent(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView("index");
        blogService.remove(Long.parseLong(id));
        return modelAndView;
    }
}

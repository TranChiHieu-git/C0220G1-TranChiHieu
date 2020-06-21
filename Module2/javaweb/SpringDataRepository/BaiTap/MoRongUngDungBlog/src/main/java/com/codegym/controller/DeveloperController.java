package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Post;
import com.codegym.service.CategoryService;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@Controller
public class DeveloperController {
    @Autowired
    PostService postService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/developer")
    public ModelAndView showDev(@RequestParam("account") String account,
                                @RequestParam("password") String password) {
        ModelAndView modelAndView;
        if (account.equals("hsl") && password.equals("123456")) {
            modelAndView = new ModelAndView("/dev/index");
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("index");
            return modelAndView;
        }
    }

    @GetMapping("/dev/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/dev/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @GetMapping("/dev/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/dev/index");
        return modelAndView;
    }

    @PostMapping("/dev/created")
    public ModelAndView created(@ModelAttribute("post") Post post) {
        Date date = new Date();
        post.setDateCreate(date);
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/dev/index");
        return modelAndView;
    }

    @GetMapping("/dev/find")
    public ModelAndView index(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/dev/find");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("postt", postService.findAllByTitle(keywordLast, pageable));
        } else {
            modelAndView.addObject("postt", postService.findAll(pageable));
        }
        modelAndView.addObject("key", keywordLast);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Post post = postService.findById(id).orElse(null);
        ModelAndView modelAndView = new ModelAndView("/dev/edit");
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @PostMapping("/edited")
    public ModelAndView update(@ModelAttribute("post") Post post) {
        Date date = new Date();
        post.setDateCreate(date);
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/dev/index");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Post post = postService.findById(id).orElse(null);
        ModelAndView modelAndView = new ModelAndView("/dev/delete");
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @PostMapping("/deleted")
    public ModelAndView delete(@ModelAttribute("post") Post post) {
        postService.remove(post);
        ModelAndView modelAndView = new ModelAndView("/dev/index");
        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView trangchu(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/index/index");
        modelAndView.addObject("select", postService.findAllByTitleContainingOrderByDateCreateDesc("", pageable));
        return modelAndView;
    }
}

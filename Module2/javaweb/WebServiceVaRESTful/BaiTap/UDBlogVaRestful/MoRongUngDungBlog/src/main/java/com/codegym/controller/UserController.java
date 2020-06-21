package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Post;
import com.codegym.service.CategoryService;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    PostService postService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("posts")
    public Iterable<Post> posts() {
        return postService.findAll();
    }
    @RequestMapping(value = "/posts/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> listAll() {
        Iterable<Post> post = postService.findAll();
        if (post==null) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Post>>(post, HttpStatus.OK);
    }
    @ModelAttribute("categorys")
    public Iterable<Category> provinces() {
        return categoryService.findAll();
    }

    @GetMapping("/tienhiep")
    public ModelAndView tienHiep(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(1L, pageable));
        modelAndView.addObject("type", "1");
        return modelAndView;
    }

    @RequestMapping(value = "/tienhiep/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> listAllTienHiep() {
        Iterable<Post> post = postService.findAllByID(1L);
        if (post==null) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Post>>(post, HttpStatus.OK);
    }

    @GetMapping("/tienhiep/find")
    public ModelAndView tienhiepFind(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("post", postService.findAllByTitleAndCategory_Id(keywordLast, 1L, pageable));
            modelAndView.addObject("type", "9");
        } else {
            modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(1L, pageable));
            modelAndView.addObject("type", "1");
        }
        modelAndView.addObject("key", keywordLast);
        return modelAndView;
    }

    @GetMapping("/trinhtham")
    public ModelAndView trinhtham(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(2L, pageable));
        modelAndView.addObject("type", "2");
        return modelAndView;
    }
    @RequestMapping(value = "/trinhtham/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> listAllTrinhTham() {
        Iterable<Post> post = postService.findAllByID(2L);
        if (post==null) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Post>>(post, HttpStatus.OK);
    }
    @GetMapping("/trinhtham/find")
    public ModelAndView trinhthamFind(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("post", postService.findAllByTitleAndCategory_Id(keywordLast, 2L, pageable));
            modelAndView.addObject("type", "10");
        } else {
            modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(2L, pageable));
            modelAndView.addObject("type", "2");
        }
        modelAndView.addObject("key", keywordLast);
        return modelAndView;
    }
    @RequestMapping(value = "/lichsu/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> listAllLichSu() {
        Iterable<Post> post = postService.findAllByID(3L);
        if (post==null) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Post>>(post, HttpStatus.OK);
    }
    @GetMapping("/lichsu")
    public ModelAndView lichsu(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(3L, pageable));
        modelAndView.addObject("type", "3");
        return modelAndView;
    }

    @GetMapping("/lichsu/find")
    public ModelAndView lichsuFind(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("post", postService.findAllByTitleAndCategory_Id(keywordLast, 3L, pageable));
            modelAndView.addObject("type", "11");
        } else {
            modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(3L, pageable));
            modelAndView.addObject("type", "3");
        }
        modelAndView.addObject("key", keywordLast);
        return modelAndView;
    }
    @RequestMapping(value = "/khvt/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> listAllkhkt() {
        Iterable<Post> post = postService.findAllByID(4L);
        if (post==null) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Post>>(post, HttpStatus.OK);
    }
    @GetMapping("/khvt")
    public ModelAndView khvt(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(4L, pageable));
        modelAndView.addObject("type", "4");
        return modelAndView;
    }

    @GetMapping("/khkt/find")
    public ModelAndView khktFind(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("post", postService.findAllByTitleAndCategory_Id(keywordLast, 4L, pageable));
            modelAndView.addObject("type", "12");
        } else {
            modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(4L, pageable));
            modelAndView.addObject("type", "4");
        }
        modelAndView.addObject("key", keywordLast);
        return modelAndView;
    }
    @RequestMapping(value = "/thieunhi/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> listAllThieuNhi() {
        Iterable<Post> post = postService.findAllByID(5L);
        if (post==null) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Post>>(post, HttpStatus.OK);
    }
    @GetMapping("/thieunhi")
    public ModelAndView thieunhi(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(5L, pageable));
        modelAndView.addObject("type", "5");
        return modelAndView;
    }

    @GetMapping("/thieunhi/find")
    public ModelAndView thieunhiFind(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("post", postService.findAllByTitleAndCategory_Id(keywordLast, 5L, pageable));
            modelAndView.addObject("type", "13");
        } else {
            modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(5L, pageable));
            modelAndView.addObject("type", "5");
        }
        modelAndView.addObject("key", keywordLast);
        return modelAndView;
    }
    @RequestMapping(value = "/truyencuoi/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> listAllTruyenCuoi() {
        Iterable<Post> post = postService.findAllByID(6L);
        if (post==null) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Post>>(post, HttpStatus.OK);
    }
    @GetMapping("/truyencuoi")
    public ModelAndView truyencuoi(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(6L, pageable));
        modelAndView.addObject("type", "6");
        return modelAndView;
    }

    @GetMapping("/truyencuoi/find")
    public ModelAndView truyencuoiFind(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("post", postService.findAllByTitleAndCategory_Id(keywordLast, 6L, pageable));
            modelAndView.addObject("type", "14");
        } else {
            modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(6L, pageable));
            modelAndView.addObject("type", "6");
        }
        modelAndView.addObject("key", keywordLast);
        return modelAndView;
    }
    @RequestMapping(value = "/truyenma/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> listAllTruyenMa() {
        Iterable<Post> post = postService.findAllByID(7L);
        if (post==null) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Post>>(post, HttpStatus.OK);
    }
    @GetMapping("/truyenma")
    public ModelAndView truyenma(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(7L, pageable));
        modelAndView.addObject("type", "7");
        return modelAndView;
    }

    @GetMapping("/truyenma/find")
    public ModelAndView truyenmaFind(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("post", postService.findAllByTitleAndCategory_Id(keywordLast, 7L, pageable));
            modelAndView.addObject("type", "15");
        } else {
            modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(7L, pageable));
            modelAndView.addObject("type", "7");
        }
        modelAndView.addObject("key", keywordLast);
        return modelAndView;
    }
    @RequestMapping(value = "/truyenvohiep/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> listAllVoHiep() {
        Iterable<Post> post = postService.findAllByID(8L);
        if (post==null) {
            return new ResponseEntity<Iterable<Post>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Post>>(post, HttpStatus.OK);
    }
    @GetMapping("/truyenvohiep")
    public ModelAndView vohiep(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(8L, pageable));
        modelAndView.addObject("type", "8");
        return modelAndView;
    }

    @GetMapping("/truyenvohiep/find")
    public ModelAndView truyenvohiepFind(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("post", postService.findAllByTitleAndCategory_Id(keywordLast, 8L, pageable));
            modelAndView.addObject("type", "16");
        } else {
            modelAndView.addObject("post", postService.findAllByCategory_IdOrderByDateCreateDesc(8L, pageable));
            modelAndView.addObject("type", "8");
        }
        modelAndView.addObject("key", keywordLast);
        return modelAndView;
    }

//    @GetMapping("/read/{id}")
//    public ModelAndView read(@PathVariable("id") String id) {
//        Post post = postService.findById(Long.parseLong(id)).orElse(null);
//        ModelAndView modelAndView = new ModelAndView("/user/read");
//        modelAndView.addObject("readpost", post);
//        return modelAndView;
//    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> readBlog(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Post post = postService.findById(id).orElse(null);
        if (post == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @GetMapping("/user/find")
    public ModelAndView find(@PageableDefault(size = 5) Pageable pageable, @RequestParam("keyword") Optional<String> s) {
        String key = s.get();
        System.out.println("abc");
        Page<Post> posts = postService.findAllByTitle(key, pageable);
        ModelAndView modelAndView = new ModelAndView("/user/find");
        modelAndView.addObject("postt", posts);
        modelAndView.addObject("key", key);
        return modelAndView;
    }
}

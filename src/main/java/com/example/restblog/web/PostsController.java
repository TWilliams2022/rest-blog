package com.example.restblog.web;

import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    List<Post> posts = new ArrayList<>();

    @GetMapping
    public List<Post> getAll() {
        posts.add(new Post(1L, "new title", "some content"));
        posts.add(new Post(2L, "cool title", "no content"));
        posts.add(new Post(3L, "lame from DB", "true data"));
        return posts;
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        for (Post post : getAll()) {
            if (Objects.equals(post.getId(), id)) {
                return post;
            }
        }
        return new Post();
    }

    @PostMapping
    public void createPost(@RequestBody Post postToAdd) {
        System.out.println(postToAdd);
    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        System.out.println(updatedPost);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
        System.out.println("Deleting post with id: " + id);
    }


}
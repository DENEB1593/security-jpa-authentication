package io.study.deneb.repository;

import io.study.deneb.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

  @Autowired
  PostRepository postRepository;

  @Test
  void findByUsername() {
    List<Post> posts = postRepository.findByUsername("deneb");
    System.out.println(posts);
  }


}
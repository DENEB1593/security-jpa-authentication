package io.study.deneb.controller;

import io.study.deneb.mapper.PostMapper;
import io.study.deneb.model.Post;
import io.study.deneb.model.PostDto;
import io.study.deneb.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("api/posts")
public class PostController {

  private final PostRepository postRepository;

  public PostController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @GetMapping
  public List<PostDto> findAll() {
    return postRepository.findAll()
            .stream()
            .map(PostMapper::of)
            .collect(toList());
  }

  @GetMapping("/{id}")
  public Post findById(@PathVariable("id") UUID id){
    return postRepository.findById(id)
      .orElseThrow(IllegalArgumentException::new);
  }

}

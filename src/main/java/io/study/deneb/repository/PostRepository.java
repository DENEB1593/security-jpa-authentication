package io.study.deneb.repository;

import io.study.deneb.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long>  {

  @Override
  List<Post> findAll();
}

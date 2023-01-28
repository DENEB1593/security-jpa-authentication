package io.study.deneb.repository;

import io.study.deneb.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends CrudRepository<Post, UUID>  {

  @Override
  List<Post> findAll();
}

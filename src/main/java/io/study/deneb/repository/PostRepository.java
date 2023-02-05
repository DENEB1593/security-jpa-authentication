package io.study.deneb.repository;

import io.study.deneb.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {


  List<Post> findByUsername(String usename);
}

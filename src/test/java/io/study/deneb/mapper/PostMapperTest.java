package io.study.deneb.mapper;

import io.study.deneb.model.Post;
import io.study.deneb.model.PostDto;
import io.study.deneb.model.User;
import io.study.deneb.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostMapperTest {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    PostRepository postRepository;

    String givenUserName = "test";

    @BeforeEach
    void init() {
        User givenUser = new User(givenUserName, encoder.encode("1234"), "ROLE_USER");
        Post givenPost = new Post("hello everyone", "slug1", "for everyone", givenUser.getUsername());

        postRepository.save(givenPost);
    }

    @Test
    void convertPostToPostDto() {
        Post saved = postRepository
                .findTopByUsername(givenUserName)
                .orElseThrow(RuntimeException::new);

        PostDto postDto = PostMapper.of(saved);

        assertThat(postDto).usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(saved);

    }

}
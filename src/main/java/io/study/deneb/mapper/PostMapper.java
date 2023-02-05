package io.study.deneb.mapper;

import io.study.deneb.model.Post;
import io.study.deneb.model.PostDto;

public class PostMapper {

    public static PostDto of(Post post) {
        return new PostDto(
                post.getTitle(),
                post.getSlug(),
                post.getContent(),
                post.getUsername(),
                post.getPublishedOn()
        );
    }


}

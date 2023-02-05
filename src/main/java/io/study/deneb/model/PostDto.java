package io.study.deneb.model;

import java.time.LocalDateTime;

public record PostDto (
        String title,
        String slug,
        String content,
        String username,
        LocalDateTime publishedOn
) {

}

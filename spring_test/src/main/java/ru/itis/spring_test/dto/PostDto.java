package ru.itis.spring_test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.spring_test.models.Post;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Long id;
    private String text;
    private String author;
    private Integer likes;

    public static PostDto from(Post post) {
        Integer likesCount = 0;
        if (post.getLikes() != null) {
            likesCount = post.getLikes().size();
        }
        return PostDto.builder()
                .id(post.getPostId())
                .text(post.getText())
                .author(post.getAuthor().getUsername())
                .likes(likesCount)
                .build();
    }


    public static List<PostDto> getPostsList(List<Post> posts) {
        return posts.stream()
                .map(PostDto::from)
                .collect(Collectors.toList());
    }
}

package com.company.test_1.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Junit4 일때는 @RunWith(SpringRunner.class) 사용 스프링 부트와 junit사이의 연결자역할
@ExtendWith ( SpringExtension.class) // j
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;
    // Junit4일때는 @After, Junit5로 바뀌고나서 @AfterEach를 사용
    @AfterEach // 테스트 클래스 내 테스트 메서드를 모드 실행시킨 후 딱 한번 수행되는 메서드
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @Test
    public void getSaveLoad(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .p_title(title)
                .p_content(content)
                .p_author("작성자")
                .build());
        System.out.println(postsRepository);
        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo("작성자");
    }
}

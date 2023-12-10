package com.company.test_1.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



// Junit4 일때는 @RunWith(SpringRunner.class) 사용 스프링 부트와 junit사이의 연결자역할
@ExtendWith(SpringExtension.class)
// Web(Spring MVC)에 집중할 수 있도록 해주는 어노테이션..??
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // 스프링이 관리하는 Bean 주입
    @Autowired
    // api 테스트용 클래스
    private MockMvc mvc;

    
    @Test
    public void helloShouldReturn() throws Exception {
        String hello = "hello";
        // hello로 get요쳥을 함
        mvc.perform(get("/hello"))
                // http header 의 status값을 검증(200, 404, 500 등)
                .andExpect(status().isOk())
                // 본문 내용을 검증
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDtoShouldReturn() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}

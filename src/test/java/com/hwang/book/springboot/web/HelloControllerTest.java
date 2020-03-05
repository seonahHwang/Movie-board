package com.hwang.book.springboot.web;

import com.hwang.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/* static이 붙는 이유는? => 클래스의 이름 없이 바로 메소드로 접근 가능
Ex) Math.abs()를 사용할 때 static을 붙여서 import하면 바로 클래스명 없이 abs()로 사용가능
*/

@RunWith(SpringRunner.class)
//테스트를 진행할 때 JUnit에 내장된 실행자 외에 SpringRunner라는 스프링  실행자를 사용하겠다.
// 즉, 스프링 부트 테스트와 Junit 사이에 연결자 역할을 한다.
@WebMvcTest(controllers = HelloController.class,
excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = SecurityConfig.class)
})
//여러 스프링 테스트 어노테이션 중, web에 집중할 수 있는 어노테이션
//선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있고, @Service, @Component 등은 사용 불가
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc; //bean으로 사용하겠다는 설정을 직접하진 않았는데 @Autowired로 사용가능 한건지?
    /* 웹 API 테스트할 때 사용
    스프링 MVC 테스트의 시작점 */

    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언 가능
                .andExpect(status().isOk()) //mvc.perform의 결과 검증. HTTP Header의 Status를 검증. 200인지 아닌지 검증
                .andExpect(content().string(hello)); //응답 본문의 내용 검증
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;
        mvc.perform(get ("/hello/dto")
                .param("name",name) // param : api 테스트할 때 사용될 요청 파라미터 설정, 값은 String만 허용,
                // 숫자날짜 등의 데이터도 등록할 때는 문자열로 변경해야만 가능
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                //jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드
                //$를 기준으로 필드명을 명시
                .andExpect(jsonPath("$.amount", is(amount)));

    }

}

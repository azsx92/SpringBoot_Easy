package jumpTwo.hellospring;

import jumpTwo.hellospring.repository.MemberRepository;
import jumpTwo.hellospring.repository.MemoryMemberRepository;
import jumpTwo.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

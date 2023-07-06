package jumpTwo.hellospring;

import jakarta.persistence.EntityManager;
import jumpTwo.hellospring.repository.*;
import jumpTwo.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private  EntityManager em;
//    private final MemberRepository memberRepository;
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}

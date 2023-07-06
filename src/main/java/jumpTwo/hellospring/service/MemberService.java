package jumpTwo.hellospring.service;

import jumpTwo.hellospring.domain.Member;
import jumpTwo.hellospring.repository.MemberRepository;
import jumpTwo.hellospring.repository.MemoryMemberRepository;


import java.util.List;
import java.util.Optional;

public class MemberService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
     * 회원 가입
     * */

    public Long join(Member member) {
        //같은 이름이 있는 중복 회원x
        Optional<Member> result = memberRepository.findByName(member.getName());
        isValidation(result); //중복회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private static void isValidation(Optional<Member> result) {
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}

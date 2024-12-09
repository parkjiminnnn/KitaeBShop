//package inhatc.cse.kitaebshop.member.service;
//
//import inhatc.cse.kitaebshop.member.dto.MemberDto;
//import inhatc.cse.kitaebshop.member.entity.Member;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
////@Transactional
//class MemberServiceTest {
//
//    @Autowired
//    private MemberService memberService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    private Member createMember() {
//        MemberDto memberDto = MemberDto.builder()
//                .address("인천 미추홀구")
//                .email("test@test.com")
//                .name("홍길동1")
//                .password("1111")
//                .build();
//        System.out.println(memberDto);
//        Member member = Member.createMember(memberDto, passwordEncoder);
//        return member;
//    }
//
//    @Test
//    @DisplayName("회원 가입 테스트")
//    void saveMemberTest() {
//        Member member = createMember();
//        //System.out.println(member);
//        Member saveMember = memberService.saveMember(member);
//        //System.out.println(saveMember);
//        assertEquals(member.getEmail(), saveMember.getEmail());
//    }
//
//
//}
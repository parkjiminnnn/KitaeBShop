package inhatc.cse.kitaebshop.member.controller;

import inhatc.cse.kitaebshop.member.dto.MemberDto;
import inhatc.cse.kitaebshop.member.entity.Member;
import inhatc.cse.kitaebshop.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService; // 자동으로 객체 생성
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }

    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디나 패스워드를 다시 확인하세요.");
        return "member/login";

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String newMember(Model model){
        model.addAttribute("memberDto", new MemberDto());
        return "member/register";
    }

    @PostMapping("/register")
    public String addMember(@Valid MemberDto memberDto,
                            BindingResult bindingResult,
                            Model model){

        if(bindingResult.hasErrors()){
            return "member/register";
        }
        try{
            Member member = Member.createMember(memberDto, passwordEncoder);
            Member saveMember = memberService.saveMember(member);
        } catch(IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "member/register";
        }

        return "redirect:/";
    }

}

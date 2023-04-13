package com.example.springtest2.member.controller;

import com.example.springtest2.member.dto.EmployeeDTO;
import com.example.springtest2.member.entity.Employee;
import com.example.springtest2.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController
{
    private final MemberService memberService;

    public MemberController(MemberService memberService)
    {
        this.memberService = memberService;
    }

    @GetMapping("/searchId")
    public void searchIdPage() {}

    @GetMapping("/searchValue")
    public String searchId(@RequestParam String empId, Model model)
    {
        EmployeeDTO member = memberService.findById(empId);
        model.addAttribute("member",member);

        return "member/list";
    }

    @GetMapping("/searchAll")
    public String searchAll(Model model)
    {
        List<EmployeeDTO> member = memberService.findAll();
        model.addAttribute("member",member);

        return "member/list";
    }

    @GetMapping("/serchFindMember")
    public void serchFindMemberPage() {}

    @PostMapping("serchFindMember")
    public String serchFindMember(@RequestParam String code, Model model)
    {
        List<EmployeeDTO> member = memberService.serchFindMember(code);
        model.addAttribute("member",member);
        return "member/list";
    }


    @GetMapping(value = "/Category" , produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String ,Object> searchCategory(@RequestParam("value") int value)
    {
        return memberService.findCategory(value);
    }

    @GetMapping("/save")
    public void savePage(){}

    @PostMapping("/save")
    public String save(@ModelAttribute EmployeeDTO employee)
    {
        memberService.registMember(employee);
        return "redirect:/";
    }

    @GetMapping("modify")
    public void modifyPage(){}

    @PostMapping("modify")
    public String modify(@ModelAttribute EmployeeDTO emp,Model model)
    {
        memberService.modifyMember(emp);
        return "redirect:/";
    }

    @GetMapping("delete")
    public void deletePage() {}

    @PostMapping("delete")
    public String delete(@RequestParam String code)
    {
        memberService.deleteMember(code);
        return "redirect:/";
    }

}

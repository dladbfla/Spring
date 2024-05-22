package gw.jdbcproject.service;

import gw.jdbcproject.model.Member;
import gw.jdbcproject.repository.JdbcMemberRepository;
import gw.jdbcproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;  //약한결합

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }
}

package com.example.demo.member;

public class MemberserviceImpl implements  MemberService{

    private final MemberRepository memberRepository ;

    public MemberserviceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}

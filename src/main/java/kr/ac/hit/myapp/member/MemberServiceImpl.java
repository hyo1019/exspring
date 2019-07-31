package kr.ac.hit.myapp.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//@Component @Controller @Service @Repository(dao용) 중 하나를 붙이면 스프링이 등록(new 클래스명() 해주지 않아도 스프링이 해준다)
@Service
public class MemberServiceImpl implements MemberService{
	@Resource
	private MemberDao memberDao;
	@Override
	public int insert(MemberVo vo) {
		int num = memberDao.insert(vo);
		return num;
	}
	
	@Override
	public List<MemberVo> selectList() {
		List<MemberVo> list = memberDao.selectList();
		return list;
	}

	@Override
	public MemberVo select(String memId) {
		MemberVo vo = memberDao.select(memId);
		return vo;
	}

	@Override
	public int update(MemberVo vo) {
		int num = memberDao.update(vo);
		return num;
	}

	@Override
	public int delete(String memId) {
		return memberDao.delete(memId);
	}

	@Override
	public MemberVo selectLoginUser(MemberVo vo) {
		return memberDao.selectLoginUser(vo);
	}

}

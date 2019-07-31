package kr.ac.hit.myapp.member;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//@Repository
public class MemberDaoBatis implements MemberDao{
//여기를 통해서 Dao 작업을 함
	@Resource
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVo vo) {
		// MyBatis를 사용하여 insert 쿼리문을 실행하도록 구현
		// 실행하려는 SQL문에 맞는 sqlSession 객체의 메서드를 사용하여 실행
		// 실행하려는 SQL문의 "mapper네임스페이스.sql문 id" 형태로 지정
		return sqlSession.insert("kr.ac.hit.myapp.member.MemberDao.insert", vo);
	}

	@Override
	public List<MemberVo> selectList() {
		return sqlSession.selectList("kr.ac.hit.myapp.member.MemberDao.selectList");
	}

	@Override
	public MemberVo select(String memId) {
		return sqlSession.selectOne("실행할SQL문ID", memId);
	}

	@Override
	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVo selectLoginUser(MemberVo vo) {
		// TODO Auto-generated method stub
		return null;
	}	
}

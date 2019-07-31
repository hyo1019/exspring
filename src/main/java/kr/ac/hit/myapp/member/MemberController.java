package kr.ac.hit.myapp.member;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.lf5.viewer.LogFactor5InputDialog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	//	@Autowired @Inject @Resource 중 하나를 사용하여 자동 주입
	@Resource
	private MemberService memberService;
	
	@RequestMapping(value ="/member/add.do", method=RequestMethod.GET)
	public String addForm() {
		return "member/memAdd";
	}
	
	@RequestMapping(value ="/member/add.do", method=RequestMethod.POST)
	public String add(MemberVo vo) {
		// 파라미터로 넘어온 값들을 받아서 데이터베이스에 추가(insert)
		memberService.insert(vo);
//		JSP 파일로 이동하는 대신 redirect: 뒤에 지정한 주소로 이동하라는 응답을 전송
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/member/list.do")
	public String list(Map modelMap) {
		// 데이터베이스에서 회원목록을 조회하고
		List<MemberVo> list = memberService.selectList();
		// 조회한 회원목록 list를 JSP에서 ${memberList}로 사용할 수 있도록 모델에 저장
		modelMap.put("memberList", list);
		return "member/memList";
	}
	
	@RequestMapping(value ="/member/edit.do", method=RequestMethod.GET)
	public String editForm(String memId, Map modelMap, HttpSession session) {
		// 로그인한 사용자와 상세정보를 조회하는 사용자가 일치하는지 확인
		MemberVo loginUser = (MemberVo)session.getAttribute("loginUser");
		if (loginUser.getMemId().equals(memId)==false) { //로그인한 사용자와 상세정보를 조회하는 사용자가 다를 때
//			return "redirect:/member/list.do"; list 화면으로 되돌아가거나
			throw new RuntimeException("권한이 없습니다."); // 예외(에러) 발생을 시킨다.
		}
		MemberVo vo = memberService.select(memId);
		modelMap.put("memberVo", vo);
		return "member/memEdit";
	}
	
	@RequestMapping(value ="/member/edit.do", method=RequestMethod.POST)
	public String edit(MemberVo vo, HttpSession session) {
		MemberVo loginUser = (MemberVo)session.getAttribute("loginUser");
		if (loginUser.getMemId().equals(vo.getMemId())==false) { //로그인한 사용자와 상세정보를 조회하는 사용자가 다를 때
			throw new RuntimeException("권한이 없습니다."); // 예외(에러) 발생을 시킨다.
		}
		int num = memberService.update(vo);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping(value ="/member/del.do")
	public String delete(String memId, HttpSession session) {
		MemberVo loginUser = (MemberVo)session.getAttribute("loginUser");
		if (loginUser.getMemId().equals(memId)==false) { //로그인한 사용자와 상세정보를 조회하는 사용자가 다를 때
			throw new RuntimeException("권한이 없습니다."); // 예외(에러) 발생을 시킨다.
		}
		int num = memberService.delete(memId);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping(value ="/member/login.do", method=RequestMethod.GET)
	public String loginForm() {
		return "member/login";
	}
	
	@RequestMapping(value ="/member/login.do", method=RequestMethod.POST)
	public String login(MemberVo vo, HttpSession session) { //스프링이 실행 시 세션객체를 전달
		// 사용자가 입력한 id/password와 일치하는지 회원 정보 조회
		MemberVo mvo = memberService.selectLoginUser(vo);
		if (mvo == null) { // mvo == null, == 일치하는 회원 정보가 없는 경우 == 로그인 실패
			return "member/login"; // 다시 로그인 화면 출력
		}
		// (mvo != null) == 일치하는 회원 정보가 있는 경우 == 로그인 성공 ==> 로그인 한 사용자 정보(mvo)를 세션에 "loginUser"라는 이름으로 저장
		session.setAttribute("loginUser", mvo);
		return "redirect:/bbs/list.do"; //게시판 글 목록으로 이동
	}
	
	@RequestMapping(value ="/member/logout.do")
	public String logout(HttpSession session) {
		// 로그아웃 == 세션에 저장된 로그인 정보를 삭제
		// 세션에 저장된 정보 삭제 방법 3가지
//		session.setAttribute("loginUser", null); // 세션에 "loginUser" 라는 이름으로 null을 저장
//		session.removeAttribute("loginUser"); // 세션에 "loginUser" 속성 자체를 제거
		session.invalidate(); // 가장 많이 쓰이는 방법, 세션 객체 자체를 삭제(다음 접속 때 새로 생성 됨)
//		return "member/login";
		return "redirect:/member/login.do";
	}
}

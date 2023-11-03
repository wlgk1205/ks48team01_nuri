package ksmart.ks48team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/department")
public class AdminDepartmentController {

	/**
	 * 부서정보 조회 페이지
	 * @param model
	 * @return
	 */
	@GetMapping("/depList")
	public String depList(@RequestParam(name = "depKey", required = false) String depKey,
							   @RequestParam(name = "depValue",  required = false) String depValue,
							   Model model) {

		// 조건문을 사용
		// 전체 회원 페이지를 조회하는 경우 기존 목록조회 Model을 실행
		// 검색을 사용할 경우의 특정회원을 조회하는 Model을 실행

		model.addAttribute("title", "관리자 페이지");
		model.addAttribute("head", "지역/행정기관");

		return "admin/department/depList";
	}

	
	
	/**
	 * 지역 등록 페이지
	 * @param model -> Form <Select>에 들어갈 데이터 전송 & Parsing (파싱에 해당되는지 모르겠음)
	 *              사용자 -> 판매자(클릭) -> 판매자에 해당하는 값(name = 2) 입력
	 * @return
	 */
	@GetMapping("/depRegister")
	public String depRegister(Model model) {
		// 지역 등록 시, Form에 들어갈 카테고리의 데이터를 조회하여 전송
		


		return "admin/department/depRegister";
	}
	
	
	
	@PostMapping("/depRegister")
	public String depRegister() {
		// DTO 타입으로 값 담아서 Mapper에서 Insert 실행

		return "redirect:/admin/department/depList";
	}

	
	
	/**
	 * 사용자 정보 수정
	 * @param model select해서 해당 회원의 정보 가지고와서 출력
	 *              회원가입 Form과 같이, Category에 해당하는 정보는 <select>와 반복문 사용
	 * @return
	 */
	@GetMapping("/depUpdate")
	public String depUpdate(@RequestParam(name = "depCode") String depCode, Model model) {

		model.addAttribute("title", "사용자 정보 수정");

		return "admin/department/depUpdate";
	}

	/**
	 * 회원정보 수정 전송
	 * @param model
	 * @return
	 */
	@PostMapping("/depUpdate")
	public String depUpdate(Model model) {
		// Mapper에서 Update 태그 이외에는 Insert와 동일?

		return "redirect:/admin/department/depList";
	}



	@GetMapping("/depDelete")
	public String depDelete(@RequestParam(name = "depCode") String depCode,
								 Model model) {



		return "admin/department/depDelete";
	}

	/**
	 * 공무원이 아닌, 관리자 권한이 있는 사람이 지역 삭제가능
	 * @param userId 쿼리 사용해서 사용자 권한확인
	 * @param depCode 삭제지역 확인
	 * @return
	 */
	@PostMapping("/depDelete")
	public String depDelete(@RequestParam(name = "depCode") String depCode,
								 @RequestParam(name = "userId") String userId) {

		return "redirect:/admin/department/depList";

	}

}

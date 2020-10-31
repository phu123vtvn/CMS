package com.cms.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cms.converter.MemberConverter;
import com.cms.dto.ContentDTO;
import com.cms.dto.MemberDTO;
import com.cms.dto.MyUser;
import com.cms.repository.MemberRepository;
import com.cms.service.ICategoryService;
import com.cms.service.IContentService;
import com.cms.utils.SecurityUtil;

@RestController(value = "controllerOfAdmin")
public class ContentController {

	@Autowired
	private IContentService icontentService;
	
	@Autowired
	private ICategoryService icategoryService;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberConverter memberConverter;

	@GetMapping(value = "/admin-list")
	public ModelAndView showList(@RequestParam("page") int page,@RequestParam("limit") int limit) {
		ContentDTO model = new ContentDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/list");
		Pageable pageable=new PageRequest(page-1, limit,Sort.Direction.DESC, "id");
		model.setListResult(icontentService.findAll(pageable));
		model.setTotalItem(icontentService.totalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}

	@GetMapping(value = "/admin-add")
	public ModelAndView addPage(@RequestParam(value = "id", required = false) Long id) 
	{
		ModelAndView mav = new ModelAndView("admin/add");
		ContentDTO model = new ContentDTO();
		if(id!=null)
		{
			model=icontentService.findById(id);
		}
		mav.addObject("categories", icategoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	@GetMapping(value = "/admin-edit")
	public ModelAndView editPage() {
		ModelAndView mav = new ModelAndView("admin/edit");
		MemberDTO model=new MemberDTO();
		model=memberConverter.toDTO(memberRepository.findOne(SecurityUtil.getPrincipal().getId()));
		mav.addObject("model", model);
		return mav;
	}

}
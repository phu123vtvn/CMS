package com.cms.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.ContentDTO;
import com.cms.service.IContentService;

@RestController(value = "apiOfContent")
public class ContentAPI {

	@Autowired
	private IContentService icontentService;
	
	@PostMapping("api-content")
	private ContentDTO addContent(@RequestBody ContentDTO dto)
	{
		return icontentService.save(dto);
	}
	@PutMapping("api-content")
	private ContentDTO updateContent(@RequestBody ContentDTO dto)
	{
		if(dto.getSort().equals("3"))
		{
			ContentDTO dto2=icontentService.findById(dto.getId());
			dto2.setSort("2");
			return icontentService.save(dto2);
		}
		if(dto.getSort().equals("4"))
		{
			ContentDTO dto2=icontentService.findById(dto.getId());
			if(dto2.getSort().equals("0"))
			{
				dto2.setSort("1");
			}else
			{
				dto2.setSort("0");
			}
			
			return icontentService.save(dto2);
		}
		return icontentService.save(dto);
	}
}

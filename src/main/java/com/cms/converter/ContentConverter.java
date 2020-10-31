package com.cms.converter;

import org.springframework.stereotype.Component;

import com.cms.dto.ContentDTO;
import com.cms.entity.ContentEntity;
import com.cms.utils.SecurityUtil;

@Component
public class ContentConverter {

	public ContentEntity toEntity(ContentDTO dto) {
		ContentEntity result = new ContentEntity();
		result.setTitle(dto.getTitle());
		result.setContent(dto.getContent());
		result.setBrief(dto.getBrief());
		result.setSort(dto.getSort());
		return result;
	}
	
	public ContentEntity toEntity(ContentEntity result, ContentDTO dto) {
		result.setTitle(dto.getTitle());
		result.setContent(dto.getContent());
		result.setBrief(dto.getBrief());
		result.setSort(dto.getSort());
		return result;
	}
	
	public ContentDTO toDTO(ContentEntity entity) {
		ContentDTO result = new ContentDTO();
		result.setId(entity.getId());
		result.setBrief(entity.getBrief());
		result.setContent(entity.getContent());
		result.setTitle(entity.getTitle());
		result.setCategoryType(entity.getCategory().getTitle());
		result.setCreateDate(entity.getCreateDate());
		result.setSort(entity.getSort());
		result.setAuthorId(entity.getMember().getId());
		return result;
	}
}

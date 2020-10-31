package com.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cms.converter.ContentConverter;
import com.cms.dto.ContentDTO;
import com.cms.entity.CategoryEntity;
import com.cms.entity.ContentEntity;
import com.cms.entity.MemberEntity;
import com.cms.repository.CategoryRepository;
import com.cms.repository.ContentRepository;
import com.cms.repository.MemberRepository;
import com.cms.service.IContentService;

@Service
public class ContentService implements IContentService{

	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ContentConverter contentConverter;

	@Override
	public List<ContentDTO> findAll(Pageable pageable) {
		 List<ContentDTO> model=new ArrayList<>();
		 List<ContentEntity> entities=contentRepository.findAllBySortOrSort(pageable,"0","1");
		 for(ContentEntity entity:entities)
		 {
			 ContentDTO dto=contentConverter.toDTO(entity);
			 model.add(dto);
		 }
		return model;
	}

	@Override
	public Long totalItem() {
		return contentRepository.countBySortOrSort("0", "1");
	}

	@Override
	public ContentDTO save(ContentDTO dto) {
		CategoryEntity category = categoryRepository.findOneByTitle(dto.getCategoryType());
		MemberEntity memberEntity= memberRepository.findOne(dto.getAuthorId());
		ContentEntity contentEntity = new ContentEntity();
		if (dto.getId() != null) {
			ContentEntity oldNew = contentRepository.findOne(dto.getId());
			oldNew.setCategory(category);
			contentEntity = contentConverter.toEntity(oldNew, dto);
		} else {
			contentEntity = contentConverter.toEntity(dto);
			contentEntity.setCategory(category);
			contentEntity.setMember(memberEntity);
		}
		return contentConverter.toDTO(contentRepository.save(contentEntity));
	}

	@Override
	public ContentDTO findById(Long id) {
		ContentEntity entity=contentRepository.findOne(id);
		return contentConverter.toDTO(entity);
	}
	
	
}

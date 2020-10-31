package com.cms.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cms.dto.ContentDTO;

public interface IContentService {
	List<ContentDTO> findAll(Pageable pageable);
	Long totalItem();
	ContentDTO save(ContentDTO dto);
	ContentDTO findById(Long id);
}

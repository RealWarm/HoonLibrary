package com.group.libraryapp.util.image.service;


import com.group.libraryapp.util.image.damin.ImageResult;
import com.group.libraryapp.util.image.damin.ImageResultRepository;
import com.group.libraryapp.util.image.dto.ImageResultResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
//@RequiredArgsConstructor
public class ImagesResultsService {

    private final ImageResultRepository imageResultRepository;

    public ImagesResultsService(ImageResultRepository imageResultRepository) {
        this.imageResultRepository = imageResultRepository;
    }

    public void saveImageResult(ImageResult imageResult){
        imageResultRepository.save(imageResult);
    }

    public Page<ImageResult> findAll(Pageable pageable){
        Page<ImageResult> page = imageResultRepository.findAll(pageable);
        return page;
    }//findAll

    public Page<ImageResult> findByTitleContaining(String title, Pageable pageable){
        return imageResultRepository.findByTitleContaining(title, pageable);
    }


}

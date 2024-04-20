package com.group.libraryapp.util.image.damin;

import com.group.libraryapp.util.image.damin.ImageResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageResultRepository extends JpaRepository<ImageResult, Long> {

    Page<ImageResult> findByTitleContaining(String title, Pageable pageable);



}

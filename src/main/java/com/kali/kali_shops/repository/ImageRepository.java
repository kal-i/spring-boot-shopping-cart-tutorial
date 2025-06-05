package com.kali.kali_shops.repository;

import com.kali.kali_shops.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

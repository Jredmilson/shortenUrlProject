package com.shortner.url.shortner.url.repository;

import com.shortner.url.shortner.url.model.ShortnerBodyDTO;
import com.shortner.url.shortner.url.model.ShortnerDTO;
import com.shortner.url.shortner.url.model.ShortnerEntity;
import com.shortner.url.shortner.url.model.ShortnerResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ShortnerRepository extends JpaRepository<ShortnerEntity, Long> {

    ShortnerEntity findByShortenedUrl(String shortenedUrl);

    @Query(value = "SELECT * FROM URLS c where NOW() > c.EXPIRATION_DATE_TIME", nativeQuery = true)
    List<ShortnerEntity> findAllExpiredUrls();

}

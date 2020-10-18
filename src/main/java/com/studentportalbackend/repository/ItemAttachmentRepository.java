package com.studentportalbackend.repository;

import com.studentportalbackend.model.ItemAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemAttachmentRepository extends JpaRepository<ItemAttachment, Integer> {

    List<ItemAttachment> findAttachmentsByItemId(Integer itemId);
}

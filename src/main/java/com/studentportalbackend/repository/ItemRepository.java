package com.studentportalbackend.repository;

import com.studentportalbackend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findItemsBySellerId(Integer sellerId);
}

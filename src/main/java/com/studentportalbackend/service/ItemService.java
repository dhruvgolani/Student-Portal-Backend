package com.studentportalbackend.service;

import com.studentportalbackend.model.Item;
import com.studentportalbackend.model.ItemAttachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ItemService {

    Map<Object, Object> getItems();

    Map<Object, Object> getItemBySellerId(Integer sellerId);

    Item addItem(Integer sellerId, String name, String category, String usedTime, String quotedPrice, MultipartFile file) throws IOException;

    List<ItemAttachment> getAttachmentsByItemId(Integer itemId);

    ItemAttachment storeItemAttachment(MultipartFile file, Integer itemId) throws IOException;
}

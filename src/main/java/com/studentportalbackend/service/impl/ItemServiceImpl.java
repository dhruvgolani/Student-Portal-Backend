package com.studentportalbackend.service.impl;

import com.studentportalbackend.model.Item;
import com.studentportalbackend.model.ItemAttachment;
import com.studentportalbackend.repository.ItemAttachmentRepository;
import com.studentportalbackend.repository.ItemRepository;
import com.studentportalbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemAttachmentRepository itemAttachmentRepository;

    @Override
    public Map<Object, Object> getItems() {
        List<Item> itemList = itemRepository.findAll();
        List<List<ItemAttachment>> attachmentList = new ArrayList<>();
        for(Item item : itemList){
            attachmentList.add(getAttachmentsByItemId(item.getItemId()));
        }
        Map<Object, Object> items = new HashMap<>();
        items.put("items", itemList);
        items.put("attachments", attachmentList);
        return items;
    }

    @Override
    public Map<Object, Object> getItemBySellerId(Integer sellerId) {
        List<Item> itemList = itemRepository.findItemsBySellerId(sellerId);
        List<List<ItemAttachment>> attachmentList = new ArrayList<>();
        for(Item item : itemList){
            attachmentList.add(getAttachmentsByItemId(item.getItemId()));
        }
        Map<Object, Object> items = new HashMap<>();
        items.put("items", itemList);
        items.put("attachments", attachmentList);
        return items;
    }

    @Override
    public Item addItem(Integer sellerId, String name, String category, String usedTime, String quotedPrice, MultipartFile file) throws IOException {
        Item item = new Item(sellerId, name, category, usedTime, quotedPrice);
        itemRepository.save(item);
        storeItemAttachment(file, item.getItemId());
        return item;
    }

    @Override
    public List<ItemAttachment> getAttachmentsByItemId(Integer itemId) {
        return itemAttachmentRepository.findAttachmentsByItemId(itemId);
    }

    @Override
    public ItemAttachment storeItemAttachment(MultipartFile file, Integer itemId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ItemAttachment itemAttachment = new ItemAttachment(itemId, fileName, file.getContentType(), file.getBytes());
        return itemAttachmentRepository.save(itemAttachment);
    }
}

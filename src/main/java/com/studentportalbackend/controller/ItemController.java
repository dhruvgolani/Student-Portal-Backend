package com.studentportalbackend.controller;

import com.studentportalbackend.model.Item;
import com.studentportalbackend.model.ItemAttachment;
import com.studentportalbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/item")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/get")
    public Map<Object, Object> getAllItems(){
        return itemService.getItems();
    }

    @RequestMapping(value = "/get/{sellerId}")
    public Map<Object, Object> getItemsBySellerId(@PathVariable Integer sellerId){
        return itemService.getItemBySellerId(sellerId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addItem(@RequestParam("sellerId") Integer sellerId, @RequestParam("name") String name, @RequestParam("category") String category, @RequestParam("usedTime") String usedTime, @RequestParam("quotedPrice") String quotedPrice, @RequestParam("file") MultipartFile file){
        try {
            itemService.addItem(sellerId, name, category, usedTime, quotedPrice, file);
            return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new HashMap<>());
        }
    }

    @RequestMapping(value = "/attachment/get/{itemId}")
    public List<ItemAttachment> getItemAttachment(@PathVariable Integer itemId){
        return itemService.getAttachmentsByItemId(itemId);
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ResponseEntity<Object> storeItemAttachment(@RequestParam("file") MultipartFile file, @RequestParam("itemId") Integer itemId){
        String message = "";
        try {
            itemService.storeItemAttachment(file, itemId);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new HashMap<>());
        }
    }

}

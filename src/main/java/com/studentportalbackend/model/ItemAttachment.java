package com.studentportalbackend.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name="ItemAttachments")
@Accessors(chain = true)
@Data
public class ItemAttachment {

    @Id
    @GeneratedValue
    @Column(name = "attachment_id")
    private Integer attachmentId;

    @Column (name = "item_id" ,nullable = false)
    private Integer itemId;

    @Column (name = "name" ,nullable = false)
    private String name;

    @Column (name = "type" ,nullable = false)
    private String type;

    @Lob
    @Column (name = "file_data" ,nullable = false)
    private byte[] data;




}

package com.studentportalbackend.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Items")
@Accessors(chain = true)
@Data
public class Item {

    public static Integer NOT_SOLD_STATUS = 0;
    public static Integer SOLD_STATUS = 1;

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Integer itemId;

    @Column (name = "seller_id" ,nullable = false)
    private Integer sellerId;

    @Column (name = "name" ,nullable = false)
    private String name;

    @Column (name = "category" ,nullable = false)
    private String category;

    @Column (name = "used_time" ,nullable = false)
    private String usedTime;

    @Column (name = "quoted_price" ,nullable = false)
    private String quotedPrice;

    @Column (name = "original_price")
    private String originalPrice;

    @Column (name = "other_details")
    private String otherDetails;

    @Column (name = "tags")
    private String tags;

    @Column (name = "status" ,nullable = false)
    private Integer status;

    @Column (name = "created_at" , nullable = false , updatable = false)
    private Date createdAt;

    @Column (name = "last_modified")
    private Date lastModified;

    @PrePersist
    public void prePersist(){
        this.createdAt = new Date();
        this.status = NOT_SOLD_STATUS;
    }

    public Item(){

    }

    public Item(Integer sellerId, String name, String category, String usedTime, String quotedPrice) {
        this.sellerId = sellerId;
        this.name = name;
        this.category = category;
        this.usedTime = usedTime;
        this.quotedPrice = quotedPrice;
    }
}

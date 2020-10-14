package com.studentportalbackend.model;

import com.studentportalbackend.model.enums.ContributionTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contribution_log")
@Accessors(chain = true)
@Data
public class ContributionLog {

    @Id
    @GeneratedValue
    @Column(name="contribution_id")
    private Integer contributionId;

    @Column(name="contribution_points")
    private Integer contributionPoints;

    @Column(name="user_id")
    private Integer userId;

    @Enumerated(EnumType.STRING)
    @Column(name="contribution_type" , nullable = false)
    private ContributionTypeEnum contributionType;

    @Column(name="contribution_type_id")
    private String contributionTypeId;

    @Column(name="comments")
    private String comments;

    @Column(name="created_at" , nullable = false, updatable = false)
    private Date created_at;


    @PrePersist
    public void prePersist(){
        this.created_at = new Date();
    }

    public String getContributionType() {
        return contributionType.getContributionTypeEnum();
    }

    public ContributionLog setContributionType(String contributionType) {
        this.contributionType = ContributionTypeEnum.parse(contributionType);
        return  this;
    }

}

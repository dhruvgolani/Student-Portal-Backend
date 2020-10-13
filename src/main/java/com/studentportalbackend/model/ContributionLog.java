package com.studentportalbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ContributionLog {

    @Id
    @GeneratedValue
    @Column(name="contribution_id")
    private Integer contributionId;

    @Column(name="contribution_points")
    private Integer contributionPoints;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="contribution_type")
    private String contributionType;

    @Column(name="contribution_type_id")
    private String contributionTypeId;

    @Column(name="comments")
    private String comments;

    @Column(name="created_at")
    private Date created_at;


    public Integer getContributionId() {
        return contributionId;
    }

    public void setContributionId(Integer contributionId) {
        this.contributionId = contributionId;
    }

    public Integer getContributionPoints() {
        return contributionPoints;
    }

    public void setContributionPoints(Integer contributionPoints) {
        this.contributionPoints = contributionPoints;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContributionType() {
        return contributionType;
    }

    public void setContributionType(String contributionType) {
        this.contributionType = contributionType;
    }

    public String getContributionTypeId() {
        return contributionTypeId;
    }

    public void setContributionTypeId(String contributionTypeId) {
        this.contributionTypeId = contributionTypeId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}

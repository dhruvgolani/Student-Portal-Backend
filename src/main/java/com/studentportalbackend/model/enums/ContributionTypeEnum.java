package com.studentportalbackend.model.enums;

public enum ContributionTypeEnum {

    LOGIN("LOGIN") , NOTES("NOTES");

    private String contributionTypeEnum;

    ContributionTypeEnum(String contributionTypeEnum) {
        this.contributionTypeEnum = contributionTypeEnum;
    }

    public String getContributionTypeEnum(){
        return this.contributionTypeEnum;
    }

    public static  ContributionTypeEnum parse(String contributionType){
        ContributionTypeEnum contributionTypeEnum = null;
        for(ContributionTypeEnum item: ContributionTypeEnum.values()){
            if(item.getContributionTypeEnum().equals(contributionType)){
                contributionTypeEnum = item;
                break;
            }
        }
        return contributionTypeEnum;
    }


}

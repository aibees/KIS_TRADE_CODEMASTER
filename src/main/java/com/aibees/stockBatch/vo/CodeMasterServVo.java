package com.aibees.stockBatch.vo;

import lombok.Data;

import java.util.List;

@Data
public class CodeMasterServVo {
    private String code; // 종목코드
    private String groupCode; // 그룹코드
    private String groupName; // 그룹명
    private String CapitalScaleClass; // 시가총액규모 구분코드
    private String CapitalScaleName; // 시가총액규모 구분명
    private String businessType1; // 업종구분(대분류)
    private String businessType2; // 업종구분(중분류)
    private String businessType3; // 업종구분(소분류)
    private String mninYn; // 제조업 구분(Y/N)
    private String lowCurrentYn; // 저 유동성 여부
    private String nmixIssueYn; // 지배구조지수 종목여부
    private String sectorCode; // 섹터코드
    private String sectorName; // 섹터명
}

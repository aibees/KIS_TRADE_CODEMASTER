package com.aibees.stockBatch.service;

import com.aibees.stockBatch.common.StringUtils;

import java.util.List;

public class MasterCodeServ implements MasterCodeProcess {

    @Override
    public void process(List<String[]> data) {

    }

    /**
     * 증권그룹 구분코드
     * @param code
     * @return
     */
    private String getGroupName(String code) {
        String name;

        switch(code) {
            case "ST" :
                name = "주권"; break;
            case "MF" :
                name = "증권투자회사"; break;
            case "RT" :
                name = "부동산투자회사"; break;
            case "SC" :
                name = "선박투자회사"; break;
            case "IF" :
                name = "사회간접자본투융자회사"; break;
            case "DR" :
                name = "주식예탁증서"; break;
            case "EW" :
                name = "ELW"; break;
            case "SW" :
                name = "신주인수권증권"; break;
            case "SR" :
                name = "신주인수권증서"; break;
            case "BC" :
                name = "수익증권"; break;
            case "FE" :
                name = "해외ETF"; break;
            case "FS" :
                name = "외국주권"; break;
            case "EF" :
                name = "ETF"; break;
            default:
                name = ""; break;
        }
        return name;
    }

    /**
     * 시가총액규모 구분코드 명칭
     * @param scale
     * @return
     */
    private String getCapitalSize(String scale) {
        if(StringUtils.isEquals(scale, "1")) {
            // 대(big)
            return "BIG";
        } else if(StringUtils.isEquals(scale, "2")) {
            // 중(medium)
            return "MEDIUM";
        } else if(StringUtils.isEquals(scale, "3")) {
            // 소(small)
            return "SMALL";
        } else {
            // 제외(etc)
            return "ETC";
        }
    }


    /**
     * KOSPI200 기준 섹터업종
     * @param sector
     * @return
     */
    private String getSectorName(String sector) {
        if(StringUtils.isEquals(sector, "1")) {
            return "건설기계";
        } else if(StringUtils.isEquals(sector, "2")) {
            return "조선운송";
        } else if(StringUtils.isEquals(sector, "3")) {
            return "철강소재";
        } else if(StringUtils.isEquals(sector, "4")) {
            return "에너지화학";
        } else if(StringUtils.isEquals(sector, "5")) {
            return "정보통신";
        } else if(StringUtils.isEquals(sector, "6")) {
            return "금융";
        } else if(StringUtils.isEquals(sector, "7")) {
            return "필수소비재";
        } else if(StringUtils.isEquals(sector, "8")) {
            return "자유소비재";
        } else {
            return "미분류";
        }
    }
}

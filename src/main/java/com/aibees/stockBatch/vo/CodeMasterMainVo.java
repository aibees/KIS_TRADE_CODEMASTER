package com.aibees.stockBatch.vo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CodeMasterMainVo {
    private String code; // 종목코드
    private String originCode; // 표준코드
    private String name; // 종목 명
}

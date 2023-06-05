package com.aibees.stockBatch;

import com.aibees.stockBatch.common.RESULT;
import com.aibees.stockBatch.service.FileService;

import java.util.Map;

public class CodeMasterApplication {
    public static void main(String[] args) {
        new CodeMasterApplication().execute();
    }

    private final FileService fileService = new FileService();

    private void execute() {
        // 1. get csv file
        // 1-1. read and exrtract master code from csv file
        // main은 CodeMasterVo 객체로 파싱 된 채로 나온다. 3개 뿐이므로...
        Map<String, Object> extractsMain = fileService.readCsv("");
        // serv는 MasterCodeServ에서 한번 더 정제
        Map<String, Object> extractsServ = fileService.readCsv("");

        // 1-2. post-processing
        if(RESULT.ERROR == extractsMain.get("result")) {

        }
        if(RESULT.ERROR == extractsServ.get("result")) {

        } else {

        }

        // 2. insert/update to db

        // 2-A. delete old data

        // 2-B. insert new data
    }
}
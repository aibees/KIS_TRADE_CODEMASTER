package com.aibees.stockBatch.service;

import com.aibees.stockBatch.common.RESULT;
import com.aibees.stockBatch.vo.CodeMasterMainVo;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileService {
    public Map<String, Object> readCsv(String urlString) {
        Map<String, Object> result = new HashMap<>();
        List<String[]> codeList = new ArrayList<>();
        File codeCsv = new File(urlString);
        try {
            BufferedReader br = new BufferedReader(new FileReader(codeCsv));
            String line;

            while(true) {
                try {
                    line = br.readLine();
                    if(StringUtils.isEmpty(line)) {
                        break;
                    }
                    codeList.add(line.split(","));

                } catch(IOException ioe) {
                    result.put("status", RESULT.PARTIAL);
                    result.put("result", codeList);
                    break;
                }
            }

        } catch(FileNotFoundException ffe) {
            result.put("status", RESULT.ERROR);
            result.put("result", null);
        }

        if(!result.containsKey("status")) {
            result.put("status", RESULT.SUCCEESS);
            result.put("result", codeList);
        }

        return result;
    }
}

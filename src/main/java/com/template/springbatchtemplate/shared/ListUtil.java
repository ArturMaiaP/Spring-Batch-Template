package com.template.springbatchtemplate.shared;

import java.util.List;

public class ListUtil {
    public static boolean listIsNullOrEmpty(List<?> list){
        return list ==  null || list.isEmpty();
    }
}

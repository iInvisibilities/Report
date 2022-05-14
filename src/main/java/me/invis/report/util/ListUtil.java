package me.invis.report.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    public static <A> List<A> removeAll(List<A> list, A element) {
        List<A> outputList = new ArrayList<>(list);
        outputList.removeIf(listElement -> listElement.equals(element));

        return outputList;
    }

}

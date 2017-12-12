package nju.lighting.bl.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created on 2017/12/10.
 * Description:
 * @author Liao
 */
public class VPOTransformer {
    public static <IN, OUT> List<OUT> toVPOList(List<IN> voList, Function<IN, OUT> function) {
        return voList.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}
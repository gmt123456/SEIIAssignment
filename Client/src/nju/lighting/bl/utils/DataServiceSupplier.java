package nju.lighting.bl.utils;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * Created on 2017/12/13.
 * Description:
 * @author Liao
 */
@FunctionalInterface
public interface DataServiceSupplier<T> {
    T get() throws RemoteException;

    static <VO, PO> List<VO> getAll(DataServiceSupplier<List<PO>> supplier, Function<PO, VO> poTransformer) {
        try {
            List<PO> poList = supplier.get();
            return VPOTransformer.toVPOList(poList, poTransformer);
        } catch (RemoteException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
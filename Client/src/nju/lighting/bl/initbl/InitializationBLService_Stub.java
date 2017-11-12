package nju.lighting.bl.initbl;

import nju.lighting.blservice.initblservice.InitializationBLService;
import nju.lighting.vo.InitVO;
import shared.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created on 2017/10/22.
 * Description:
 * @author Liao
 */
public class InitializationBLService_Stub implements InitializationBLService {
    @Override
    public InitVO getInitInfo()  {
        return null;
    }

    @Override
    public ResultMessage commit(InitVO vo)  {
        return vo == null ? ResultMessage.FAILURE : ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<InitVO> getHistoryInfo()  {
        ArrayList<InitVO> initVOS = new ArrayList<>();
        initVOS.add(getInitInfo());
        return initVOS;
    }
}

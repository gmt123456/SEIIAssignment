package nju.lighting.blservice.documentblservice;

import shared.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LossAndGainDocBLService extends Remote {

    ResultMessage addLossAndGainDoc(LossAndGainDocPO lossAndGainDocPO) throws RemoteException;
}

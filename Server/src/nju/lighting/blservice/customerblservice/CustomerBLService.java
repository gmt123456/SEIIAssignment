package nju.lighting.blservice.customerblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import nju.lighting.vo.ResultMessage;
import nju.lighting.vo.CustomerVO;

public interface CustomerBLService {

    //得到客户列表
    public ArrayList<CustomerVO> getCustomerList () throws RemoteException;

    //增加客户
    public ResultMessage addCustomer(CustomerVO customer) throws RemoteException;

    //查找客户
    public ArrayList<CustomerVO> findCustomer(String keyword) throws RemoteException;

    //删除客户
    public ResultMessage deleteCustomer(CustomerVO customer) throws RemoteException;

    //更改客户信息
    public ResultMessage modifyCustomer(CustomerVO customer) throws RemoteException;

    //结束客户管理
    public void endCustomerManage() throws RemoteException;
}
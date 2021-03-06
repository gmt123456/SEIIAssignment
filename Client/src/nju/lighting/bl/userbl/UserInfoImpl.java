package nju.lighting.bl.userbl;

import nju.lighting.bl.utils.DataServiceFunction;
import nju.lighting.dataservice.DataFactory;
import nju.lighting.dataservice.userdataservice.UserDataService;
import nju.lighting.po.user.UserPO;
import nju.lighting.vo.UserVO;
import shared.Identity;

import javax.naming.NamingException;

/**
 * Created on 2017/11/30.
 * Description:
 * @author Liao
 */
public class UserInfoImpl implements UserInfo {
    private UserDataService dataService;

    public UserInfoImpl() {
        try {
            dataService = DataFactory.getDataBase(UserDataService.class);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean authorized() {
        return LoginHelper.INSTANCE.getSignedInUser().isAuthorized();
    }

    @Override
    public Identity getIdentityById(String userId) {
        return DataServiceFunction.findToEntity(userId, dataService::get, UserPO::getIdentity);
    }

    @Override
    public String getIDOfSignedUser() {
        return LoginHelper.INSTANCE.getSignedInUser().getId();
    }

    @Override
    public UserVO getUserVOByID(String userID) {
        return DataServiceFunction.findToEntity(userID, dataService::get, po -> new User(po).toVO());
    }
}

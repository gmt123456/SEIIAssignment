package nju.lighting.bl.accountbl;

import nju.lighting.bl.logbl.Logger;
import nju.lighting.bl.logbl.MockLogger;
import nju.lighting.bl.userbl.UserInfo;
import nju.lighting.bl.userbl.UserInfoImpl;
import nju.lighting.presentation.utils.NameChecker;
import nju.lighting.dataservice.DataFactory;
import nju.lighting.dataservice.accountdataservice.AccountDataService;
import nju.lighting.po.account.AccountPO;
import nju.lighting.vo.account.AccountVO;
import shared.OPType;
import shared.ResultMessage;

import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/11/6.
 * Description:
 * @author Liao
 */
public enum AccountManager {
    /**
     * Singleton
     */
    INSTANCE;

    private AccountDataService accountDataService;
    private Logger logger;

    AccountManager() {
        try {
            accountDataService = DataFactory.getAccountDataBase();
            logger = new MockLogger();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static AccountManager getInstance() {
        return INSTANCE;
    }

    /**
     * Add new account
     * @param id     id of account(银行账号）
     * @param name   name of account(Whatever)
     * @param amount initial amount of this account
     * @return <code>ResultMessage.SUCCESS</code> if add account successfully <br>
     * <cdoe>ResultMessage.DUPLICATE</cdoe> if id duplicated<br>
     * <code>ResultMessage.INVALID_NAME</code> if find id repeated or name invalid <br>
     * <code>ResultMessage.NETWORK_FAIL</code> if network failed<br>
     * <code>ResultMessage.FAILURE</code> if user was not authorized
     */
    ResultMessage addAccount(String id, String name, double amount) {
        // Check authority of current user
        if (!currentUserAuthorized())
            return ResultMessage.FAILURE;

        // Check id, name's correctness
        try {
            // Check duplication
            AccountPO po = accountDataService.get(id);
            if (po != null) // Find Duplicated
                return ResultMessage.DUPLICATE;
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // Check name's correctness
        if (!NameChecker.validName(name)) return ResultMessage.INVALID_NAME;

        // Create new account and insert to the database
        Account account = new Account(id, amount, name);
        try {
            ResultMessage res = accountDataService.insert(account.toPO());
            if (res == ResultMessage.SUCCESS)
                logger.add(OPType.ADD, "Account", id);
            return res;
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.NETWORK_FAIL;
        }
    }

    /**
     * Get account with the id input
     * @param id id of the account
     * @return <code>null</code> if no account has this id<br>
     * account with this id if it exists
     */
    AccountVO getAccount(String id) {
        try {
            AccountPO po = accountDataService.get(id);
            // If not found
            if (po == null)
                return null;
            // Create Account object
            Account target = new Account(po);
            return target.toVO();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get all accounts
     * @return A <code>List</code> contains all accounts <br>
     * <code>null</code> if any exception happens
     */
    List<AccountVO> getAccountList() {
        try {
            List<AccountPO> poList = accountDataService.getAll();
            // Transform
            List<AccountVO> res = new ArrayList<>();
            for (AccountPO po : poList) {
                res.add(new Account(po).toVO());
            }
            return res;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        // Error happen
        return null;
    }

    /**
     * Delete an account according to the id passed
     * @param id id of the account
     * @return <cdoe>SUCCESS</cdoe> if delete success<br>
     * <code>FAILURE</code> if current user not authorized<br>
     * <code>NETWORK_FAIL</code> if network failed
     */
    ResultMessage delete(String id) {
        // Check user's authority
        if (!currentUserAuthorized())
            return ResultMessage.FAILURE;

        try {
            return accountDataService.delete(id);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.NETWORK_FAIL;
        }
    }

    /**
     * Rename an account
     * @param id      id of the account
     * @param newName new name of the account
     * @return <code>ResultMessage.SUCCESS</code> if the name is valid<br>
     * <code>ResultMessage.DUPLICATE</code> if name repeated<br>
     * <code>ResultMessage.NETWORK_FAIL</code> if network failed<br>
     * <code>ResultMessage.INVALID_NAME</code> if name's invalid<br>
     * <code>FAILURE</code> if current user not authorized
     */
    ResultMessage rename(String id, String newName) {
        // Check user's authority
        if (!currentUserAuthorized())
            return ResultMessage.FAILURE;

        // Check new name's form using regex
        if (!NameChecker.validName(newName))
            return ResultMessage.INVALID_NAME;

        try {
            AccountPO target = accountDataService.get(id);
            if (target.getName().equals(newName))
                return ResultMessage.DUPLICATE; // Repeated
            // Rename succeed
            target.setName(newName);
            logger.add(OPType.MODIFY, "Account Name", id);
            return ResultMessage.SUCCESS;
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.NETWORK_FAIL;
        }
    }

    private boolean currentUserAuthorized() {
        UserInfo userInfo = new UserInfoImpl();
        return userInfo.authorized();
    }
}

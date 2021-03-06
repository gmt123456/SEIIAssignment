package nju.lighting.bl.accountbl;

import nju.lighting.po.account.AccountLogPO;
import nju.lighting.vo.account.AccountLogVO;
import shared.AccountChangeType;

import java.util.Date;

/**
 * Created on 2017/11/12.
 * Description:
 * @author Liao
 */
class AccountChangeLog {
    private int id;
    private Date time;
    private double delta;
    private double amount; // After change
    private AccountChangeType type;

    /**
     * Constructor for adding a new log.
     */
    AccountChangeLog(Date time, double delta, double amount, AccountChangeType type) {
        this.time = time;
        this.delta = delta;
        this.amount = amount;
        this.type = type;
    }

    public AccountChangeLog(AccountLogVO vo) {
        this(vo.getTime(), vo.getDelta(), vo.getAmount(), vo.getType());
    }

    AccountChangeLog(AccountLogPO po) {
        this(po.getTime(), po.getDelta(), po.getAmount(), po.getType());
        id = po.getId();
    }

    /**
     * Convert account change log model to PO, need account's id as a parameter
     * @param accountID id of the account which the log belongs to
     * @return corresponding <code>AccountLogVO</code>
     */
    AccountLogPO toPO(String accountID) {
        return new AccountLogPO(id, time, delta, amount, accountID, type);
    }

    public AccountLogVO toVO() {
        return new AccountLogVO(id, time, delta, amount, type);
    }
}

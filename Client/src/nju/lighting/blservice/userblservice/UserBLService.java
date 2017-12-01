package nju.lighting.blservice.userblservice;

import nju.lighting.vo.UserVO;
import shared.Identity;
import shared.LoginReturnState;
import shared.ResultMessage;
import shared.TwoTuple;

import java.util.ArrayList;

/**
 * Created on 2017/10/21.
 * Description:
 * @author Liao
 */
public interface UserBLService {
    /**
     * Get all users
     * @return User's list
     */
    ArrayList<UserVO> getUserList();

    /**
     * Add a new user, the id, username, identity, authorized and password mustn't be null
     * @param id         id of the user which should only contains letter or number
     * @param username   user's name which should only contains letter, number or Chinese character
     * @param identity   user's identity
     * @param authorized this user whether be authorized
     * @param password   user's password
     * @return <code>ResultMessage.INVALID_ID</code> if id is incorrect<br>
     * <code>ResultMessage.INVALID_NAME</code> if name is incorrect<br>
     * <code>ResultMessage.DUPLICATE</code> if id repeats with others<br>
     * <code>ResultMessage.SUCCESS</code> if add successfully<br>
     * <code>ResultMessage.NETWORK_FAIL</code> if RemoteException was caught
     */
    ResultMessage addUser(String id, String password, Identity identity, String username, boolean authorized);

    ArrayList<UserVO> findUsers(String keyword);

    UserVO getUser(String id);

    /**
     * Delete a user with the id passed in
     * @param id if of the user
     * @return <code>ResultMessage.SUCCESS</code> as long as the database is in connection<br>
     *     or in other words, no failure will be returned unless there's a network problem
     */
    ResultMessage deleteUser(String id);

    ResultMessage modifyUser(UserVO vo);

    String generateJobNum(UserVO vo);

    /**
     * Login a user according to the id and password
     * @param id       user's id
     * @param password user's password
     * @return <code>LoginReturnState.INVALID_USER_NAME</code> and null in the <code>TwoTuple</code><br>
     * <code>LoginReturnState.INVALID_PASSWORD</code> and null in the <code>TwoTuple</code><br>
     * <code>LoginReturnState.SUCCESS</code> and a <code>UserVO</code> in the <code>TwoTuple</code>
     */
    TwoTuple<UserVO, LoginReturnState> login(String id, String password);

    ResultMessage logOut(UserVO vo);
}

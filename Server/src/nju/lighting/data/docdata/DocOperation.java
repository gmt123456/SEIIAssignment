package nju.lighting.data.docdata;

import nju.lighting.data.utils.CommonOperation;
import nju.lighting.data.utils.HibernateUtils;
import nju.lighting.po.doc.DocPO;
import org.hibernate.Session;
import shared.DocState;
import shared.ResultMessage;

import java.util.Date;
import java.util.List;

/**
 * Created on 2017/11/29.
 * Description:
 * @author iznauy
 */
public class DocOperation {

    public ResultMessage add(DocPO docPO) {
        Session session = HibernateUtils.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.persist(docPO);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return ResultMessage.FAILURE;
        } finally {
            HibernateUtils.closeSession();
        }
        return ResultMessage.SUCCESS;
    }

    public ResultMessage addItemsList(List<Object> list) {
        Session session = HibernateUtils.getCurrentSession();
        try {
            session.getTransaction().begin();
            for (Object obj : list)
                session.persist(obj);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return ResultMessage.FAILURE;
        } finally {
            HibernateUtils.closeSession();
        }
        return ResultMessage.SUCCESS;
    }

    public ResultMessage update(DocPO docPO) {
        Session session = HibernateUtils.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(docPO);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return ResultMessage.FAILURE;
        } finally {
            HibernateUtils.closeSession();
        }
        return ResultMessage.SUCCESS;
    }

    public ResultMessage updateItemsList(List<Object> list) {
        Session session = HibernateUtils.getCurrentSession();
        try {
            session.getTransaction().begin();
            for (Object obj : list)
                session.saveOrUpdate(obj);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return ResultMessage.FAILURE;
        } finally {
            HibernateUtils.closeSession();
        }
        return ResultMessage.SUCCESS;
    }

    public DocPO getById(String className, String id) {
        CommonOperation<DocPO> commonOperation = new CommonOperation<>(className);
        DocPO po = commonOperation.getBySingleField("id", id);
        return DocTypeSetter.setType(className, po);
    }

    public List<DocPO> getAll(String className) {
        CommonOperation<DocPO> commonOperation = new CommonOperation<>(className);
        List<DocPO> pos = commonOperation.getAll();
        return DocTypeSetter.setType(className, pos);
    }

    public List<DocPO> getByUserId(String className, String userId) {
        CommonOperation<DocPO> commonOperation = new CommonOperation<>(className);
        List<DocPO> pos = commonOperation.getListBySingleField("userId", userId);
        return DocTypeSetter.setType(className, pos);
    }

    public List<DocPO> getByDate(Date from, Date to, String className) {
        CommonOperation<DocPO> commonOperation = new CommonOperation<>(className);
        List<DocPO> pos = commonOperation.getDataBetweenTime(from, to, "createTime");
        return DocTypeSetter.setType(className, pos);
    }

    public List<DocPO> getByState(DocState docState, String className) {
        CommonOperation<DocPO> commonOperation = new CommonOperation<>(className);
        List<DocPO> pos = commonOperation.getListBySingleField("state", docState);
        return DocTypeSetter.setType(className, pos);
    }

    public List<Object> getItemList(String itemClassName, String parentId) {
        CommonOperation<Object> commonOperation = new CommonOperation<>(itemClassName);
        return commonOperation.getListBySingleField("docId", parentId);
    }

    public int countByTypeAndDate(Date from, Date to, String className) {
        return getByDate(from, to, className).size();
    }

}

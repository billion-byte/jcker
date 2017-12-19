package org.jcker.smartqq.service.impl;

import org.jcker.smartqq.dao.GroupInfoDao;
import org.jcker.smartqq.domain.GroupInfo;
import org.jcker.smartqq.service.GroupInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-08-31 at 8:25 PM
 *
 * @version 1.0
 */
@Service
public class GroupInfoServiceImpl implements GroupInfoService {
    @Autowired
    GroupInfoDao groupInfoDao;

    @Override
    public void saveOrUpdateGroupInfo(List<GroupInfo> groupInfoList) {
        groupInfoDao.save(groupInfoList);
    }

    @Override
    public GroupInfo getGroupInfoByGid(long gid) {
        return groupInfoDao.getGroupInfoByGid(gid);
    }

    @Override
    public void deleteAll() {
        groupInfoDao.deleteAll();
    }
}

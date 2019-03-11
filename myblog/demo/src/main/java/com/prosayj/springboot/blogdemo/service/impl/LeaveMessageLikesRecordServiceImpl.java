package com.prosayj.springboot.blogdemo.service.impl;

import com.prosayj.springboot.blogdemo.mapper.LeaveMessageLikesRecordMapper;
import com.prosayj.springboot.blogdemo.model.LeaveMessageLikesRecord;
import com.prosayj.springboot.blogdemo.service.LeaveMessageLikesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Describe:
 */
@Service
public class LeaveMessageLikesRecordServiceImpl implements LeaveMessageLikesRecordService {

    @Autowired
    LeaveMessageLikesRecordMapper leaveMessageLikesRecordMapper;


    @Override
    public boolean isLiked(String pageName, int pId, int likeId) {

        return leaveMessageLikesRecordMapper.isLiked(pageName, pId, likeId) != null;
    }

    @Override
    public void insertLeaveMessageLikesRecord(LeaveMessageLikesRecord leaveMessageLikesRecord) {
        leaveMessageLikesRecordMapper.insertLeaveMessageLikesRecord(leaveMessageLikesRecord);
    }
}

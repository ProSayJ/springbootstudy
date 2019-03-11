package com.prosayj.springboot.blogdemo.service;

import com.prosayj.springboot.blogdemo.model.FeedBack;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Describe:反馈业务操作
 */
@Service
public interface FeedBackService {

    /**
     * 保存反馈信息
     * @param feedBack
     * @return
     */
    @Transactional
    JSONObject submitFeedback(FeedBack feedBack);

    /**
     * 获得所有的反馈
     * @return
     */
    JSONObject getAllFeedback(int rows, int pageNum);

}

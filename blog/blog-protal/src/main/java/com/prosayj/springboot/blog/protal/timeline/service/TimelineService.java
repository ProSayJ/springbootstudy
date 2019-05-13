package com.prosayj.springboot.blog.protal.timeline.service;


import com.prosayj.springboot.blog.core.entity.timeline.Timeline;

import java.util.List;

/**
 * TimeLineService
 *
 * @description
 */
public interface TimelineService {

    /**
     * 获取timeLine数据
     *
     * @return
     */
    List<Timeline> listTimeLine();
}

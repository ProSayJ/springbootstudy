package com.prosayj.springboot.blog.protal.timeline.service.impl;

import com.prosayj.springboot.blog.core.entity.timeline.Timeline;
import com.prosayj.springboot.blog.core.entity.timeline.TimelineMonth;
import com.prosayj.springboot.blog.core.entity.timeline.TimelinePost;
import com.prosayj.springboot.blog.core.mapper.timeline.TimelineMapper;
import com.prosayj.springboot.blog.protal.timeline.service.TimelineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimelineServiceImpl implements TimelineService {

    @Resource
    private TimelineMapper timelineMapper;

    /**
     * timelineMapper
     * 获取timeLine数据
     *
     * @return
     */
    @Override
    public List<Timeline> listTimeLine() {
        List<Timeline> timelineList = timelineMapper.listTimeline();
        genTimelineMonth(timelineList);
        return timelineList;
    }

    private List<Timeline> genTimelineMonth(List<Timeline> timelineList) {
        for (Timeline timeline : timelineList) {
            List<TimelineMonth> timelineMonthList = new ArrayList<>();
            for (int i = 1; i < 13; i++) {
                List<TimelinePost> postList = timelineMapper.listTimelinePost(timeline.getYear(), i);
                TimelineMonth month = new TimelineMonth();
                month.setCount(postList.size());
                month.setMonth(i);
                month.setPosts(postList);
                timelineMonthList.add(month);
            }
            timeline.setMonths(timelineMonthList);
        }
        return timelineList;
    }

}

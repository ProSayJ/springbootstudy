package com.prosayj.springboot.blog.core.mapper.timeline;

import com.prosayj.springboot.blog.core.entity.timeline.Timeline;
import com.prosayj.springboot.blog.core.entity.timeline.TimelinePost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//TimeLineMapper
@Mapper
public interface TimelineMapper {

    List<TimelinePost> listTimelinePost(@Param("year") Integer year, @Param("month") Integer month);

    List<Timeline> listTimeline();
}

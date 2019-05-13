package com.prosayj.springboot.blog.core.entity.timeline;

import lombok.Data;

import java.util.List;

@Data
public class TimelineMonth {

    private Integer month;

    private Integer count;

    private List<TimelinePost> posts;

}

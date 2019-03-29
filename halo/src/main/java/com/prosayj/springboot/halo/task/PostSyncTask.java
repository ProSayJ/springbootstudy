package com.prosayj.springboot.halo.task;

import com.prosayj.springboot.halo.model.domain.Post;
import com.prosayj.springboot.halo.service.PostService;
import com.prosayj.springboot.halo.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;

import static com.prosayj.springboot.halo.model.dto.HaloConst.POSTS_VIEWS;

/**
 * @author : ProSayJ
 * @date : 2018/12/5
 */
@Slf4j
public class PostSyncTask {

    /**
     * 将缓存的图文浏览数写入数据库
     */
    public void postSync() {
        final PostService postService = SpringUtil.getBean(PostService.class);
        int count = 0;
        for (Long key : POSTS_VIEWS.keySet()) {
            Post post = postService.getByIdOfNullable(key);
            if (null != post) {
                post.setPostViews(post.getPostViews() + POSTS_VIEWS.get(key));
                postService.create(post);
                count++;
            }
        }
        log.info("The number of visits to {} posts has been updated", count);
        POSTS_VIEWS.clear();
    }
}

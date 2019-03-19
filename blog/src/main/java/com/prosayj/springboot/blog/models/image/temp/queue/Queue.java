package com.prosayj.springboot.blog.models.image.temp.queue;

/**
 * @author wang.xw
 * @date 2018/8/6 15:57.
 */
public interface Queue<E> {
    boolean offer(E e);

    E poll();

    E peek();
}

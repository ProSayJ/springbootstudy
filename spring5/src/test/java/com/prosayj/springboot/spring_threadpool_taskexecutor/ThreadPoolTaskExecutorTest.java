package com.prosayj.springboot.spring_threadpool_taskexecutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/11 0:51
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MultiThreadConfig.class})
public class ThreadPoolTaskExecutorTest {
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    @Test
    public void test() throws InterruptedException {
        int n = 10;
        CountDownLatch end = new CountDownLatch(10);

        for (int i = 0; i < n; i++) {
//            Future<String> submit = taskExecutor.submit(new Task());
            taskExecutor.submit(() -> {
                try {
                    int millis = new Random().nextInt(9999);
                    while (millis < 5000) {
                        millis = new Random().nextInt(9999);
                    }
                    System.out.println(Thread.currentThread().getName() + "休眠时间是：" + millis);
                    Thread.sleep(millis);
                    end.countDown();

                } catch (InterruptedException e) {
                }
            });

           /*
            try {
//                System.out.println(submit.get(1000, TimeUnit.MILLISECONDS));
                System.out.println(submit.get(1000, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
*/
        }
       /* taskExecutor.submit(() -> {
        });*/

        end.await();
        System.out.println("所有线程已经完成任务");

/*        while (true) {
            try {
                Thread.sleep(500L);
                long completedTaskCount = taskExecutor.getThreadPoolExecutor().getCompletedTaskCount();
                long taskCount = taskExecutor.getThreadPoolExecutor().getTaskCount();
                System.out.println("线程池任务有：" + taskCount);
                System.out.println("已经完成的线程数：" + completedTaskCount);
                if (completedTaskCount == 50) {
                    System.out.println("所有线程已经完成任务");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/


    }

    class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            String result = "";
            try {
                int millis = new Random().nextInt(9999);
                while (millis < 5000) {
                    millis = new Random().nextInt(9999);
                }
                Thread.sleep(millis);
                result = Thread.currentThread().getName() + "休眠时间是：" + millis;
                System.out.println(result);

            } catch (InterruptedException e) {
            }
            return result;
        }
    }
}


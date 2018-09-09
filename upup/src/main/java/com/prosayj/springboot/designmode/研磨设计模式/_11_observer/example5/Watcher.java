package com.prosayj.springboot.designmode.研磨设计模式._11_observer.example5;
/**
 * 具体的观察者实现
 */
public class Watcher implements WatcherObserver{
	/**
	 * 职务
	 */
	private String job;

	@Override
	public void update(WaterQualitySubject subject) {
		//这里采用的是拉的方式
		System.out.println(job+"获取到通知，当前污染级别为："+subject.getPolluteLevel());
	}

	@Override
	public String getJob() {
		return this.job;
	}

	@Override
	public void setJob(String job) {
		this.job = job;
	}
}

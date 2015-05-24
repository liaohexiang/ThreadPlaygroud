package com.tony.threadpoolexecutor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.tony.roundrobin.RoundRobin;

public class ThreadPoolExecutorTest {

	public static final Log logger = LogFactory.getLog(ThreadPoolExecutorTest.class);
	@Test
	public void test() throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(4);
		final RoundRobin<Integer> roundRobin = new RoundRobin<Integer>();
		for(int i=0; i<100;i++){
			roundRobin.add(i);
		}

		executor.execute(new Runnable() {

			@Override
			public void run() {
				for(int j=0;j<200;j++){
					System.out.println(Thread.currentThread().getName()+":"+roundRobin.next());
				}
			}
		});

		executor.execute(new Runnable() {

			@Override
			public void run() {
				for(int t=0;t<200;t++){
					System.out.println(Thread.currentThread().getName()+":"+roundRobin.next());
				}
			}
		});
		
		executor.execute(new Runnable() {

			@Override
			public void run() {
				for(int t=0;t<200;t++){
					System.out.println(Thread.currentThread().getName()+":"+roundRobin.next());
				}
			}
		});
		
		executor.execute(new Runnable() {

			@Override
			public void run() {
				for(int t=0;t<200;t++){
					System.out.println(Thread.currentThread().getName()+":"+roundRobin.next());
				}
			}
		});
		
		Thread.sleep(20000);
	}
	
	public static void main(String[] args){
		/*for(Object x : System.getProperties().keySet()){
			System.out.println(x +":"+System.getProperty(x.toString()));
		}
		
		List<String> list = new ArrayList<String>();
		list.add("xxx");
		list.add("yyy");
		String[] strs = list.toArray(new String[0]);
		System.out.println(strs.length);*/
		
		Thread t = new Thread(){
			public void run(){
				throw new RuntimeException("error");
			}
		};
		t.start();
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		
	}
	
}

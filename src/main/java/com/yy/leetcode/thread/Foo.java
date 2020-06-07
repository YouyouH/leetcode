package com.yy.leetcode.thread;
/**
 * @author youyouhuang
 * @create 2020-06-07
 **/

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *三个不同的线程将会共用一个 Foo 实例。      线程 A 将会调用 one() 方法     线程 B 将会调用 two() 方法     线程 C 将会调用 three() 方法  请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/print-in-order 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *<p>
 *
 *</p>
 **/
public class Foo {

    private Semaphore semaphore1 = new Semaphore(0);
    private Semaphore semaphore2 = new Semaphore(0);



    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore2.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        semaphore2.release();
    }
}

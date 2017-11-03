package demo01.demo05_read_write_lock;

import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {

    // 两种价格
    private double price1;
    private double price2;

    // 控制价格的锁
    private ReadWriteLock lock;

    public PricesInfo() {
        price1 = 1.0;
        price2 = 2.0;

        lock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        lock.readLock().lock();

        System.out.println(Thread.currentThread().getName()+ " price1 read   =====>");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double value = price1;
        System.out.println(Thread.currentThread().getName()+ "price1 read   <=====");

        lock.readLock().unlock();

        return value;
    }

    public double getPrice2() {
        lock.readLock().lock();

        System.out.println(Thread.currentThread().getName() + "price2 read =====>");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double value = price2;
        System.out.println(Thread.currentThread().getName()+ "price2 read  <=====");

        lock.readLock().unlock();

        return value;
    }

    public void setPrices(double price1, double price2) {
        lock.writeLock().lock();
        System.out.println("start write at " + new Date());
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.price1 = price1;
        this.price2 = price2;

        System.out.println("end write at " + new Date());
        lock.writeLock().unlock();
    }
}

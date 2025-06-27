package com.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WhiteBoardRunner {

    public static void main(String[] args) {

        WhiteBoard obj = new WhiteBoard();

        Runnable reader = () -> {
            try {
                obj.startRead();
                System.out.println(Thread.currentThread().getName() + " is reading");
                Thread.sleep(1000);
                obj.endReading();
            } catch (InterruptedException e) { }
        };
        new Thread(reader).start();

        new Thread(reader).start();

        // now using the write

        Runnable writer = () -> {
            try {
                obj.startWrite();
                System.out.println(Thread.currentThread().getName() + " is writing");
                Thread.sleep(1500);
                obj.endWrite();
            } catch (InterruptedException e) { }
        };

        new Thread(writer).start();
        new Thread(writer).start();

    }
}
class WhiteBoard {


        private final ReentrantLock lock = new ReentrantLock();
        private final Condition canRead = lock.newCondition();
        private final Condition canWrite = lock.newCondition();

        private int readers = 0;
        private boolean isWriting = false;


        // Writer wants to write
        public void startWrite () {
            lock.lock();
            // crical Section
            try {
                while (readers > 0 || isWriting) {
                    System.out.println(" Staring Writing .....");
                    canWrite.await();
                    // wait for reader and other writer to finish
                }
                isWriting = true;
            } catch (Exception e) {
                System.out.println(" Exception in  startWrite: " + e.getMessage());
            } finally {
                lock.unlock();
            }
        }

        // Writer finishes writing

        public void endWrite () {
            lock.lock();
            try {
                System.out.println("End Writing ...");
                isWriting = false;
                canWrite.signal();// Give chance to next writer
                canRead.signalAll();// Allow readers now
            } finally {
                lock.unlock();
            }
        }

        // Reader wants to read
        public void startRead () {
            lock.lock();
            try {
                while (isWriting) {
                    canRead.wait(); // wait if someone is Reading
                }
                System.out.println("Reading start ...");
                readers++;
            } catch (Exception e) {
                System.out.println("Exception in " + getClass().getEnclosingMethod() + " " + e.getMessage());
            } finally {
                lock.unlock();
            }
        }

        // Reader finishes reading
        public void endReading () {
            lock.lock();
            try {
                readers--;
                if (readers == 0) {
                    canWrite.signal();// Notify writer if no reader left
                }
                System.out.println("End Reading ....");
            } finally {
                lock.unlock();
            }
        }



    }
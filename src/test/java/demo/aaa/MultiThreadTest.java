package demo.aaa;

import com.ycj.reservation.pojo.User;

import java.util.UUID;

public class MultiThreadTest implements Runnable {
    private User user;
    MultiThreadTest(User user){
        this.user = user;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
//            user.setUserID(UUID.randomUUID().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

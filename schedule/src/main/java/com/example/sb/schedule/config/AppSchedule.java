package com.example.sb.schedule.config;

import java.time.LocalDateTime;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppSchedule {  // single thread 
  // Async do it together
  @Scheduled(fixedDelay = 5000) //ms
  @Async
  public void sayHello() throws InterruptedException{
    System.out.println("1: Start" + LocalDateTime.now());
    Thread.sleep(10000);
    System.out.println("1: hello");
    System.out.println("1; End" + LocalDateTime.now());
  }

  @Scheduled(fixedRate = 6000)
  @Async
  public void sayGoodBye() throws InterruptedException{
    System.out.println("2: Start"+ LocalDateTime.now());
    Thread.sleep(10000);
    System.out.println("2: goodbye");
    System.out.println("2; End" + LocalDateTime.now());
  } 
  @Scheduled(cron = "0 44 17 * * MON-FRI") // mon-fri 1744 -> execute.
  @Async
  public void taskRun() {
    System.out.println("excellent");
  } 
}

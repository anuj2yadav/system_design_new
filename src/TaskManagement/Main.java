package TaskManagement;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
       TaskManager taskManager=TaskManager.getInstance();
       User user1=new User("1","User","user1@gmail.com");
       User user2=new User("1","User","user1@gmail.com");

       Task task1=new Task("1","Movie Booking","movie Booking task",(new Date()),1,user1);

       //add task to the task manager
        taskManager.createTask(task1);
        task1.setDescription("new Movie task");
        taskManager.updateTask(task1);


    }



}
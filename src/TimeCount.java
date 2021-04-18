
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class TimeCount {
    
    
    public static void count(int sec){
         Date time  = new Date();
         Date newtime  = new Date();
         if(60-sec<=time.getSeconds())
         {
            while(newtime.getSeconds()==time.getSeconds()-60)
            {
               newtime = new Date();
            }
         }
         else{
            while(newtime.getSeconds()<time.getSeconds()+sec)
            {
               newtime = new Date();
            }

         }
         
    }


}

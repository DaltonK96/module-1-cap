import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger
{
    File log = new File("C:\\Users\\Student\\workspace\\nlr-8-module-1-capstone-orange-team-4\\src\\main\\java\\Log.txt");


    public void log(String toLog)
    {

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(log,true)))
        {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            Date date = new Date();

            logWriter.append(formatter.format(date)+ toLog );
            logWriter.println(" ");


        }catch (FileNotFoundException ex)
        {
            System.out.println("File not found");
        }

    }
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Operations {
    private boolean bool = false;
    private boolean boolqueue= false;
    private ManipulatingStack stack ;
    private ManipulatingQueue queue;
    private int lineNumber = 0;
    public Operations(String path) throws IOException {
        try {
        reader("stack.txt", "stack");
        reader("queue.txt", "queue");
        reader(path,"command");
        updateFiles("stack.txt", ManipulatingStack.getStack().display());
        updateFiles("queue.txt", ManipulatingQueue.getQueue().display()); }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Occurs an error..You have been out of bound the stack or queue."
                    + " Check the command at the " + lineNumber+ "th line on the command.txt ");
        }
        catch (NullPointerException e) {
            System.out.println("One of the stack or queue, or the both is empty ! "
                    + "Check the stack.txt and queue.txt");
        
        }
    }
    private void reader(String path,String data) throws IOException{
        // reads command, stack and queue txts.
            BufferedReader reader = null;
        try {
            FileReader file = new FileReader(path);
            reader = new BufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace("\n","").trim();
                String[] array = line.split(" ");
                if (! line.isEmpty()) {
                if (data.equals("stack")) {
                stack = new ManipulatingStack(array);
                }
                else if (data.equals("queue")) {
                queue = new ManipulatingQueue(array);
                }
                else if (data.equals("command")){
                    ++lineNumber ;
                    whichClassWhichOperation(array);
                    if (array[0].equals("S")) {
                        bool = true;
                    }
                    else if (array[0].equals("Q")) {
                        boolqueue = true;
                    
                    }
                        }
            }

                    }
        }
           
        catch (FileNotFoundException e ) {
            System.err.printf("No such a  %s file..\n", path);
            System.exit(0);
        }
        catch (IOException e){
            System.err.printf("Occurs an error while reading %s file..\n", path);
            System.exit(0);
        }
        finally {
            if (reader != null)
                reader.close();
        }
    }  
    private void writer(String line,String path, boolean b) throws IOException{
        // Writes lines into the file which is given with path.
        FileWriter file = new FileWriter(path + ".txt",b);
        PrintWriter writer = new PrintWriter(file,true);
        writer.println(line);
    }
    private void updateFiles(String path, String line) throws IOException{
        // updates stack and queue.txt 
        FileWriter file = new FileWriter(path,false);
        PrintWriter writer = new PrintWriter(file,true);
        writer.println(line);
    }
    

    private void whichClassWhichOperation(String[] array) throws IOException{
        /* applys relevant methods which is written in command.txt and fills the 
        queueOut.txt and stackOut.txt */
        if (array[0].equals("S")) {
        switch (array[1]) {
             case "removeGreater" :
                 writer(String.format("After removeGreater %s:\n%s"
                       , array[2],stack.removeGreater(Integer.valueOf(array[2]))),"stackOut",bool);
                break; 
            case "calculateDistance" :
                writer(String.format("After calculateDistance:\nTotal distance=%s"
                        ,stack.calculateDistance()),"stackOut",bool);
                break;
            case "reverse" :
                writer(String.format("After reverse %s:\n%s",array[2]
                        , stack.reverse(Integer.valueOf(array[2]))),"stackOut",bool);
                break;
            case "sortElements" :
                writer(String.format("After sortElements:\n%s"
                        ,stack.sortElements()),"stackOut",bool);        
                break;
            case "distinctElements" :
                writer(String.format("After distinctElements:\nTotal distinct element=%s",
                stack.distinctElements()),"stackOut",bool);
                break;
            case "addOrRemove" :
                writer(String.format("After addOrRemove %s:\n%s",array[2],
                stack.addOrRemove(Integer.valueOf(array[2]))),"stackOut",bool);
                break;
        }
    }
        else if (array[0].equals("Q")) {
            switch (array[1]) {
            case "removeGreater" :
                writer(String.format("After removeGreater %s:\n%s", array[2],
                queue.removeGreater(Integer.valueOf(array[2]))),"queueOut",boolqueue);
                break; 
            case "calculateDistance" :
                writer(String.format("After calculateDistance:\nTotal distance=%s"
                        ,queue.calculateDistance()),"queueOut",boolqueue);
                break;
            case "reverse" :
                writer(String.format("After reverse %s:\n%s",array[2],
                queue.reverse(Integer.valueOf(array[2]))),"queueOut",boolqueue);
                break;
            case "sortElements" :
                writer(String.format("After sortElements:\n%s"
                        ,queue.sortElements()),"queueOut",boolqueue);
                break;
            case "distinctElements" :
                writer(String.format("After distinctElements:\nTotal distinct element=%s",
                queue.distinctElements()),"queueOut",boolqueue);
                break;
            case "addOrRemove" :
                writer(String.format("After addOrRemove %s:\n%s",array[2],
                queue.addOrRemove(Integer.valueOf(array[2]))),"queueOut",boolqueue);
                break;
        }
        }
        }
}
package client;
import model.*;
import manage.*;


import java.io.*;
import java.net.*;


import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class SampleClient extends Thread
{
    public  static PansCollection pl;
    public static void main(String args[])
    {try {
        try {

            // открываем сокет и коннектимся к localhost:8890
            // получаем сокет сервера
            Socket s = new Socket("localhost", 8891);
            OutputStream os = s.getOutputStream();
            InputStream ins= s.getInputStream();
            String name;
            Scanner in=new Scanner(System.in);
            System.out.println("**Client connected to socket");

            while (true) {
                System.out.println("Enter your name;");
                name=in.nextLine();
                if (name.length() != 0) {
                    try {
                        os.write(name.getBytes("UTF-8"));
                        break;
                    } catch (IndexOutOfBoundsException e) {
                        os.write("noName".getBytes("UTF-8"));

                    }
                }
            }
//            NK.start();
            class ShutdownHook extends Thread {

                public void run() {

                    try {
                        //System.out.println("exit");
                        os.write("closeClient".getBytes("UTF-8"));
                    } catch (Exception e) {
                    }

                }

            }
            ShutdownHook shutdownHook = new ShutdownHook();
            Runtime.getRuntime().addShutdownHook(shutdownHook);
            // берём поток вывода и выводим туда первый аргумент
            // заданный при вызове, адрес открытого сокета и его порт
            //PansCollection pl=new PansCollection();

            pl=Commands.getCollection(os,ins);


            ClientGUI cgui=new ClientGUI(os,ins);
            cgui.start();

            String input;
            while (true) {
                System.out.print("Enter command (enter \"?\" to call up a list of commands): ");
                input = in.nextLine();
                switch (input) {
                    case "":
                        System.out.println("Unknown command");
                        os.write("unk".getBytes("UTF-8"));
                        break;
                    case "?":
                        Commands.help();
                        continue;
                    case "run":
                        Main.goStory();
                        continue;
                    case "q":
                        os.write("closeClient".getBytes("UTF-8"));
                        System.exit(0);
                    default:
                        os.write(input.getBytes("UTF-8"));
                }


                // читаем ответ
                byte buf[] = new byte[1024 * 1024];
                ins.read(buf);
                System.out.println("Waiting for server answer...");
                String retstr = new String(buf, "UTF-8");
                // выводим ответ в консоль
                String[] retmas=retstr.split("\n");
                for(int i=0; i<retmas.length;i++){
                    if(retmas[i].startsWith("<")){
                        try{
                            Parse.deserializeXML(retmas[i]);
                            Pancakes pp=new Pancakes(Parse.Size, Parse.Name, Parse.Id, Parse.Location);
                            //и записать в коллекцию!!
                            System.out.println(pp);
                        }catch(XmlException e){
                            System.out.println(retmas[i]);
                        }
                    }else{
                        System.out.println(retmas[i]);
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println("Server is not avaliable");
            System.exit(1);
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            //System.out.println("init error: "+e);
        }
    }catch (Exception e){
        //e.printStackTrace();
    }
    }
}

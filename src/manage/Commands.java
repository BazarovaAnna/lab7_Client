package manage;
import client.PansCollection;
import model.Pancakes;

import java.io.*;
import java.util.Hashtable;
import java.util.TreeSet;
public  class Commands {
    /**
     * Вызов помощи
     */
    public static PansCollection getCollection(OutputStream os,InputStream ins){
        try {
            PansCollection ppl=new PansCollection();
            //System.out.println("*");
            String re="get_all";
            os.write(re.getBytes("UTF-8"));
            byte buf0[] = new byte[1024 * 1024];
            ins.read(buf0);
            String retstr0 = new String(buf0, "UTF-8");
            // выводим ответ в консоль
            String[] retmas0=retstr0.split("\n");
            for(int i=0; i<retmas0.length;i++){
                if(retmas0[i].startsWith("<")){
                    try{
                        Parse.deserializeXML(retmas0[i]);
                        Pancakes pp=new Pancakes(Parse.Size, Parse.Name, Parse.Id, Parse.Location);
                        ppl.Mo.put(pp.id, pp);

                    }catch(XmlException e){
                        System.out.println(retmas0[i]);
                    }
                }
            }
            /*for (Integer i:new TreeSet<Integer>(ppl.Mo.keySet())) {
                Pancakes pan = ppl.Mo.get(i);
                System.out.println(pan.toString()+pan.location);
            }*/
            return ppl;
            }catch (Exception e) {
                //System.out.println("init error: "+e);
            }
            //System.out.println(pl.Mo.size());
        return null;
    }
    public static String help(){
        System.out.println("Press 'q' to save and exit\n");
        System.out.println("\"save\" to save current collection\n");
        System.out.println("\"clear\" to clean up current collection\n");
        System.out.println('"'+"add_if_min {element}"+'"'+" to add element if value of size is minimal\n");
        System.out.println('"'+"remove_all {element}"+'"'+" to delete all elements equal to given\n");
        System.out.println('"'+"start"+'"'+" to launch a story program\n");
        System.out.println("\"count\" to show a number of items in the collection\n");
        System.out.println("\"get #\" to show an element with introduced index\n");
        System.out.println("\"get_all\" to show all elements of collection\n");
        System.out.println("\"remove #\" to delete an element with introduced index\n");
        return ("Press 'q' to save and exit\n"+
                "\"save\" to save current collection\n"+
                "\"clear\" to clean up current collection\n"+
                '"'+"add_if_min {element}"+'"'+ " to add element if value of size is minimal\n"+
                '"'+"remove_all {element}"+'"'+ " to delete all elements equal to given\n"+
                '"'+"remove_last"+'"'+" to delete last element of collection\n"+
                '"'+"start"+'"'+" to launch a story program\n"+
                "\"count\" to show a number of items in the collection\n"+
                "\"get №\" to show an element with introduced index\n"+
                "\"get_all\" to show all elements of collection\n"+
                "\"remove №\" to delete an element with introduced index\n");
    }
    public static boolean checkString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }
}

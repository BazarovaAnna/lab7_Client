package model;

public class Main {
    public static void goStory(){
        System.out.println("В пьесе участвуют персонажи");
        Karlson c1= new Karlson();
        System.out.println(c1.type+c1);
        Little m1=new Little();
        System.out.println(m1.type+m1);
        FrekenBok f1=new FrekenBok();
        System.out.println(f1.type+f1);
        System.out.println();

        m1.think(true,ActionsAndAll.Mood.PRO_SEBYA,"Надо поговорить об этом с Карлсоном, и как можно скорее!");
        c1.comeTo(true);
        c1.comeThrough(ActionsAndAll.Place.WINDOW, ActionsAndAll.Does.FLY, false);
        c1.comeThrough(ActionsAndAll.Place.DOOR, ActionsAndAll.Does.RING, true, ActionsAndAll.Mood.BESH);

        m1.runToOpen(true);

        f1.stand(true);
        f1.cookPans(ActionsAndAll.Subj.CHICK, true);
        f1.hearVoice(c1, true);
        f1.turn(true,ActionsAndAll.Mood.REZ);
        f1.blub(true);
    }
}

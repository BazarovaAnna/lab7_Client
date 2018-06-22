package CGUI;

import client.ClientGUI;

import java.awt.event.ActionListener;

public class TimerAnima extends javax.swing.Timer {

    public TimerAnima(int delay,Integer size,String type,Integer id) {
        super(delay, new ActionListener(){

            int i = 1;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent actEvt) {
                //System.out.println(Oval.oval.pan);
                for(Oval o:Cartoon.ovals){
                    //System.out.println(o.pan.toString()+" "+o.animation);
                    if(size.equals(0)&&type.equals("ALL")&&id.equals(0)) {
                        if (o.animation > 25) {
                            i = -1;
                        } else if (o.animation < 1) {
                            i = 1;
                        }
                        o.animation += i;
                        ClientGUI.car.repaint();
                    }else if(size.equals(0)&&type.equals("ALL")) {
                        if(id.equals(o.pan.id)){
                            if (o.animation > 25) {
                                i = -1;
                            } else if (o.animation < 1) {
                                i = 1;
                            }
                            o.animation += i;
                            ClientGUI.car.repaint();
                        }
                    }else if(size.equals(0)&&id.equals(0)) {
                        if(type.equals(o.pan.getType())){
                            if (o.animation > 25) {
                                i = -1;
                            } else if (o.animation < 1) {
                                i = 1;
                            }
                            o.animation += i;
                            ClientGUI.car.repaint();
                        }
                    }else if(type.equals("ALL")&&id.equals(0)) {
                        if(size.equals(o.pan.size.sizeNum)){
                            if (o.animation > 25) {
                                i = -1;
                            } else if (o.animation < 1) {
                                i = 1;
                            }
                            o.animation += i;
                            ClientGUI.car.repaint();
                        }
                    }else if(size.equals(0)) {
                        if(type.equals(o.pan.getType())&& id.equals(o.pan.id)){
                            if (o.animation > 25) {
                                i = -1;
                            } else if (o.animation < 1) {
                                i = 1;
                            }
                            o.animation += i;
                            ClientGUI.car.repaint();
                        }
                    }else if(type.equals("ALL")) {
                        if(size.equals(o.pan.size.sizeNum)&& id.equals(o.pan.id)){
                            if (o.animation > 25) {
                                i = -1;
                            } else if (o.animation < 1) {
                                i = 1;
                            }
                            o.animation += i;
                            ClientGUI.car.repaint();
                        }
                    }else if(id.equals(0)) {
                        if(size.equals(o.pan.size.sizeNum)&&type.equals(o.pan.getType())){
                            if (o.animation > 25) {
                                i = -1;
                            } else if (o.animation < 1) {
                                i = 1;
                            }
                            o.animation += i;
                            ClientGUI.car.repaint();
                        }
                    } else {
                        if(id.equals(o.pan.id)&&size.equals(o.pan.size.sizeNum)&&type.equals(o.pan.getType())){
                            if (o.animation > 25) {
                                i = -1;
                            } else if (o.animation < 1) {
                                i = 1;
                            }
                            o.animation += i;
                            ClientGUI.car.repaint();
                        }
                    }
                }
            }
        });



    }

}


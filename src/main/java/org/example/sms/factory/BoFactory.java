package org.example.sms.factory;

import org.example.sms.bo.SuperBo;

public class BoFactory {
    public static BoFactory boFactory;

    public BoFactory(){}

    public static BoFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTypes{

    }

    public SuperBo getBo(BoTypes types){
        switch (types){

        }
        return null;
    }
}

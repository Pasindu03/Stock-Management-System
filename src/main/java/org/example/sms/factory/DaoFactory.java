package org.example.sms.factory;

import org.example.sms.dao.SuperDao;

public class DaoFactory {
    public static DaoFactory factory;

    public DaoFactory(){}

    public static DaoFactory getFactory(){
        return (factory == null) ? factory = new DaoFactory() : factory;
    }

    public enum DaoTypes{

    }

    public SuperDao getDao(DaoTypes types){
        switch (types){

        }
        return null;
    }

}

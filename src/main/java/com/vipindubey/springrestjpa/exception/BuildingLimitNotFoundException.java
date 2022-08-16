package com.vipindubey.springrestjpa.exception;

public class BuildingLimitNotFoundException extends Exception{

    public BuildingLimitNotFoundException(){
        super();
    }

    public BuildingLimitNotFoundException(String message){
        super(message);
    }
}

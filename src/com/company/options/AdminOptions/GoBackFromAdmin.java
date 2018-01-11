package com.company.options.AdminOptions;

public class GoBackFromAdmin extends AdminOption{

    public GoBackFromAdmin(){
        this.optionName = "Go back";
    }


    @Override
    public boolean start() {
        return true;
    }
}

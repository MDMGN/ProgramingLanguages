package com.example.programinglanguages;

import java.util.ArrayList;

public class Data {
    private static Data instancia;
    private static ArrayList<ProgramingLanguages> programingLanguagesList;
    public static Data getInstance(){
        if(instancia==null){
            instancia=new Data();
        }
        return instancia;
    }
    public Data(){
        programingLanguagesList=new ArrayList<ProgramingLanguages>();
        addProgramingLanguages(new ProgramingLanguages(R.string.title_c,"c_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_cpluplus,"cplusplus_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_csharp,"csharp_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_csharp,"java_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_csharp,"js_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_csharp,"php_info_image"));

    }
    public static void inicializarDatos(){
        instancia=null;
    }
    public void addProgramingLanguages(ProgramingLanguages programingLanguages){
        programingLanguagesList.add(programingLanguages);
    }
    public ArrayList<ProgramingLanguages> getProgramingLanguagesList(){
        return programingLanguagesList;
    }
}

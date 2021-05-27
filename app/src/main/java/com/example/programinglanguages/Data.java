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
        addProgramingLanguages(new ProgramingLanguages(R.string.title_c,R.string.c_info,"c_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_cpluplus,R.string.cplusplus_info,"cplusplus_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_csharp,R.string.csharp_info,"csharp_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_java,R.string.java_info,"java_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_javascript,R.string.js_info,"js_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_php,R.string.php_info,"php_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_python,R.string.python_info,"python_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_ruby,R.string.ruby_info,"ruby_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_go,R.string.go_info,"go_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_kotlin,R.string.kotlin_info,"kotlin_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_swift,R.string.swift_info,"swift_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_cobol,R.string.cobol_info,"cobol_info_image"));
        addProgramingLanguages(new ProgramingLanguages(R.string.title_pascal,R.string.pascal_info,"pascal_info_image"));

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

package ru.ezikvice.springotus.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.ezikvice.springotus.service.LoadService;

@ShellComponent
public class Commands {
    private final LoadService loadService;

    @Autowired
    public Commands(LoadService loadService) {
        this.loadService = loadService;
    }

    @ShellMethod(key = {"help", "h"})
    public String help() {

        return "dftgsdfg";
    }



}
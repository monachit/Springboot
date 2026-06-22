package com.example.tp3.service;

import com.example.tp3.dao.CommandDao;
import org.springframework.stereotype.Service;

@Service
public class CommandService {
    private CommandDao commandDao;

    public CommandService(CommandDao commandDao) {
        this.commandDao = commandDao;
    }

    public int save(CommandDao commandDao)
    {
        
        return 1;
    }
}

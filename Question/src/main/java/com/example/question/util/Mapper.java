package com.example.question.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class Mapper {

   private  ModelMapper mapper = new ModelMapper();



    // Преобразует entyty в dto для отдачи пользователю
    public <T,S> T mapper(S source, Class<T> tClass){

        return mapper.map(source,tClass);
    }
}

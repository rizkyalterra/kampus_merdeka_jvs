package com.alterra.kelasd.service.hello;

import com.alterra.kelasd.repository.hello.Hello;
import com.alterra.kelasd.repository.hello.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloRepository repository;

    @Override
    public MHello getHello(){
        MHello mHello = new MHello();
        mHello.setHello("Hello World");
        return mHello;
    }

    @Override
    public MHello insertHello(MHello helloInput) {

        Hello hello = new Hello();
        hello.setHello(helloInput.getHello());
        repository.save(hello);

        // logic busines

        helloInput.setId(hello.getId());
        return helloInput;
    }

    @Override
    public List<MHello> getAllHello(){
        List<MHello> data = new ArrayList<>();

        // db
        Iterable<Hello> result = repository.findAll();

        // mapping
        MHello mHello = new MHello();
        for (Hello hello: result) {
            mHello = new MHello();
            mHello.setId(hello.getId());
            mHello.setHello(hello.getHello());
            data.add(mHello);
        }

        return data;
    }
}

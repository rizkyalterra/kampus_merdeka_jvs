package com.alterra.kelasd.service.hello;

import java.util.List;


public interface HelloService {
    List<MHello> getAllHello();
    MHello getHello();
    MHello insertHello(MHello hello);
}

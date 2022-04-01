package com.alterra.kelasd.controller.hello;

import com.alterra.kelasd.controller.base.MBaseResponse;
import com.alterra.kelasd.controller.hello.dto.request.Hello;
import com.alterra.kelasd.service.hello.HelloService;
import com.alterra.kelasd.service.hello.MHello;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/messages")
public class HelloController {

    @Autowired
    private HelloService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<MBaseResponse<List<MHello>>> getHello(){
        // response
        MBaseResponse baseResponse = new MBaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Berhasil");
        baseResponse.setData(service.getAllHello());
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<MBaseResponse> insertHello(@Valid @RequestBody Hello helloInput){
        // response
        MBaseResponse baseResponse = new MBaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Berhasil");

//        // validasi
//        if (helloInput.getHello() == "" || helloInput.getHello() == null) {
//            baseResponse.setSuccess(false);
//            baseResponse.setMessage("Hello kosong");
//            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
//        }

//        MHello mHello = new MHello();
//        mHello.setHello(helloInput.getHello());
        // konversi dari dto input model service
        MHello mHello = mapper.map(helloInput, MHello.class);

        baseResponse.setData(service.insertHello(mHello));

        //
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }


}

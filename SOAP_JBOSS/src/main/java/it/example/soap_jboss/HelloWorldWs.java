package it.example.soap_jboss;

import javax.jws.WebService;

@WebService
public class HelloWorldWs{
    public String sayHello(String name){
        return "Hello "+name+"!";
    }
}

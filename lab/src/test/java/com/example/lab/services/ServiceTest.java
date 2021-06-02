package com.example.lab.services;

import com.example.lab.models.mainModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ServiceTest {
    Service service =new Service();
    mainModel m=new mainModel();
    String txt="Code";
    String initial="hello";
    String exp="khoor";
    String real;

    @Test
    void numberOperation()
    {
        m.setStr1(initial);
        service.numberOperation(txt, m);
        real=m.getDecstr();
        assertEquals(exp, real);
    }

}
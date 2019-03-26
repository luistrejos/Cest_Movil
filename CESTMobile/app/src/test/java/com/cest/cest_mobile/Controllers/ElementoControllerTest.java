package com.cest.cest_mobile.Controllers;

import com.cest.cest_mobile.Database.CestMovilDB;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementoControllerTest {

    private CestMovilDB db;
    private ElementoController elmtCtrl;

    @Before
    public void setUp() throws Exception {
        db = new CestMovilDB(null);
        elmtCtrl = new ElementoController(db);
        elmtCtrl.Crear("34","Extintor","B");
    }

    @Test
    public void buscarIdTest(){
        String[] esperado = {"34","Extintor","B"};
        String[] actual = elmtCtrl.buscarId("34");
        assertEquals("Prueba exitosa",esperado, actual);
    }
}
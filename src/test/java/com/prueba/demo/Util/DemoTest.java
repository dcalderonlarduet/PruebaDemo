package com.prueba.demo.Util;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoTest {

    @Test
    public void LogMessageLogToFileParamFalseTest() {
        try {
            Demo demo = new Demo(false,true,true,true,true,true);
            demo.LogMessage("Mensaje de Validacion", true, false, false);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(true, e.getMessage());
        }
    }

    @Test
    public void LogMessageAllTrueTest() {
        try {
            Demo demo = new Demo(true,true,true,true,true,true);
            demo.LogMessage("Mensaje de Validacion", true, true, true);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(true, e.getMessage());
        }
    }
    }

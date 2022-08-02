package com.example.demo.lul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Slf4j
@Component
public class Testt implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("Executing commands one");
        System.out.println(execCmd("cd \"/opt\" && pwd"));
        log.info("Executing commands two");
        System.out.println(execCmd("/bin/bash -c \"cd /opt && pwd\""));
        log.info("Executing commands three");
        String[] commands = {"/bin/bash", "-c", "cd /opt && pwd"};
        System.out.println(execCmd(commands));
        log.info("Done");
    }

    public String execCmd(String[] cmd) {
        String result = null;
        try (InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
             Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
            result = s.hasNext() ? s.next() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String execCmd(String cmd) {
        String result = null;
        try (InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
             Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
            result = s.hasNext() ? s.next() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

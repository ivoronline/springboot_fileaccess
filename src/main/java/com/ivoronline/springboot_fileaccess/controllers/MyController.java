package com.ivoronline.springboot_fileaccess.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@RestController
public class MyController {

  @RequestMapping("/Hello")
  public String hello() throws FileNotFoundException {
    return readFileBad();
  }

  //==================================================================================
  // READ FILE BAD
  //==================================================================================
  private String readFileBad() throws FileNotFoundException {
    FileReader     fileReader = new FileReader("src/main/resources/Test.txt");
  //FileReader     fileReader = new FileReader("/Test.txt");        //Root of JAR still not working
    BufferedReader reader     = new BufferedReader(fileReader);
    String         content    = reader.lines().collect(Collectors.joining(System.lineSeparator()));
    return content;
  }

  //==================================================================================
  // READ FILE GOOD
  //==================================================================================
  private String readFileGood() throws FileNotFoundException {
    InputStream    inputStream = getClass().getResourceAsStream("/Test.txt");
    BufferedReader reader      = new BufferedReader(new InputStreamReader(inputStream));
    String         content     = reader.lines().collect(Collectors.joining(System.lineSeparator()));
    return content;
  }

}

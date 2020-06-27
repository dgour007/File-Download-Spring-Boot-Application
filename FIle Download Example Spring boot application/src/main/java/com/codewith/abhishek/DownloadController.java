package com.codewith.abhishek;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class DownloadController {


    @RequestMapping("/home")
    public String home(){
        return "home";
    }


    @RequestMapping(value = "/don", method = RequestMethod.GET)
    ResponseEntity<InputStreamResource> download(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"codewithabhishek.pdf\"");
        InputStream is = new ClassPathResource("static/image/codewithabhishek.pdf").getInputStream();
        InputStreamResource inputStream = new InputStreamResource(is);
        return ResponseEntity.ok(inputStream);
    }


}

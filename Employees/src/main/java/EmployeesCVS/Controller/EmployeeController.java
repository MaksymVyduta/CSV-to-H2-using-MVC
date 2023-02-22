package EmployeesCVS.Controller;


import EmployeesCVS.Helper.CSVHelper;
import EmployeesCVS.model.Employees;
import EmployeesCVS.repository.EmployeesRepo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import java.io.*;
import java.util.List;


@Controller
public class EmployeeController {
     private EmployeesCVS.repository.EmployeesRepo EmployeesRepo;
      @Autowired
       public void EmployeeCont  (EmployeesRepo EmployeesRepo)
     { this.EmployeesRepo = EmployeesRepo; }

    @RequestMapping("/")

    public String sendCSV()
    { return "Start";}


    @PostMapping("/upload")

    public String   handleFile(@RequestPart(name = "fileupload") MultipartFile file, Model model) {
        final  String UploadPath= "src/main/resourcesstatic/uploads/";
        File uploadDirectory = new File(UploadPath);
        uploadDirectory.mkdirs();

        try {  File checkIfExist = new File ("src/main/resourcesstatic/uploads/Employees.csv");
            checkIfExist.delete();

            File formFile = new File(UploadPath + file.getOriginalFilename());
            OutputStream outputStream = new FileOutputStream(formFile);
            InputStream inputStream = file.getInputStream();
            IOUtils.copy(inputStream, outputStream);
            outputStream.close();
            inputStream.close();

            File newfile = new File ("src/main/resourcesstatic/uploads/Employees.csv");
           formFile.renameTo(newfile);


        } catch (IOException e) {
            e.printStackTrace();
            return "Wrong" ;
        }
        try {
            List<Employees> employees = CSVHelper.csvToEmployees();
        }
      catch (RuntimeException e )
      {e.printStackTrace();
      return "Wrong"; }
        List<Employees> employees = CSVHelper.csvToEmployees();
        model.addAttribute( "AllEmpl",  EmployeesRepo.saveAll(employees));
        return "Employees";
    }




       @GetMapping("/delete" )

      public String delete ( Integer id, Model model){
           EmployeesRepo.deleteById(id);
         model.addAttribute( "AllEmpl",  EmployeesRepo.findAll());
         return "Employees";}

}


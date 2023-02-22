# Instruction:
Open the webpage at http://localhost:9099/ and upload a CSV file. 
You can use the sample files Employees.csv and Employees2.csv, which are included in this repository.

The app is built on the Model-View-Controller (MVC) architectural/design pattern.

Here's how it works:
1) The application downloads the file uploaded by the user and saves it as "Employees". If a file with the same name already exists, it will be deleted and replaced with the new one.
2) The application reads the data from the file and creates an ArrayList of objects.
3) The application adds the objects from the ArrayList as records to the database.
4) If something goes wrong, the application prompts the user to re-upload the file.
Exceptions are handled when it's impossible to read data from the file or when a file is uploaded in a format other than CSV.

# UserManagementSystem
This mini project is created for general users use it. The project development plan starts from 10th Oct 2020 to 20th Oct 2020.

##### 1.  Source code in a github repository
    https://github.com/Viney-Vean/UserManagementSystem
    
##### 2.  How to compile and run your code on a Linux machine
    1. Ubuntu OS 20.04:
        Dowload from link: https://ubuntu.com/download/desktop/thank-you?version=20.04.1&architecture=amd64#download
        How to Install: https://help.ubuntu.com/lts/installation-guide/index.html
        
    2. Install Java version 15:
        Download from link: https://www.oracle.com/java/technologies/javase-jdk15-downloads.html
        
    3. Downloadn IntelliJ IDE:
        Download from link: https://www.jetbrains.com/idea/download/#section=linux
        How to install:
            IntelliJ IDEA is also available as a snap package. If you’re on Ubuntu 16.04 or later, you can install IntelliJ IDEA from the command line.
            
            sudo snap install intellij-idea-community --classic
            
            or
            
            sudo snap install intellij-idea-ultimate --classic
            
            or
            
            sudo snap install intellij-idea-educational --classic
            
    4. How to Compile and build applications with IntelliJ IDEA
        Link: https://www.jetbrains.com/help/idea/compiling-applications.html
            
##### 3.  Instructions and materials 
    External Library: the libraries below were included in file pom.xml
    
    1. Encode UTF-8:
        Link: https://maven.apache.org/general.html#encoding-warning 
        
    2. Used library jackson-annotations:
        Link: https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
        
    3. Used library jackson-databind:
        Link: https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
        
    4.  Used library maven-compiler-plugin:
         Link: https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin
         
    5. Used library lombok:
        Link: https://mvnrepository.com/artifact/org.projectlombok/lombok

##### 4.  About GitHub

    1. Create your software project locally
    
    2. Create a github repo using web UI  (Without README, License and .gitignore)
    
    3. Open a terminal In your local project
     cd /<your project>
     git init
     Add a .gitignore file (see notes below)
    
    4. Add a README file
     touch README.md
     git add README.md
     git commit -m "first commit"
    
    5. Add Remote Repository
     git remote add origin https://github.com/Viney-Vean/UserManagementSystem.git
     git push -u origin master
    
    6. Add a Licence file, named LICENSE.md (from http://choosealicense.com/licenses/)
     git commit -m "added ..... What we did, Wy we Did it, Reference materials"
     
 
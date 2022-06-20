/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berdan
 */
public class User {
    private String name;
    private String surname;
    private String email;
    private String userName;
    private String password;
    private String adress;
   
    public File userFile;
     public File postFile;

    public File getUserFile() {
        return userFile;
    }

    public void setUserFile(File userFile) {
        this.userFile = userFile;
    }

    public File getPostFile() {
        return postFile;
    }

    public void setPostFile(File postFile) {
        this.postFile = postFile;
    }
    
   
  
   
 
    
    public User(String name,String surname,String email,String userName,String password,String adress,int mode){
    this.name=name;
    this.surname = surname;
    this.email = email;
    this.userName = userName;
    this.password = password;
    this.adress = adress;
   
    this.userFile = new File(email+".txt"); 
    this.postFile = new File(email+"post.txt");
    if(!this.userFile.exists()){
        try{
            userFile.createNewFile();
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
            
        }
    }
    if(!this.postFile.exists()){
        try{
            postFile.createNewFile();
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
            
        }
    }
    if(mode== 0){
         writeUserInfostoTxt();
         writePostoTxt();
    }
       
    
    }
    
    public User(){
        
    }
     
    
    
     public void viewProfile(){ //!!
        // You must fill this section
        
        //aşağıda farklı adla oluşturdum.
        //readermy post ve readersearchpost adında.
    }
   
   
    public void signUp(String name,String surname,String email,String userName,String password,String adress){  
      
        User user = new User(name,surname,email,userName,password,adress,0);
        
     
        
        
    }
     
    
    public void  addPost(String post){//!!
        try {
            FileOutputStream fos = new FileOutputStream(this.postFile,true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            
          
            String line  ="";
            line +=post+",";
            bw.write(line);
            bw.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
       
    }
    
    
    
    
    public void writeUserInfostoTxt(){
        try {
            FileOutputStream fos = new FileOutputStream(this.userFile);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String line  = this.name+","+this.surname+","+this.email+","+this.password+","+this.userName+","+this.adress;
            bw.write(line);
            bw.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void writePostoTxt(){
        try {
            FileOutputStream fos = new FileOutputStream(this.postFile,true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String line  = "";
            bw.write(line);
            bw.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    public void ReaderUser() throws FileNotFoundException, IOException{
        FileReader fReader = new FileReader(this.userFile);
        String line;
        BufferedReader bReader = new BufferedReader(fReader);
       while((line=bReader.readLine())!=null){
          System.out.println(line); 
       }
            
            
    }
        public void ReaderMyPost() throws FileNotFoundException, IOException{
        FileReader fReader = new FileReader(this.postFile);
        String line;
        BufferedReader bReader = new BufferedReader(fReader);
       while((line=bReader.readLine())!=null){
          System.out.println(line); 
       }
            
            
    }
    public void ReaderSearchPost(String email) throws FileNotFoundException, IOException{
        FileReader fReader = new FileReader(email+"post.txt");
        String line;
        BufferedReader bReader = new BufferedReader(fReader);
       while((line=bReader.readLine())!=null){
          System.out.println(line); 
       }     
            
    }
    
            public static Scanner x;
                
                
    public  boolean login(String email,String password){
        boolean found =false;
        boolean a =true;
        String tempEmail = "";
        String tempPassword = "";
        
        try{
           
            x=new Scanner(new File(email+".txt"));
            
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !found){
                tempEmail = x.next();
                tempPassword = x.next();
                
                if(tempEmail.trim().equals(email.trim()) && tempPassword.trim().equals(password.trim())){
                    found =true;
                    a = true;
                      
                  
                }else{
                   
                    a = false;
                }
                
            }
            if(a==false){
                 System.out.println("Kullanıcı adı ve şifre eşleşmiyor..");
            }
            
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
            a = false;
         System.out.println("Kullanıcı adı ve şifre eşleşmiyor..");
        }
        return a;
        
    }
    
        
    
    
    
    public String getName(){
        
        return this.name;
    }
    public String getSurname(){
        return this.surname;
       
    }
    public String getEmail(){
        return this.email;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public String getAdress(){
        return this.adress;
    }

   

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

  

    void signUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

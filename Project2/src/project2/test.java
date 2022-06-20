/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static project2.User.x;

/**
 *
 * @author berdan
 */
public class test {
private static Scanner x;

    public static void makePost(User u ,String p ){
            u.addPost(p);
        }
    public static void viewTimeLine(User u){
           
       } 
    
    
    public static void main(String [] args) throws IOException{
        User operations = new User();
        User girisYapmisKullanici = new User("","","","","","",0);
          Scanner input  = new Scanner(System.in);
                          boolean found =false;
                          
                          String name1="";
                          String surname1="";
                        String email1="";
                        String userName1="";
                         String password1="";
                        String adress1 = "";

         
         boolean kontrol = true;
        while (kontrol){
             System.out.println("Berdan.com'a hoşgeldiniz.Lütfen giriş yapmak için 1 i kayıt olmak için 2 yi seçiniz.");
            
            int kullaniciSecimi = input.nextInt(); 
             if(kullaniciSecimi == 1){
                 System.out.println("Lütfen eposta adresinizi giriniz");
                 String email = input.next();
                 System.out.println("Lütfen şifrenizi giriniz.");
                String sifre = input.next();
                
                    System.out.println("Yönlendiriliyorsunuz..");
                    
                  if(operations.login(email, sifre)) {
                      
                      kontrol = false;
                        
                      
                      try{
           
            x=new Scanner(new File(email+".txt"));
        
              File userFile = new File(email+".txt");           
              File postFile  = new File(email+"post.txt");
                      
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                name1 = x.next();
                surname1 = x.next();
                email1 = x.next();
                userName1 = x.next();
                password1=x.next();
                adress1=x.next();
            }
                        girisYapmisKullanici.setName(name1);
                        girisYapmisKullanici.setSurname(surname1);
                        girisYapmisKullanici.setEmail(email);
                        girisYapmisKullanici.setUserName(userName1);
                        girisYapmisKullanici.setPassword(password1);
                        girisYapmisKullanici.setAdress(adress1);
                        girisYapmisKullanici.setPostFile(postFile);
                        girisYapmisKullanici.setUserFile(userFile);
                      }
            catch(Exception e){
                    System.out.println(e.getMessage());
                    }
                      
                      
                      
                      
                  }else {
                      kontrol = true;
                  }
                    
                   
                    
                    
               
             }
             
             if(kullaniciSecimi == 2){
                 
        System.out.println("Enter name");
        String name = input.next();
        System.out.println("Enter surname");
        String surname =input.next();
        System.out.println("Enter email ");
        String email =input.next();
        System.out.println("Enter username  ");
        String userName =input.next();
        System.out.println("Enter password");
        String password =input.next();
                 System.out.println("Enter adress");
                 String adress = input.next();
            operations.signUp(name, surname, email, userName, password, adress);
        
                 System.out.println("Tebrikler kayıt oldunuz.");
             }
        }
        
        
      
        
        
        
        System.out.println("Hoşgeldiniz..");
        while(true){
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz.");
            System.out.println("1-Gönderi Oluşturmak");
            System.out.println("2-Arama Yapma(Profil araması) ");
            System.out.println("3-Profilinize Bakmak ");
            System.out.println("4-Çıkış ");
            int choosedOp = input.nextInt();
            if(choosedOp == 1){
                System.out.println("Lütfen gönderinizi giriniz.");
                String p = input.next();
                girisYapmisKullanici.addPost(p);
                
            }
            else if(choosedOp==2){
                //viewTimeLine(girisYapmisKullanici);
                System.out.println("Lütfen aramak istediğiniz kullanıcının email adresini giriniz.");
                String kgirdisi = input.next();
                girisYapmisKullanici.ReaderSearchPost(kgirdisi);
                
                
            }
            else if(choosedOp==3){
                girisYapmisKullanici.ReaderMyPost();
            }
            else if(choosedOp==4){
              girisYapmisKullanici = null;
              break;
                
                
              // girisYapmisKullanici.ReaderUser();
            }
        }
        
      
    }

   
     
}

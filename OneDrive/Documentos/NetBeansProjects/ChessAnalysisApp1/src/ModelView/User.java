/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelView;

/**
 *
 * @author kamus
 */
public class User {

    private String name;
    private String password;
    
    public User(String name,String password){
         this.name=name;
         this.password=password;
    }
    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public String getPassword(){
        return password;
    }
    

   
}
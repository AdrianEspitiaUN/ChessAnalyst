/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelView;

import Model.FirebaseServices;
import View.AuthView;
import javax.swing.SwingUtilities;
import View.ExercisesView;
import chessapp.ChessAnalystHome;
/**
 *
 * @author kamus
 */
public class AuthController {
    private static String validateName;
    private static String validatePassword;
    public static void loginUser(String userName,String password,AuthView view){
        if(!validateName(userName)){
            view.showErrorMessage(validateName);
            return;
        }else if(!validatePassword(password)){
            view.showErrorMessage(validatePassword);
            return;
        }
        view.showLoadingMessage(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Simulando el proceso de Firebase (puedes reemplazarlo por FirebaseServices.pushUser)
                try {
                    Thread.sleep(20);
                    User user = FirebaseServices.getUser(userName, view);
                    if(user==null){
                        return;
                    }
                    if(user.getPassword().equals(password)){
                        System.out.println("contraseña correcta");
                        view.dispose();
                        SwingUtilities.invokeLater(()-> new ChessAnalystHome().setVisible(true));
                    }else{
                        view.showErrorMessage("Contraseña incorrecta");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    view.showErrorMessage("Error al iniciar sesion.");
                }
            }
        }).start();
        
    }
    public static void registerUser(String userName,String password,AuthView view){
        if(!validateName(userName)){
            view.showErrorMessage(validateName);
            return;
        }else if(!validatePassword(password)){
            view.showErrorMessage(validatePassword);
            return;
        }
        view.showLoadingMessage(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Simulando el proceso de Firebase (puedes reemplazarlo por FirebaseServices.pushUser)
                try {
                    Thread.sleep(20);
                    User user=new User(userName,password);
                    FirebaseServices.pushUser(user, view);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                    view.showErrorMessage("Error registrar el usuario");
                }
            }
        }).start();
        
    }
    public static void errorLogin(String error,AuthView view){
        view.showErrorMessage(error);
    }
   
    private static boolean validateName(String userName){
        int userNameLength=userName.length();
        if(userNameLength<5){
            validateName="El nombre no puede tener menos de 5 caracteres";
            return false;
        }else if(userNameLength>14){
            validateName="El nombre no puede tener más de 14 caracteres";
            return false;
        }
        return true;
    }
    private static boolean validatePassword(String password){
        int passwordLength=password.length();
        if(passwordLength<7){
            validatePassword="La contraseña no puede tener menos de 7 carateres";
            return false;
        }else if(passwordLength>14){
            validatePassword="La contraseña no puede tener más de 14 caracteres";
            return false;
        }
        return true;
    }
    public static void init(){
        FirebaseServices.init();
    }
}
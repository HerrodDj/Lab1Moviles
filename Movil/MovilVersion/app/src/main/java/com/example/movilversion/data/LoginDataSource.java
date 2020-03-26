package com.example.movilversion.data;

import com.example.movilversion.data.Datos.Data;
import com.example.movilversion.data.LogicaNeg.Usuario;
import com.example.movilversion.data.model.LoggedInUser;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            if(this.validUser(username,password)) {
                String nN = this.nombreCompleto(username);
                LoggedInUser newUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                nN);
                return new Result.Success<>(newUser);
           }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
        return null;
    }

    private boolean validUser(String ced, String pass) {
        boolean flag = false;
        for (Usuario user : searchUsers()) {
            if (user.getCedula().equals(ced) && user.getContraseña().equals(pass)) {
                flag = true;
            }
        }
        return flag;
    }

    private ArrayList<Usuario> searchUsers() {
        ArrayList<Usuario> usuariosList = new ArrayList<>();
        usuariosList = new Data().getUsuariosList();
        return usuariosList;
    }

    private String nombreCompleto(String ced){
        ArrayList<Usuario> usuariosList = new Data().getUsuariosList();
        String temp = " ";
        for(int i=0; i<usuariosList.size(); i++){
            if(usuariosList.get(i).getCedula().equals(ced)){
                temp = usuariosList.get(i).nombreCompleto();
                break;
            }
        }
        return temp;
    }

    public void logout() {
        // TODO: revoke authentication
    }
}

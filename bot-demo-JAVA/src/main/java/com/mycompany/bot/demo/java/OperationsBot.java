/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bot.demo.java;

import java.util.ArrayList;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
/**
 *
 * @author Pc
 */
public class OperationsBot extends TelegramLongPollingBot{
    
    @Override
    public String getBotToken() {
        return "2014781268:AAEVJwsyr99zxRwUvmgDVmQjqZWyQBVThT0";
    }
    ArrayList<Integer> Cuentas = new ArrayList<Integer>();
    ArrayList<Usuario> usuariosRegistrados = new ArrayList<Usuario>();
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) { // Verificamos que tenga mensaje
            try{
                Message mensajeRecibido = update.getMessage(); 
                Long userID = mensajeRecibido.getChatId(); //Se obtiene el id del usuario
                SendMessage message = new SendMessage();
                System.out.println("Mensaje: "+mensajeRecibido.getText()+"\nLlego mensaje: " + update.toString());
                boolean flag;
                    Cliente usuariosRegistrados = new Cliente(userID,1); //Obtenemos un objeto tipo Usuario dentro de la list
                    message.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
                    for(int i=0;i<usuariosRegistrados.size();i++){
                        int state=usuariosRegistrados.get(i).getStatus();
                    switch (state){
                    case 1://Usuario o no usuario
                        //No usuario
                        message.setText("Bienvenido al Banco de la Fortuna"+mensajeRecibido.getFrom().getFirstName());
                        if(usuariosRegistrados.contains(usuario.getIdUser().toString())){
                            message.setText("He notado que aún no eres cliente, procedamos a registrarte."+mensajeRecibido.getFrom().getFirstName());
                            usuarios.get(i).setStatus(2);

                         break;
                        }
                        //Si usuario
                        else{   
                            message.setText("Hola de nuevo "+mensajeRecibido.getFrom().getFirstName()+ "!");
                            execute(message);
                            message.setText("Solo por seguridad ¿cuál es tu PIN?");
                            execute(message);
                            usuariosRegistrados.get(i).setStatus(3);
                        }
                        break;
                        case 2: //Recibiendo el mensaje
                        message.setText("¿Cual es tu nombre completo?");
                        usuariosRegistrados.get(i).setNombre(update.getMessage().getText());
                        message.setText("Por favor elige un PIN de seguridad, este te\n" +
                                        "será requerido cada que ingreses al\n" +
                                        "sistema");
                        usuariosRegistrados.get(i).setPinDeSeguridad(update.getMessage().getText());
                        message.setText("Te hemos registrado correctamente!");
                        usuariosRegistrados.get(i).setStatus(1);
                        break;
                        case 3: 
                        try{
                            int pin = Integer.parseInteger(mensajeRecibido.getText());
                            if ((update.getMessage().getText()).equals(usuarios.get(i).getPin())) {
                                    message.setText("Bienvenido");
                                    usuariosRegistrados.get(i).setStatus(4);
                                    break;
                            }
                            else{
                                message.setText("Lo siento, el código es incorrecto");
                            }
                        }catch(NumberFormatException e){
                            usuariosRegistrados.get(i).setStatus(1);
                            break;
                        }
                        flag = true;break;
                        case 4:
                        try{
                            message.setText("Elige una opción:"+mensajeRecibido.getFrom().getFirstName()+"\n"+
                                    "1. Ver Saldo\n" +
                                    "2. Retirar dinero.\n" +
                                    "3. Depositar dinero.\n" +
                                    "4. Crear cuenta\n" +
                                    "5. Salir");
                            if(usuariosRegistrados.contains()){
                                Cuenta cuenta = new Cuenta();
                                if(mensajeRecibido.getText().equals("1")){
                                message.setText("Seleccione una de sus cuentas:\n"+usuariosRegistrados.get(i).getListaDeCuentas());
                                    if(mensajeRecibido.getText().equals(getNroCuenta())){
                                        cuenta.toString();
                                        usuariosRegistrados.get(i).setStatus(4);
                                    }
                                }
                                else if(mensajeRecibido.getText().equals("2")){
                                message.setText("Seleccione una de sus cuentas:\n"+usuariosRegistrados.get(i).getListaDeCuentas());
                                    if(mensajeRecibido.getText().equals(getNroCuenta())){
                                    message.setText("Ingrese el monto a retirar");
                                    double monto = Double.parseDouble(mensajeRecibido.getText());
                                    boolean estado = cuenta.retirar(monto);
                                        if(estado==true){
                                            message.setText("Se realizo el retiro");
                                        }
                                        else{
                                            message.setText("No se realizo el retiro porque el monto a retirar es mayor al monto de la cuenta");
                                        }
                                    }
                                usuariosRegistrados.get(i).setStatus(4);
                                }
                                else if(mensajeRecibido.getText().equals("3")){
                                    message.setText("Seleccione una de sus cuentas:\n"+usuariosRegistrados.get(i).getListaDeCuentas());
                                    message.setText("Ingrese el monto a depositar");
                                    double monto = Double.parseDouble(mensajeRecibido.getText());
                                    boolean estado = cuenta.deposito(monto);
                                    if(estado==true){
                                        message.setText("Se realizo el deposito");
                                    }
                                    else{
                                        message.setText("No se realizo el deposito, porque es un numero negativo");
                                    }
                                    usuariosRegistrados.get(i).setStatus(4);
                                }
                                else if(mensajeRecibido.getText().equals("4")){

                                    usuariosRegistrados.get(i).setStatus(4);
                                }
                                else if(mensajeRecibido.getText().equals("5")){
                                    usuariosRegistrados.get(i).setStatus(1);
                                    break;
                                }
                            }
                            else{
                                message.setText("Usted no tiene cuentas, cree una primero");
                                usuariosRegistrados.get(i).setStatus(4);
                            }
                        break;
                        }catch(NumberFormatException e){
                            System.out.println("Error");
                        }
                        flag = true; i = 0; break;

                        }
                execute(message);
            }
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
    @Override
    public String getBotUsername() {
        return "ucb_natalia_bot";
    }
    public Cliente obtenerUser(Long usuarioID){
        for (Usuario datoUsuario: listaUsuarios) {
            if(datoUsuario.getIdUser().equals(usuarioID)){
                return datoUsuario;
            }
        }
        Usuario usuario = new Usuario(usuarioID);
        listaUsuarios.add(usuario);
        return usuario;
    }
}

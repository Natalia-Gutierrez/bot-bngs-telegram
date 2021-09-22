/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bot.demo.java;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
/**
 *
 * @author Pc
 */
public class OperationsBot extends TelegramLongPollingBot{
    
    public String getBotToken() {
        return "2014781268:AAEVJwsyr99zxRwUvmgDVmQjqZWyQBVThT0";
    }

    public void onUpdateReceived(Update update) {
        System.out.println("Llego mensaje: " + update.toString());
        if(update.hasMessage()) { // Verificamos que tenga mensaje
            // Creo el objeto para enviar un mensaje
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
            message.setText(update.getMessage().getFrom().getFirstName()+", Bienvenid@ al Bot Calculadora\n"
                    + "Seleccione una de las siguientes opciones:"
                    + "\n1. Sumar dos números"
                    + "\n2. Calcular serie de fibonacci."
            );
            try {
                execute(message); // Envia el mensaje
                String m = message.getText();
                if(esEntero(m)==true){
                    int mm=Integer.valueOf(m);
                    if(mm==1){
                        suma(update);
                    }
                    else if(mm==2){
                        fibo(update);
                    }
                    else{
                        message.setText(update.getMessage().getFrom().getFirstName()+" elige una opcion que exista");
                    }
                }
                else{
                    onUpdateReceived(update);
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "ucb_natalia_bot";
    }
    public void suma(Update update){
        try {
            int s,a,b;
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getFrom().getFirstName()+", ingresa el primer número");
            execute(message); // Envia el mensaje
            String at = message.getText();
            if(esEntero(at)==true){
                a=Integer.valueOf(at);
                message.setText(update.getMessage().getFrom().getFirstName()+", ingresa el segundo número");
                execute(message);
                String bt = message.getText();
                if(esEntero(bt)==true){
                    b=Integer.valueOf(at);
                    s=a+b;
                    message.setText("La suma es: "+s);
                }
            }
            onUpdateReceived(update);            
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void fibo(Update update){
        System.out.println("Llego mensaje: " + update.toString());
        if(update.hasMessage()) { // Verificamos que tenga mensaje
            // Creo el objeto para enviar un mensaje
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
            message.setText(update.getMessage().getFrom().getFirstName()+"Funcionalidad no implementada, intente otro día.");
            try {
                execute(message); // Envia el mensaje
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean esEntero(String cad){
        for(int i = 0; i<cad.length(); i++)
        if( !Character.isDigit(cad.charAt(i)) )
        return false;

        return true;
    }
}

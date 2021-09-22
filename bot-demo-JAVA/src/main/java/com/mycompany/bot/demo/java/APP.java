/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bot.demo.java;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
/**
 *
 * @author Pc
 */
public class APP {
    public static void main( String[] args )
    {
        try {
                TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
                telegramBotsApi.registerBot((LongPollingBot) new OperationsBot());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
    }
}

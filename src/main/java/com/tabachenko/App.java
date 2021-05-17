package com.tabachenko;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class App {
    final static Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public ArrayList<ZZR> returnListZzr(String path) throws InvalidObjectException, UnsupportedEncodingException {
        BaseJson baseJson = new BaseJson();

        //читання укр - символів
        ArrayList<ZZR> list = new ArrayList<ZZR>();
        String s = String.valueOf(baseJson.deserializatior(path));
        String s1 = new String(s.getBytes("ISO-8859-1"), "UTF-8");

        ZZR[] taskWorks = GSON.fromJson(s1, ZZR[].class);
        for (ZZR t : taskWorks) {
            ZZR zzr = new ZZR(t.getName(), t.getDv(), t.getVid(), t.getVirobnik(), t.getNormaVneseniy(), t.getKultura(), t.getSpectr());
            list.add(zzr);
        }
        return list;
    }

    public ArrayList<PM> returnListPm(String path) throws InvalidObjectException, UnsupportedEncodingException {
        BaseJson baseJson = new BaseJson();

        //читання укр - символів
        ArrayList<PM> listPm = new ArrayList<PM>();
        String s = String.valueOf(baseJson.deserializatior(path));
        String s1 = new String(s.getBytes("ISO-8859-1"), "UTF-8");

        PM[] taskWorks = GSON.fromJson(s1, PM[].class);
        for (PM t : taskWorks) {
            PM pm = new PM(t.getName(), t.getProducer(), t.getType(), t.getFao(), t.getPrice(), t.getCurrency());
            listPm.add(pm);
        }
        return listPm;
    }

    public List<String> zzRposhukName(Update update) throws InvalidObjectException, UnsupportedEncodingException {
        String pathZZR = "D:\\TelegramTestBotMeven\\dataBase.json";
        String pathPM = "D:\\TelegramTestBotMeven\\dataPM.json";
        String firstChar = update.message().text().substring(0, 3);
        System.out.println(firstChar);
        Message message = update.message();
        App app = new App();
        String sms = null;
        List<String> listGetZzr = new ArrayList<>();
        ArrayList<ZZR> list = null;
        try {
            list = app.returnListZzr(pathZZR);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ArrayList<PM> listGetPm = new ArrayList<>();
        ArrayList<ZZR> listPm = null;
        listGetPm=app.returnListPm(pathPM);


        if (message != null) {
            if (message != null && message.text().toLowerCase().substring(0, 3).equals("ззр")) {
                for (ZZR zzr : list) {
                    if (zzr.getName().toLowerCase().contains(message.text().toLowerCase().substring(4))) {
                  //  if (message.text().toLowerCase().substring(5).contains(zzr.getName().toLowerCase())) {

                        sms = "НАЗВА: " + zzr.getName() + "\n" + "НОРМА ВНЕСЕННЯ: " + zzr.getNormaVneseniy() + "\n"
                                + "ТИП: " + zzr.getVid() + "\n" + "ВИРОБНИК\uD83C\uDFE2: " + zzr.getVirobnik() + "\n" + "ДІЮЧА РЕЧОВИНА\uD83E\uDDEC: "
                                + zzr.getDv() + "\n" + "КУЛЬТУРА\uD83C\uDF3D\uD83C\uDF3B: " + zzr.getKultura() + "\n" + "СПЕКТР ШКІДНИКІВ: " + zzr.getSpectr() + "\n";
                        System.out.println(update.message().from().id());
                        System.out.println(update.message().from().firstName());
                        System.out.println(update.message().from().lastName());
                        Date date = new Date();
                        LocalDate localDate = LocalDate.now();
                        System.out.println(localDate + "/" + date.getHours() + ":" + date.getMinutes());
                        String mestext = update.message().text();
                        System.out.println(update.message().from().firstName() + "" + "\n" + update.message().from().lastName() + "\n" + "" + mestext);
                        System.out.println(sms);
                        System.out.println("___________________");
                        listGetZzr.add(sms);
                    }
                }
            }
            if (message != null && message.text().toLowerCase().substring(0, 2).equals("дв")) {
                for (ZZR zzr : list) {
                    if (zzr.getDv().toLowerCase().contains(message.text().toLowerCase().substring(3))) {
                        sms = "НАЗВА: " + zzr.getName() + "\n" + "НОРМА ВНЕСЕННЯ: " + zzr.getNormaVneseniy() + "\n"
                                + "ТИП: " + zzr.getVid() + "\n" + "ВИРОБНИК\uD83C\uDFE2: " + zzr.getVirobnik() + "\n" + "ДІЮЧА РЕЧОВИНА\uD83E\uDDEC: "
                                + zzr.getDv() + "\n" + "КУЛЬТУРА\uD83C\uDF3D\uD83C\uDF3B: " + zzr.getKultura() + "\n" + "СПЕКТР ШКІДНИКІВ: " + zzr.getSpectr() + "\n";
                        System.out.println(update.message().from().id());
                        System.out.println(update.message().from().firstName());
                        System.out.println(update.message().from().lastName());
                        Date date = new Date();
                        LocalDate localDate = LocalDate.now();
                        System.out.println(localDate + "/" + date.getHours() + ":" + date.getMinutes());
                        String mestext = update.message().text();
                        System.out.println(update.message().from().firstName() + "" + "\n" + update.message().from().lastName() + "\n" + "" + mestext);
                        System.out.println(sms);
                        System.out.println("___________________");
                        listGetZzr.add(sms);
                    }
                }
            }
            if (message != null  && message.text().toLowerCase().substring(0, 2).equals("пм")) {
                for (PM pm : listGetPm) {
                    if (pm.getName().toLowerCase().contains(message.text().toLowerCase().substring(3))) {
                        sms = "НАЗВА: " + pm.getName() + "\n" + "Виробник\uD83C\uDFE2: " + pm.getProducer() + "\n"
                                + "ТИП: " + pm.getType() + "\n" + "Характеристика: " + pm.getFao() + "\n"
                                + "Орієнтована ціна на 2021р: " + pm.getPrice() + "\n"
                                + "Валюта: " + pm.getCurrency() + "\n";
                        System.out.println(update.message().from().id());
                        System.out.println(update.message().from().firstName());
                        System.out.println(update.message().from().lastName());
                        Date date = new Date();
                        LocalDate localDate = LocalDate.now();
                        System.out.println(localDate + "/" + date.getHours() + ":" + date.getMinutes());
                        String mestext = update.message().text();
                        System.out.println(update.message().from().firstName() + "" + "\n" + update.message().from().lastName() + "\n" + "" + mestext);
                        System.out.println(sms);
                        System.out.println("___________________");
                        listGetZzr.add(sms);
                    }
                }
            }
        }

        if (sms == null) {
            listGetZzr.add("По Вашому запиту нічого не знайдено\uD83D\uDE2D " + "\n" +
                    "можливо Ви не вірно написали команду для запиту." + "\n" + "Пошуку по назві препарату: " + "\n"
                    + "ззр напал...." + "\n" + "Пошук по діючій речовині препарату:" + "\n" + "дв гліфо..." +
                    "\n" + "Пошук по назві гібриду (посівний матеріал):" + "\n" + "пм 315..");
            System.out.println(message.chat());
            String firstName = update.message().chat().firstName();
            String secondName = update.message().chat().lastName();
            String mestext = update.message().text();
            Date date = new Date();
            LocalDate localDate = LocalDate.now();
            System.out.println(localDate + "/" + date.getHours() + ":" + date.getMinutes());
            System.out.println(firstName + "" + "\n" + secondName + "\n" + "" + mestext);
        }
        return listGetZzr;
    }


    public static void main(String[] args) {
        App app = new App();
        TelegramBot bot = new TelegramBot("1872031826:AAEZhnxNaGc6dhjVfaMafRz2cYE4quNGDR4");  // Ubot
        bot.setUpdatesListener(updates -> {
            updates.forEach(update -> {
                System.out.println(update.toString());
                try {
                    for (String s : app.zzRposhukName(update)) {
                        bot.execute(new SendMessage(update.message().chat().id(), s));
                    }
                } catch (InvalidObjectException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}



package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main extends TelegramLongPollingBot {
    //JavaeasyBot
    //6230171372:AAEdJc9tfhi_D45k9hth15xIapG9C0OAWQ0
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Main());
    }

    @Override
    public String getBotUsername() {
        return "JavaeasyBot";
    }

    @Override
    public String getBotToken() {
        return "6230171372:AAEdJc9tfhi_D45k9hth15xIapG9C0OAWQ0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);

        SendMessage msg = createMessage("*Hello* Nataliia");
        msg.setChatId(chatId);
        sendApiMethodAsync(msg);

    }
    public Long getChatId(Update update){
        if (update.hasMessage()){
            return update.getMessage().getFrom().getId();
        }
        if (update.hasCallbackQuery()){
            return  update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }
    public SendMessage createMessage(String text){
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setParseMode("markdown");
        return message;

    }
}
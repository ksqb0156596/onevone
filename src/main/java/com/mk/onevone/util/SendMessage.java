package com.mk.onevone.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

public class SendMessage {

    private static SmsSingleSender sender;
    private SendMessage(){}

    public static int send(String phone,String code){
        if(sender == null){
            synchronized (SendMessage.class){
                if(sender == null){
                    try {
                        sender = new SmsSingleSender(1400052576, "78da442596b15ca9b9b392c0bb16a1c7");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        try {
            SmsSingleSenderResult result = sender.send(0, "86", phone, "动态登录码为" + code, "", "");
            return result.result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    public static void main(String[] args) {
        try {
            SmsSingleSender sender = new SmsSingleSender(1400052576, "78da442596b15ca9b9b392c0bb16a1c7");
            SmsSingleSenderResult result = sender.send(0, "86", "13906485173", "动态登录码为1234", "", "");
            System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

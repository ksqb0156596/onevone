package com.mk.onevone.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

public class SendMessage {
    public static void main(String[] args) {
        try {
            SmsSingleSender sender = new SmsSingleSender(1400052576, "78da442596b15ca9b9b392c0bb16a1c7");
            SmsSingleSenderResult result = sender.send(0, "86", "13906485173", "动态验证码为1234", "", "");
            System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

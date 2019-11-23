package com.nfdw.util.qrcode;

import java.net.InetAddress;

public class QrCodeTest {

    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容D:\homework\lastfrom\xzb-zhglpt-sys\src\main\resources\ftl\system\student\admissionTicket.ftl
        String text = "http://192.168.0.7:8083/xzb-zhglpt/studentInformation/getStudentIndex";
//        // 嵌入二维码的图片路径
        InetAddress localHost = InetAddress.getLocalHost();
        System.err.println("localhost："+localHost);
        String imgPath = "";
        // 生成的二维码的路径及名称
        String destPath = "D:/jam.jpg";
        //生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println("二维码已生成");

    }

}


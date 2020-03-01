package com.quaint.algorithm.year2019.verificationCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * @Description: 生成图形化验证码
 * @author: qi cong
 * @Date: Created in 2019-11-13 18:49
 */
public class CreateVerificationCode {

    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private static final int SIZE = 4;
    // 删除线个数
    private static final int LINES = 7;
    //
    private static final int WIDTH = 80;
    private static final int HEIGHT = 40;
    private static final int FONT_SIZE = 30;

    public static Object[] createImage() {
        StringBuffer sb = new StringBuffer();
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphic = image.getGraphics();
        graphic.setColor(Color.WHITE);
        graphic.fillRect(0, 0, WIDTH, HEIGHT);
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int n = random.nextInt(chars.length);
            graphic.setColor(getRandomColor());
            graphic.setFont(new Font(null, Font.BOLD, FONT_SIZE));
            graphic.drawString(chars[n] + "", i*WIDTH/SIZE, HEIGHT * 2 / 3);
            sb.append(chars[n]);
        }
        for (int i = 0; i < LINES; i++) {
            graphic.setColor(getRandomColor());
            graphic.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT), random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
        return new Object[]{sb.toString(), image};
    }

    public static Color getRandomColor() {
        Random random = new Random();
        Color color = new Color(random.nextInt(256),
                random.nextInt(256), random.nextInt(256));
        return color;
    }

    public static void main(String[] args) {

        Object[] image = createImage();
        try {
            System.out.println(image[0]);
            ImageIO.write((BufferedImage) image[1],"png",new FileOutputStream("src/main/java/com/quaint/studyproject/algorithm/algorithm2019/november/verificationCode/test.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

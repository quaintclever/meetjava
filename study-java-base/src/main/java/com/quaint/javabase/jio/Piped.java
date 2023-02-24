package com.quaint.javabase.jio;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 22 January 2021
 */
public class Piped {


    public static void main(String[] args) throws Exception {

        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 输出流 和 输入流 连接
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }

    }

    static class Print implements Runnable {

        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

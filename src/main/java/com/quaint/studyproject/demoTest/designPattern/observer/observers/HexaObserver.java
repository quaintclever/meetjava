package com.quaint.studyproject.demoTest.designPattern.observer.observers;

import com.quaint.studyproject.demoTest.designPattern.observer.Subject;

/**
 * @Description:
 * @author: qicong
 * @Date: Created in 2019/9/16 20:01
 * @Version: 1.0
 */
public class HexaObserver extends Observer{
 
   public HexaObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }
 
   @Override
   public void update() {
      System.out.println( "Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
   }
}
package com.quaint.spring.beans.impl;

import com.quaint.spring.beans.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 20 June 2020
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. music";

    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Play: " + title + " by: " + artist);
    }
}

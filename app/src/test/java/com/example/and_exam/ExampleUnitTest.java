package com.example.and_exam;

import android.app.Application;

import com.example.and_exam.Model.Meme;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Meme meme;

    @Before
    public void setup()
    {
        meme = new Meme("funny title xD", "yes");
    }

    @Test
    public void getTitleOfMeme()
    {
        assertEquals(meme.getTitle(), "funny title xD");
    }

    @Test
    public void getUrlOfMeme()
    {
        assertEquals(meme.getUrl(), "yes");
    }

}


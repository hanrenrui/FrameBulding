/*
 * *
 *  * *******************************************************
 *  *
 *  * @文件名称：ExampleInstrumentedTest.java
 *  * @文件作者：ouyangshengduo Copyright(c) 2017. All rights reserved.
 *  * @创建时间：17-3-25 下午4:24
 *  * @文件描述：
 *  * @修改历史：Last modified 17-3-25 下午4:24 ********************************************************
 *
 */

package oysd.com.oysdlibrary;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("oysd.com.oysdlibrary.test", appContext.getPackageName());
    }
}

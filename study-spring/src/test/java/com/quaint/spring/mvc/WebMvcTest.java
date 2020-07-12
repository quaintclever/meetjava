package com.quaint.spring.mvc;

import com.quaint.spring.controller.IndexController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * <p>
 * desc:
 * </p>
 *
 * @author quaint
 * @since 12 July 2020
 */
public class WebMvcTest {

    @Test
    public void testIndex() {
        IndexController controller = new IndexController();
        assertEquals("index",controller.index());
    }

    @Test
    public void testIndex2() throws Exception {
        IndexController controller = new IndexController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }

}

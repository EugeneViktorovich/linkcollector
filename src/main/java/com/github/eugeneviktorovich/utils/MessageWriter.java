package com.github.eugeneviktorovich.utils;

import org.apache.commons.io.IOUtils;

import java.io.PrintWriter;
import java.util.List;

/**
 * @author Eugene Viktorovich
 */
public class MessageWriter implements Writer {

    private String appOutput;

    public void setAppOutput(String appOutput) {
        this.appOutput = appOutput;
    }

    @Override
    public void write(List<String> messages) {
        PrintWriter out = null;

        try {
            out = new PrintWriter(appOutput, "UTF-8");

            for (String msg : messages) {
                out.append(msg);
                out.println();
            }

            out.close();
        } catch (Exception ex) {
            // ignore exception
        } finally {
            IOUtils.closeQuietly(out);
        }
    }
}

package com.badlogic.utils;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

/**
 * Created by
 * Matthew Fitzpatrick
 * on 15-Dec-2013
 * at 12:26 PM
 */
public class TexturePacker {
    public static void main(String[] args) {
        packPassengers();
    }

    public static void packPassengers() {
        String fileSeparator = System.getProperty("file.separator");
        String rootPath = "desktop" + fileSeparator + "src" + fileSeparator + "main" + fileSeparator + "resources";
        String imagesPath = rootPath + fileSeparator + "passengers" + fileSeparator;
        String texturesPath = rootPath + fileSeparator + "packeroutput" + fileSeparator;

        TexturePacker2.process(
                imagesPath,
                texturesPath,
                "passengers.pack");
    }
}
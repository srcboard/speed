package com.company.settings;

import java.io.File;

public interface IReaderSettings {

    String getProperty(String property);
    String getProperty(String property, PropertyType type);

    static File findConfigurationFile(String nameOfConfigurationFile) {

        String absolutePath = new File(".").getAbsolutePath();

        File internalConfigurationFile = new File(absolutePath + "\\" + nameOfConfigurationFile);
        if (internalConfigurationFile.exists()) {
            return internalConfigurationFile;
        }

        File resourceConfigurationFile = new File(absolutePath + "\\src\\main\\resources\\" + nameOfConfigurationFile);
        if (resourceConfigurationFile.exists()) {
            return resourceConfigurationFile;
        }

        throw new RuntimeException("Configuration file not found");

    }

}
